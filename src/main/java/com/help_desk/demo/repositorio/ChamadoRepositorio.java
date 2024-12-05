package com.help_desk.demo.repositorio;

import com.help_desk.demo.entities.BalcaoAtendimento;
import com.help_desk.demo.entities.Chamado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChamadoRepositorio extends JpaRepository<Chamado, Long> {
    List<Chamado> findByBalcaoAtendimento(BalcaoAtendimento balcaoAtendimento);
}
