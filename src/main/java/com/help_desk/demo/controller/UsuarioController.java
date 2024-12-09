package com.help_desk.demo.controller;

import com.help_desk.demo.entities.Usuario;
import com.help_desk.demo.exception.UsuarioException;
import com.help_desk.demo.repositorio.UsuarioRepositorio;
import com.help_desk.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public Usuario criaUsuarios(@RequestBody Usuario usuario) {
        Usuario resultado = usuarioService.save(usuario);
        return resultado;

    }

    @GetMapping
    public List<Usuario> buscaUsuarios() {
        List<Usuario> resultado = usuarioService.findAll();
        return resultado;

    }

    @GetMapping(value = "/{id}")
    public Usuario buscaUsuariosPorId(@PathVariable Long id) {
        return usuarioService.findById(id);
    }
}
