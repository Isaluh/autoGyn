package com.bamboobyte.APIAutoGyn.DTO;

public class CadastrarMarcaDTO {

    private String nome;

    public CadastrarMarcaDTO() {}

    public CadastrarMarcaDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
