package com.sakachelas.persistance.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idProducto;

    @Column(name = "nombre")
    private String nompreProducto;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private String descripcion;

    private String marca;

    private String estilo;

    private BigDecimal precio;

    @Column(name = "cerveceros_id")
    private Integer cerveceroId;

    @ManyToOne
    @JoinColumn(name = "cervecero_id", insertable = false, updatable = false)
    private Cervecero cervecero;

    public Cervecero getCervecero() {
        return cervecero;
    }

    public void setCervecero(Cervecero cervecero) {
        this.cervecero = cervecero;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNompreProducto() {
        return nompreProducto;
    }

    public void setNompreProducto(String nompreProducto) {
        this.nompreProducto = nompreProducto;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Integer getCerveceroId() {
        return cerveceroId;
    }

    public void setCerveceroId(Integer cerveceroId) {
        this.cerveceroId = cerveceroId;
    }
}
