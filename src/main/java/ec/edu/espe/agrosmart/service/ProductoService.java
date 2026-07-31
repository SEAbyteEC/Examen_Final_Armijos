package ec.edu.espe.agrosmart.service;


import ec.edu.espe.agrosmart.domain.ProductoFilters;
import ec.edu.espe.agrosmart.entity.ProductoEntity;
import ec.edu.espe.agrosmart.mapper.ProductoMapper;
import ec.edu.espe.agrosmart.domain.Producto;
import ec.edu.espe.agrosmart.repository.ProductoRepository;
import ec.edu.espe.agrosmart.exception.ProductoNoEncontradoException;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


@Service
public class ProductoService {


    private final ProductoRepository repository;


    // Producto genérico requerido por defaultIfEmpty
    private static final Producto PRODUCTO_GENERICO =
            new Producto(
                    0L,
                    "PRODUCTO NO DISPONIBLE",
                    "GENERAL",
                    java.math.BigDecimal.ZERO,
                    java.util.List.of()
            );


    public ProductoService(ProductoRepository repository){
        this.repository = repository;
    }



    /**
     * Obtiene solamente productos comercializables
     */
    public Flux<Producto> obtenerProductosComercializables(){


        return Mono.fromCallable(repository::findAll)

                /*
                 * JPA/Hibernate es bloqueante.
                 * boundedElastic mueve la ejecución fuera
                 * del event loop de Netty.
                 */
                .subscribeOn(Schedulers.boundedElastic())


                /*
                 * Convierte Mono<List<ProductoEntity>>
                 * en Flux<ProductoEntity>
                 */
                .flatMapMany(Flux::fromIterable)


                /*
                 * Entity mutable -> dominio inmutable
                 */
                .map(ProductoMapper::toDominio)


                /*
                 * Crea un nuevo objeto con nombre mayúscula
                 */
                .map(ProductoFilters.A_MAYUSCULAS)


                /*
                 * Regla de negocio:
                 * precio > 0 y correos existentes
                 */
                .filter(ProductoFilters.IS_VALID)


                /*
                 * Trazabilidad sin modificar datos
                 */
                .doOnNext(ProductoFilters.LOG_PRODUCTO)


                /*
                 * Si todos fueron inválidos,
                 * devuelve producto genérico
                 */
                .defaultIfEmpty(PRODUCTO_GENERICO);

    }




    /**
     * Buscar producto por ID
     */
    public Mono<Producto> buscarPorId(Long id){


        return Mono.fromCallable(() ->
                        repository.findById(id)
                )


                /*
                 * Consulta JPA fuera del event loop
                 */
                .subscribeOn(Schedulers.boundedElastic())


                /*
                 * Optional vacío -> Mono vacío
                 */
                .flatMap(Mono::justOrEmpty)


                /*
                 * Entity -> dominio
                 */
                .map(ProductoMapper::toDominio)


                /*
                 * Si no existe lanza error reactivo
                 */
                .switchIfEmpty(
                        Mono.error(
                                new ProductoNoEncontradoException(id)
                        )
                );

    }

}