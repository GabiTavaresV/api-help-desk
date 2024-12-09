package com.help_desk.demo.controller;


import com.help_desk.demo.entities.Chamado;
import com.help_desk.demo.repositorio.UsuarioRepositorio;
import com.help_desk.demo.service.BalcaoAtendimentoService;
import com.help_desk.demo.service.ChamadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/chamado")
public class ChamadoController {

    @Autowired
    private ChamadoService chamadoService;

    @PostMapping
    public Chamado criaChamado(@RequestBody Chamado chamado) {
        return chamadoService.registraChamado(chamado);
    }

    @GetMapping
    public List<Chamado> buscaChamado() {
        return chamadoService.buscaChamado();
    }

    @PutMapping("/{id}/produto")
    public Chamado atualizaChamado(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        return chamadoService.atualizaChamado(id, updates);
    }
}
