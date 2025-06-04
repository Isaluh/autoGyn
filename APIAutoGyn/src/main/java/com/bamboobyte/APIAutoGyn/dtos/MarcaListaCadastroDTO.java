package com.bamboobyte.APIAutoGyn.dtos;

import java.util.LinkedList;
import java.util.List;

import com.bamboobyte.APIAutoGyn.entities.*;

public class MarcaListaCadastroDTO {
    public String nomeMarca;
    public List<String> nomeModelos;

    public MarcaListaCadastroDTO(Marca marca) {
        this.nomeMarca = marca.getNome();
        List<String> listaNomes = new LinkedList<>();
        for (Modelo modelo : marca.getModelos()) {
            listaNomes.add(modelo.getNome());
        }
        this.nomeModelos = listaNomes;
    }

}
