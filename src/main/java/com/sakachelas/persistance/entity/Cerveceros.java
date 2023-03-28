package com.sakachelas.persistance.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cerveceros")
public class Cerveceros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idCervecero;

    @Column(name = "correo")
    private String correoCervecero;

    private String telefono;

    private String marca;

    private String RFC;

    @Column(name = "combre_cervecero")
    private String nombreCervecero;

    @Column(name = "apellido_cervecero")
    private String apellidoCervecero;

    public int getIdCervecero() {
        return idCervecero;
    }

    public void setIdCervecero(int idCervecero) {
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
}
