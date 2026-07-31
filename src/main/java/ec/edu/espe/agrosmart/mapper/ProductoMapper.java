package ec.edu.espe.agrosmart.mapper;


import ec.edu.espe.agrosmart.entity.ProductoEntity;
import ec.edu.espe.agrosmart.domain.Producto;

import java.util.Arrays;
import java.util.List;


public class ProductoMapper {


    public static Producto toDominio(ProductoEntity e){

        List<String> correos =
                e.getCorreosNotificacion()==null ||
                        e.getCorreosNotificacion().isBlank()
                        ?
                        List.of()
                        :
                        Arrays.asList(
                                e.getCorreosNotificacion().split(",")
                        );


        return new Producto(
                e.getIdProducto(),
                e.getNombreProducto(),
                e.getCategoria(),
                e.getPrecioUsd(),
                correos
        );
    }
}