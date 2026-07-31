package ec.edu.espe.agrosmart.domain;


import java.util.function.*;


public class ProductoFilters {


    public static Predicate<Producto> IS_VALID =
            p -> p.getPrecioUsd().doubleValue()>0
                    &&
                    !p.getCorreosNotificacion().isEmpty();



    public static Consumer<Producto> LOG_PRODUCTO =
            p -> System.out.println(
                    "Producto procesado: "
                            +p.getId()
                            +" "
                            +p.getNombre()
            );



    public static Function<Producto,Producto> A_MAYUSCULAS =
            p -> new Producto(
                    p.getId(),
                    p.getNombre().toUpperCase(),
                    p.getCategoria(),
                    p.getPrecioUsd(),
                    p.getCorreosNotificacion()
            );

}