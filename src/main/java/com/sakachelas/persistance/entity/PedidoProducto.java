package com.sakachelas.persistance.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "pedidos_has_productos")
public class PedidoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pedidos_productos")
    private Integer id;

    @Column(name = "pedido")
    private Integer idPedido;

    @Column(name = "producto")
    private Integer idproducto;

    private Integer cantidad;

    private BigDecimal totalcerveza;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto producto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotalcerveza() {
        return totalcerveza;
    }

    public void setTotalcerveza(BigDecimal totalcerveza) {
        this.totalcerveza = totalcerveza;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
