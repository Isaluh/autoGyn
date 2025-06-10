package com.bamboobyte.APIAutoGyn.DTO;

import com.bamboobyte.APIAutoGyn.Entities.Marca;

public class MarcaDTO {
    private Long id;
    private String nome;

    public MarcaDTO() {}

    public MarcaDTO(Marca marca) {
        this.id = marca.getId();
        this.nome = marca.getNome();
    }
}
