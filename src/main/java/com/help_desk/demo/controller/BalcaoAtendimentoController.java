package com.help_desk.demo.controller;

import com.help_desk.demo.entities.BalcaoAtendimento;
import com.help_desk.demo.entities.Chamado;
import com.help_desk.demo.repositorio.ChamadoRepositorio;
import com.help_desk.demo.service.BalcaoAtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/balcao-atendimento")
public class BalcaoAtendimentoController {

    @Autowired
    private BalcaoAtendimentoService balcaoAtendimentoService;

    @Autowired
    private ChamadoRepositorio chamadoRepositorio;

    @PostMapping
    public BalcaoAtendimento criaBalcaoAtendimento(@RequestBody BalcaoAtendimento balcaoAtendimento) {
       return balcaoAtendimentoService.save(balcaoAtendimento);

    }

    @GetMapping
    public List<BalcaoAtendimento> buscaAtendimento() {
        return balcaoAtendimentoService.findAll();
    }

    @GetMapping("/{id}/chamados")
    public List<Chamado> buscaChamadosPorBalcao(@PathVariable Long id) {
        return balcaoAtendimentoService.findById(id);
    }
}
