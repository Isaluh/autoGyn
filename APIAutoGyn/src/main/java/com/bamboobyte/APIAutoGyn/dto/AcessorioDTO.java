package com.bamboobyte.APIAutoGyn.DTO;

import java.util.List;
import java.util.stream.Collectors;

import com.bamboobyte.APIAutoGyn.Entities.Acessorio;

public class AcessorioDTO {

    private Long id;
    private String descricao;
    private String placaVeiculo;

    public AcessorioDTO() {
    }

    public AcessorioDTO(Long id, String descricao, String placaVeiculo) {
        this.id = id;
        this.descricao = descricao;
        this.placaVeiculo = placaVeiculo;
    }

    public AcessorioDTO(Acessorio acessorio) {
        this.id = acessorio.getId();
        this.descricao = acessorio.getDescricao();
        this.placaVeiculo = (acessorio.getVeiculo() != null) ? acessorio.getVeiculo().getPlaca() : null; 
    }

    public static List<AcessorioDTO> convertAcessorios(List<Acessorio> acessorios) {
        return acessorios.stream()
                         .map(AcessorioDTO::new)
                         .collect(Collectors.toList());
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

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    @Override
    public String toString() {
        return "AcessorioDTO [id=" + id + ", descricao=" + descricao + ", placaVeiculo=" + placaVeiculo + "]";
    }
}
