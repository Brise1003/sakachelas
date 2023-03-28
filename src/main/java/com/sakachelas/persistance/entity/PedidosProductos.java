package com.sakachelas.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedidos_has_productos")
public class PedidosProductos {

    @Id
    private int id;

    @Column(name = "pedidos")
    private int idPedidos;

    @Column(name = "productos")
    private int idproductos;
}
