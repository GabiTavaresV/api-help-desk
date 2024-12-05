package com.help_desk.demo.repositorio;

import com.help_desk.demo.entities.BalcaoAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BalcaoAtendimentoRepositorio extends JpaRepository<BalcaoAtendimento, Long> {
}
