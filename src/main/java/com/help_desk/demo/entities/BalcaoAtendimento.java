package com.help_desk.demo.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_balcao_atendimento")
public class BalcaoAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeAtendente;
    private String nomeLoja;
    private Integer quandidateAtendimento;
    private LocalDateTime dataHoraAtendimento;

    public BalcaoAtendimento() {
    }

    public BalcaoAtendimento(Long id, String nomeAtendente, String nomeLoja, Integer quandidateAtendimento, LocalDateTime dataHoraAtendimento) {
        this.id = id;
        this.nomeAtendente = nomeAtendente;
        this.nomeLoja = nomeLoja;
        this.quandidateAtendimento = quandidateAtendimento;
        this.dataHoraAtendimento = dataHoraAtendimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeAtendente() {
        return nomeAtendente;
    }

    public void setNomeAtendente(String nomeAtendente) {
        this.nomeAtendente = nomeAtendente;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public Integer getQuandidateAtendimento() {
        return quandidateAtendimento;
    }

    public void setQuandidateAtendimento(Integer quandidateAtendimento) {
        this.quandidateAtendimento = quandidateAtendimento;
    }

    public LocalDateTime getDataHoraAtendimento() {
        return dataHoraAtendimento;
    }

    public void setDataHoraAtendimento(LocalDateTime dataHoraAtendimento) {
        this.dataHoraAtendimento = dataHoraAtendimento;
    }
}
