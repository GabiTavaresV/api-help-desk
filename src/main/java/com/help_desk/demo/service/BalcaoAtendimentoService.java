package com.help_desk.demo.service;

import com.help_desk.demo.entities.BalcaoAtendimento;
import com.help_desk.demo.entities.Chamado;
import com.help_desk.demo.exception.BalcaoException;
import com.help_desk.demo.exception.UsuarioException;
import com.help_desk.demo.repositorio.BalcaoAtendimentoRepositorio;
import com.help_desk.demo.repositorio.ChamadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class BalcaoAtendimentoService {

    @Autowired
    private BalcaoAtendimentoRepositorio balcaoAtendimentoRepositorio;

    @Autowired
    private ChamadoRepositorio chamadoRepositorio;

    public List<Chamado>  findById(Long id) {

        BalcaoAtendimento balcao = balcaoAtendimentoRepositorio.findById(id).orElse(null);
        if(balcao == null) {
            throw new BalcaoException("Balcão Não encontrado");
        }
        return chamadoRepositorio.findByBalcaoAtendimento(balcao);
    }

    public  BalcaoAtendimento buscaBalcaoPorId(Long balcaoAtendimentoId) {
        return balcaoAtendimentoRepositorio.findById(balcaoAtendimentoId).orElse(null);
    }

    public List<BalcaoAtendimento> findAll() {
        return balcaoAtendimentoRepositorio.findAll();
    }

    public BalcaoAtendimento save(BalcaoAtendimento balcaoAtendimento) {
        balcaoAtendimento.setDataHoraAtendimento(LocalDateTime.now());
        BalcaoAtendimento resultado = balcaoAtendimentoRepositorio.save(balcaoAtendimento);
        return resultado;
    }

}
