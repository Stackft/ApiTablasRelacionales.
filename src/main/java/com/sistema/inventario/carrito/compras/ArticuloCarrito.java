package com.sistema.inventario.carrito.compras;

import com.sistema.inventario.producto.Producto;
import com.sistema.inventario.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "articulo_carrito")
public class ArticuloCarrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public ArticuloCarrito(int cantidad, Producto producto, Usuario usuario) {
        this.cantidad = cantidad;
        this.producto = producto;
        this.usuario = usuario;
    }
}
