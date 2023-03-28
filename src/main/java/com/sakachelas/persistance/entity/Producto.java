package com.sakachelas.persistance.entity;

import jakarta.persistence.*;

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

    private double precio;

    private Integer cerveceros_id;

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Integer getCerveceros_id() {
        return cerveceros_id;
    }

    public void setCerveceros_id(Integer cerveceros_id) {
        this.cerveceros_id = cerveceros_id;
    }
}
