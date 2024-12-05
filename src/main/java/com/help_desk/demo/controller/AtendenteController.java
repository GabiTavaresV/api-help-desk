package com.help_desk.demo.controller;


import com.help_desk.demo.entities.Atendente;
import com.help_desk.demo.entities.Usuario;
import com.help_desk.demo.repositorio.AtendenteRepositorio;
import com.help_desk.demo.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/atendente")
public class AtendenteController {

    @Autowired
    private AtendenteRepositorio atendenteRepositorio;


    @PostMapping
    public Atendente criaAtendente(@RequestBody Atendente atendente) {
        Atendente resultado = atendenteRepositorio.save(atendente);
        return resultado;
    }

    @GetMapping
    public List<Atendente> buscaAtendentes() {
        List<Atendente> resultado = atendenteRepositorio.findAll();
        return resultado;

    }

    @DeleteMapping("/{id}")
    public void deletaAtendente(@PathVariable Long id) {
        atendenteRepositorio.deleteById(id);

    }
}
