package com.sistema.inventario.producto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "producto_detalles")
public class ProdecutoDetalles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, unique = true)
    private String nombre;

    @Column(length = 45, nullable = false, unique = true)
    private String valor;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Override
    public String toString(){
        return nombre + " - " + valor;
    }

}
