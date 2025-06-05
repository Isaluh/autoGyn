package com.bamboobyte.APIAutoGyn.Entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico")
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor")
    private Double valor;

    @OneToMany(mappedBy = "servico", fetch = FetchType.LAZY)
    private List<ItemServico> itensServico;

    public Servico() {}

    public Servico(Long id, String descricao, Double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<ItemServico> getItensServico() {
        return itensServico;
    }

    public void setItensServico(List<ItemServico> itensServico) {
        this.itensServico = itensServico;
    }

    @Override
    public String toString() {
        return "Servico [id=" + id + ", descricao=" + descricao + ", valor=" + valor + "]";
    }
}
