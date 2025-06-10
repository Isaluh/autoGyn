package com.bamboobyte.APIAutoGyn.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.bamboobyte.APIAutoGyn.Entities.Marca;
import com.bamboobyte.APIAutoGyn.Entities.Modelo;

public class MarcaListaCadastroDTO {
    public Long id;
    public String nomeMarca;
    public List<String> nomeModelos;

    public MarcaListaCadastroDTO(Marca marca) {
        this.id = marca.getId(); 
        this.nomeMarca = marca.getNome();
        this.nomeModelos = marca.getModelos()
                                .stream()
                                .map(Modelo::getNome)
                                .collect(Collectors.toList());
    }
}

