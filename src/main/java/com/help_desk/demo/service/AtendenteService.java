package com.help_desk.demo.service;

import com.help_desk.demo.entities.Atendente;
import com.help_desk.demo.exception.UsuarioException;
import com.help_desk.demo.repositorio.AtendenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AtendenteService {

    @Autowired
    private AtendenteRepositorio atendenteRepositorio;

    public Atendente findById(Long id) {
        return atendenteRepositorio.findById(id).orElse(null);
    }

    public List<Atendente> findAll() {
        return atendenteRepositorio.findAll();
    }

    public Atendente save(Atendente atendente) throws UsuarioException {
        Atendente resultado = atendenteRepositorio.save(atendente);
        return  resultado;
    }

    public void delete(Long id) {
        atendenteRepositorio.deleteById(id);
    }
}
