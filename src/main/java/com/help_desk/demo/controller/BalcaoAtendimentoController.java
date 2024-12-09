package com.help_desk.demo.controller;

import com.help_desk.demo.entities.BalcaoAtendimento;
import com.help_desk.demo.entities.Chamado;
import com.help_desk.demo.repositorio.ChamadoRepositorio;
import com.help_desk.demo.service.BalcaoAtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
        balcaoAtendimento.setDataHoraAtendimento(LocalDateTime.now());
        BalcaoAtendimento resultado = balcaoAtendimentoService.save(balcaoAtendimento);
        return resultado;

    }

    @GetMapping
    public List<BalcaoAtendimento> buscaAtendimento() {
        List<BalcaoAtendimento> resultado = balcaoAtendimentoService.findAll();
        return resultado;

    }

    @GetMapping("/{id}/chamados")
    public List<Chamado> buscaChamadosPorBalcao(@PathVariable Long id) {
        BalcaoAtendimento balcao = balcaoAtendimentoService.findById(id);
//                .orElseThrow(() -> new RuntimeException("Balcão não encontrado"));
        List<Chamado> chamados = chamadoRepositorio.findByBalcaoAtendimento(balcao);
        return chamados;
    }
}
