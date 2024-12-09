package com.help_desk.demo.service;

import com.help_desk.demo.entities.Atendente;
import com.help_desk.demo.entities.BalcaoAtendimento;
import com.help_desk.demo.repositorio.BalcaoAtendimentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BalcaoAtendimentoService {

    @Autowired
    private BalcaoAtendimentoRepositorio balcaoAtendimentoRepositorio;

    public BalcaoAtendimento findById(Long id) {
        return balcaoAtendimentoRepositorio.findById(id).orElse(null);
    }

    public List<BalcaoAtendimento> findAll() {
        return balcaoAtendimentoRepositorio.findAll();
    }

    public BalcaoAtendimento save(BalcaoAtendimento balcaoAtendimento) {
        BalcaoAtendimento resultado = balcaoAtendimentoRepositorio.save(balcaoAtendimento);
        return  resultado;
    }

    public void delete(Long id) {
        balcaoAtendimentoRepositorio.deleteById(id);
    }
}
