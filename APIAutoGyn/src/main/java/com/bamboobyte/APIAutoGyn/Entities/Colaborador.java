package com.bamboobyte.APIAutoGyn.Entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "colaborador")
public class Colaborador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "cpf", length = 14)
    private String cpf;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY)
    private List<ItemServico> itensServico;

    public Colaborador() {
    }

    public Colaborador(Colaborador colaborador) {
        this.id = colaborador.getId(); 
        this.cpf = colaborador.getCpf();
        this.nome = colaborador.getNome();
        this.itensServico = colaborador.getItensServico();
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ItemServico> getItensServico() {
        return itensServico;
    }

    public void setItensServico(List<ItemServico> itensServico) {
        this.itensServico = itensServico;
    }

    @Override
    public String toString() {
        return "Colaborador [cpf=" + cpf + ", nome=" + nome + "]";
    }
}
