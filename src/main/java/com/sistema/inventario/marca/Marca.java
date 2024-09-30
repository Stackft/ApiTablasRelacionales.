package com.sistema.inventario.marca;

import com.sistema.inventario.categoria.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, unique = true)
    private String nombre;

    @OneToMany
    @JoinColumn(name = "marca_id")
    private List<Categoria> categorias = new ArrayList<>();

    public Marca(Integer id){
        super();
        this.id = id;
    }

    public Marca(String nombre, List<Categoria> categorias){
        super();
        this.nombre = nombre;
        this.categorias = categorias;
    }
    
}
