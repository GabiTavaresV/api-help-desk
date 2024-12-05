package com.help_desk.demo.repositorio;

import com.help_desk.demo.entities.Atendente;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface AtendenteRepositorio extends JpaRepository<Atendente, Long> {

    }

