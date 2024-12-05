package com.help_desk.demo.controller;

import com.help_desk.demo.entities.Usuario;
import com.help_desk.demo.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @PostMapping
    public Usuario criaUsuarios(@RequestBody Usuario usuario) {
        Usuario resultado = usuarioRepositorio.save(usuario);
        return resultado;

    }

    @GetMapping
    public List<Usuario> buscaUsuarios() {
       List<Usuario> resultado = usuarioRepositorio.findAll();
       return resultado;

    }

    @GetMapping(value = "/{id}")
    public Usuario buscaUsuariosPorId(@PathVariable Long id) {
        Usuario resultado = usuarioRepositorio.findById(id).get();
        return resultado;

    }
}
