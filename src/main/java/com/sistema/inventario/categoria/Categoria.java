package com.sistema.inventario.categoria;

import com.sistema.inventario.marca.Marca;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false, unique = true)
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

    public Categoria(Integer id){
        super();
        this.id = id;
    }

    public Categoria(String nombre){
        super();
        this.nombre = nombre;
    }

    public Categoria(String nombre, Marca marca){
        super();
        this.nombre = nombre;
        this.marca = marca;
    }

    @Override
    public String toString(){
        return nombre;
    }
}
