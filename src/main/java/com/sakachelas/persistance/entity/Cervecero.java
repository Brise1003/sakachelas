package com.sakachelas.persistance.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cerveceros")
public class Cervecero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cervecero")
    private Integer idCervecero;

    @Column(name = "correo")
    private String correoCervecero;

    private String telefono;

    private String marca;

    private String RFC;

    @Column(name = "nombre_cervecero")
    private String nombreCervecero;

    @Column(name = "apellido_cervecero")
    private String apellidoCervecero;

    @OneToMany(mappedBy = "cervecero")
    private List<Producto> productos;

    public Integer getIdCervecero() {
        return idCervecero;
    }

    public void setIdCervecero(Integer idCervecero) {
        this.idCervecero = idCervecero;
    }

    public String getCorreoCervecero() {
        return correoCervecero;
    }

    public void setCorreoCervecero(String correoCervecero) {
        this.correoCervecero = correoCervecero;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getNombreCervecero() {
        return nombreCervecero;
    }

    public void setNombreCervecero(String nombreCervecero) {
        this.nombreCervecero = nombreCervecero;
    }

    public String getApellidoCervecero() {
        return apellidoCervecero;
    }

    public void setApellidoCervecero(String apellidoCervecero) {
        this.apellidoCervecero = apellidoCervecero;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
