package com.bamboobyte.APIAutoGyn.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class Telefone {

    private int ddd;
    private int telefone;

    public Telefone() {
    }

    public Telefone(int ddd, int telefone) {
        this.ddd = ddd;
        this.telefone = telefone;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
