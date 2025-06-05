package com.bamboobyte.APIAutoGyn.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PJ {

    @Column(name = "inscricao_estadual")
    private String inscricaoEstadual;

    @Column(name = "contato")
    private String contato;

    @Column(name = "cnpj")
    private String cnpj;

    public PJ() {}

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "PJ [inscricaoEstadual=" + inscricaoEstadual + ", contato=" + contato + ", cnpj=" + cnpj + "]";
    }
}
