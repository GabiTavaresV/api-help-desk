package com.help_desk.demo.service;


import com.help_desk.demo.entities.BalcaoAtendimento;
import com.help_desk.demo.entities.Chamado;
import com.help_desk.demo.entities.Usuario;
import com.help_desk.demo.repositorio.ChamadoRepositorio;
import com.help_desk.demo.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ChamadoService {

    @Autowired
    private ChamadoRepositorio chamadoRepositorio;

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BalcaoAtendimentoService balcaoAtendimentoService;

    public Chamado findById(Long id) {
        return chamadoRepositorio.findById(id).orElse(null);
    }

    public List<Chamado> buscaChamado() {
        return chamadoRepositorio.findAll();
    }

    public Chamado registraChamado(Chamado chamado) {
        Usuario usuario = usuarioRepositorio.findById(chamado.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        chamado.setUsuario(usuario);

        BalcaoAtendimento balcaoAtendimento = balcaoAtendimentoService.findById(chamado.getBalcaoAtendimento().getId());

        int novaQuantidade = (balcaoAtendimento.getQuandidateAtendimento() == null ? 0 : balcaoAtendimento.getQuandidateAtendimento()) + 1;
        balcaoAtendimento.setQuandidateAtendimento(novaQuantidade);

        chamado.setBalcaoAtendimento(balcaoAtendimento);

        Chamado resultado = chamadoRepositorio.save(chamado);
        return resultado;
    }

    public Chamado updateChamado(Chamado chamado) {
        return chamadoRepositorio.save(chamado);
    }

    public Chamado atualizaChamado(Long id,  Map<String, String> updates) {
        Chamado chamado = this.findById(id);

        if (updates.containsKey("nomeProduto")) {
            chamado.setNomeProduto(updates.get("nomeProduto"));
        }
        return this.updateChamado(chamado);
    }
}
