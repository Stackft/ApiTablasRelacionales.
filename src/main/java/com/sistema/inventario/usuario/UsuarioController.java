package com.sistema.inventario.usuario;

import com.sistema.inventario.categoria.Categoria;
import com.sistema.inventario.producto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @GetMapping("/usuarios")
    public String listarUsuarios(Model model){
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        model.addAttribute("listaUsuarios", listaUsuarios);

        return "usuarios";
    }

    @GetMapping("/usuarios/nuevo")
    public String mostrarFormularioDeRegistroDeUsuarios(Model model){
        List<Rol> listaRoles = rolRepository.findAll();
        model.addAttribute("listaRoles", listaRoles);
        model.addAttribute("usuario", new Usuario());
        return "usuario_formulario";
    }

    @PostMapping("/usuarios/guardar")
    public String guardarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String mostrarFormularioDeModificarUsuario(@PathVariable("id") Integer id, Model modelo){
        Usuario usuario = usuarioRepository.findById(id).get();
        modelo.addAttribute("usuario", usuario);

        List<Rol> listaRoles = rolRepository.findAll();
        modelo.addAttribute("listaRoles", listaRoles);

        return "usuario_formulario";
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Integer id, Model modelo){
        usuarioRepository.deleteById(id);
        return "redirect:/usuarios";
    }
}
