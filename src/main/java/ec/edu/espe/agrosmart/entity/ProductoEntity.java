package ec.edu.espe.agrosmart.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_productos_base_35")
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long idProducto;


    @Column(name="nombre_producto",
            length = 120,
            nullable = false,
            unique = true)
    private String nombreProducto;


    @Column(name="precio_usd",
            precision = 10,
            scale = 2)
    private BigDecimal precioUsd;


    @Column(name="stock_kg",
            nullable = false)
    private Integer stockKg;


    @Column(name="categoria",
            length = 40)
    private String categoria;


    @Column(name="correos_notificacion",
            length = 500)
    private String correosNotificacion;


    // Obligatorio para Hibernate
    public ProductoEntity(){}


    public ProductoEntity(
            String nombreProducto,
            BigDecimal precioUsd,
            Integer stockKg,
            String categoria,
            String correosNotificacion
    ){
        this.nombreProducto = nombreProducto;
        this.precioUsd = precioUsd;
        this.stockKg = stockKg;
        this.categoria = categoria;
        this.correosNotificacion = correosNotificacion;
    }


    public Long getIdProducto() {
        return idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public BigDecimal getPrecioUsd() {
        return precioUsd;
    }

    public Integer getStockKg() {
        return stockKg;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getCorreosNotificacion() {
        return correosNotificacion;
    }


    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecioUsd(BigDecimal precioUsd) {
        this.precioUsd = precioUsd;
    }

    public void setStockKg(Integer stockKg) {
        this.stockKg = stockKg;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setCorreosNotificacion(String correosNotificacion) {
        this.correosNotificacion = correosNotificacion;
    }
}