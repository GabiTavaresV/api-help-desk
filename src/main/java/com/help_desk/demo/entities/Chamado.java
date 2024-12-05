package com.help_desk.demo.entities;

import com.help_desk.demo.EstadoChamado;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_chamado")
public class Chamado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCliente;
    private String nomeProduto;

    @Enumerated(EnumType.STRING)
    private EstadoChamado estadoChamado;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "balcao_atendimento_id")
    private BalcaoAtendimento balcaoAtendimento;

    public Chamado() {
        this.estadoChamado = EstadoChamado.ABERTO;
    }

    public Chamado(String nomeCliente, String nomeProduto, String estadoChamado, Usuario usuario, BalcaoAtendimento balcaoAtendimento) {
        this.nomeCliente = nomeCliente;
        this.nomeProduto = nomeProduto;
        this.estadoChamado = EstadoChamado.ABERTO;
        this.usuario = usuario;
        this.balcaoAtendimento = balcaoAtendimento;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public EstadoChamado getEstadoChamado() {
        return estadoChamado;
    }

    public void setEstadoChamado(EstadoChamado estadoChamado) {
        this.estadoChamado = estadoChamado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BalcaoAtendimento getBalcaoAtendimento() {
        return balcaoAtendimento;
    }

    public void setBalcaoAtendimento(BalcaoAtendimento balcaoAtendimento) {
        this.balcaoAtendimento = balcaoAtendimento;
    }
}
