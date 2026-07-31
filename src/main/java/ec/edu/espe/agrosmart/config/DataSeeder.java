package ec.edu.espe.agrosmart.config;

import ec.edu.espe.agrosmart.entity.ProductoEntity;
import ec.edu.espe.agrosmart.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductoRepository repository;

    public DataSeeder(ProductoRepository repository) {
        this.repository = repository;
    }


    @Override
    public void run(String... args) {

        if(repository.count() == 0){

            // 3 PRODUCTOS VALIDOS
            repository.save(new ProductoEntity(
                    "Banano organico Cavendish Premium",
                    new BigDecimal("45.50"),
                    500,
                    "Banano",
                    "ventas@agrosmart.ec"
            ));


            repository.save(new ProductoEntity(
                    "Banano exportacion calidad A",
                    new BigDecimal("60.00"),
                    700,
                    "Banano",
                    "exportaciones@agrosmart.ec"
            ));


            repository.save(new ProductoEntity(
                    "Banano natural sostenible",
                    new BigDecimal("35.75"),
                    300,
                    "Banano",
                    "clientes@agrosmart.ec"
            ));


            // INVALIDO: precio = 0
            repository.save(new ProductoEntity(
                    "Banano muestra gratuita",
                    BigDecimal.ZERO,
                    100,
                    "Banano",
                    "ventas@agrosmart.ec"
            ));


            // INVALIDO: sin correos
            repository.save(new ProductoEntity(
                    "Banano sin notificacion",
                    new BigDecimal("20.00"),
                    150,
                    "Banano",
                    ""
            ));

        }
    }
}