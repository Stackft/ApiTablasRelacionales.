package com.sistema.inventario;

import com.sistema.inventario.carrito.compras.ArticuloCarrito;
import com.sistema.inventario.carrito.compras.ArticuloCarritoRespository;
import com.sistema.inventario.producto.Producto;
import com.sistema.inventario.usuario.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@DataJpaTest
public class ArticuloCarritoTests {

    @Autowired
    private ArticuloCarritoRespository respository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testAñadirArticulo(){
        Producto producto = entityManager.find(Producto.class, 1);
        Usuario usuario = entityManager.find(Usuario.class, 7);

        ArticuloCarrito articuloCarrito = new ArticuloCarrito(5,producto,usuario);
        respository.save(articuloCarrito);
    }

    //En este testeo puedes agregar la cantidad de articulos que quieras
    //Como en este momento solo hay uno lo dejo asi
    @Test
    public void testAñadirMultiplesArticulos(){
        Usuario usuario = new Usuario(3);
        Producto producto = new Producto(1);

        ArticuloCarrito articulo1 = new ArticuloCarrito(9,producto,usuario);
        respository.saveAll(List.of(articulo1));
    }

    @Test
    public void testListarArticulos(){
        List<ArticuloCarrito> articulos = respository.findAll();
        articulos.forEach(System.out::println);
    }

    @Test
    public void testActualizarArticulo(){
        ArticuloCarrito articulo = respository.findById(1).get();
        articulo.setCantidad(11);
        articulo.setProducto(new Producto(3));
    }

    @Test
    public void testEliminarArticulo(){
        respository.deleteById(1);
    }
}
