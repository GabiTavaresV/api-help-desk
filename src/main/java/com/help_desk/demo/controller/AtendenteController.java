package com.help_desk.demo.controller;


import com.help_desk.demo.entities.Atendente;
import com.help_desk.demo.entities.Usuario;
import com.help_desk.demo.service.AtendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/atendente")
public class AtendenteController {

    @Autowired
    private AtendenteService atendenteService;


    @PostMapping
    public Atendente criaAtendente(@RequestBody Atendente atendente) {
        Atendente resultado = atendenteService.save(atendente);
        return resultado;
    }

    @GetMapping
    public List<Atendente> buscaAtendentes() {
        List<Atendente> resultado = atendenteService.findAll();
        return resultado;
    }

    @DeleteMapping("/{id}")
    public void deletaAtendente(@PathVariable Long id) {
        atendenteService.delete(id);
    }

    @GetMapping(value = "/{id}")
    public Atendente findById(@PathVariable Long id) {
        return atendenteService.findById(id);
    }
}
