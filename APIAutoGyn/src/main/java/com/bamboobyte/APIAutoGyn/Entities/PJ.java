package com.bamboobyte.APIAutoGyn.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PJ {

    @Column(name = "inscricao_estadual")
    private String inscricaoEstadual;

    @Column(name = "nome_contato")
    private String nomeContato;

    @Column(name = "cnpj")
    private String cnpj;

    public PJ() {}

    public PJ(String cnpj, String inscricaoEstadual, String nomeContato) {
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
        this.nomeContato = nomeContato;
    }
    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "PJ [inscricaoEstadual=" + inscricaoEstadual + ", nomeContato=" + nomeContato + ", cnpj=" + cnpj + "]";
    }
}
