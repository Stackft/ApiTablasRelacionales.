package com.sistema.inventario.producto;

import com.sistema.inventario.categoria.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 128, nullable = false, unique = true)
    private String nombre;

    private float precio;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    List<ProdecutoDetalles> detalles = new ArrayList<>();


    public Producto(String nombre, float precio, Categoria categoria){
        super();
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public Producto(String nombre){
        super();
        this.nombre = nombre;
    }

    public void añadirDetalles(String nombre, String valor){
        this.detalles.add(new ProdecutoDetalles(id, nombre,valor,this));
    }

//quizas faltan getters and setter de detalles

    public void setDetalles(Integer id, String nombre, String valor){
        this.detalles.add(new ProdecutoDetalles(id, nombre, valor, this));
    }

    public Producto(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
