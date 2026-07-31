package ec.edu.espe.agrosmart.controller;


import ec.edu.espe.agrosmart.domain.Producto;
import ec.edu.espe.agrosmart.service.ProductoService;

import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.*;


@RestController
@RequestMapping("/api/productos")
public class AgroSmartController {


    private final ProductoService service;


    public AgroSmartController(ProductoService service){

        this.service=service;

    }



    @GetMapping
    public Flux<Producto> listar(){

        return service.obtenerProductosComercializables();

    }



    @GetMapping("/{id}")
    public Mono<Producto> buscar(
            @PathVariable Long id){

        return service.buscarPorId(id);

    }


}