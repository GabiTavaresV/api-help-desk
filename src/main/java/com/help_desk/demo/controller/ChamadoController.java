package com.help_desk.demo.controller;


import com.help_desk.demo.entities.BalcaoAtendimento;
import com.help_desk.demo.entities.Chamado;
import com.help_desk.demo.entities.Usuario;
import com.help_desk.demo.repositorio.BalcaoAtendimentoRepositorio;
import com.help_desk.demo.repositorio.ChamadoRepositorio;
import com.help_desk.demo.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/chamado")
public class ChamadoController {

    @Autowired
    private ChamadoRepositorio chamadoRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BalcaoAtendimentoRepositorio balcaoAtendimentoRepositorio;

    @PostMapping
    public Chamado criaChamado(@RequestBody Chamado chamado) {
        Usuario usuario = usuarioRepositorio.findById(chamado.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        chamado.setUsuario(usuario);

        BalcaoAtendimento balcaoAtendimento = balcaoAtendimentoRepositorio.findById(chamado.getBalcaoAtendimento().getId())
                .orElseThrow(() -> new RuntimeException("Balcão de Atendimento não encontrado"));

        int novaQuantidade = (balcaoAtendimento.getQuandidateAtendimento() == null ? 0 : balcaoAtendimento.getQuandidateAtendimento()) + 1;
        balcaoAtendimento.setQuandidateAtendimento(novaQuantidade);

        chamado.setBalcaoAtendimento(balcaoAtendimento);

        Chamado resultado = chamadoRepositorio.save(chamado);
        return resultado;
    }

    @GetMapping
    public List<Chamado> buscaChamado() {
        List<Chamado> resultado = chamadoRepositorio.findAll();
        return resultado;

    }

    @PutMapping("/{id}/produto")
    public Chamado atualizaChamado(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        Chamado chamado = chamadoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Chamado não encontrado"));

        if (updates.containsKey("nomeProduto")) {
            chamado.setNomeProduto(updates.get("nomeProduto"));
        }

        return chamadoRepositorio.save(chamado);
    }
}
