package com.bamboobyte.APIAutoGyn.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PF {

    @Column(name = "cpf")
    private String cpf;

    public PF() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
