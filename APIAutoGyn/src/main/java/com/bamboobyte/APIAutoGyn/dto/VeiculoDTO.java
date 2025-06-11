package com.bamboobyte.APIAutoGyn.DTO;

import java.util.List;

import com.bamboobyte.APIAutoGyn.Entities.Veiculo;

public class VeiculoDTO {

    private String placa;
    private int km;
    private int anoFabricacao;
    private ModeloDTO modelo;

    public VeiculoDTO(Veiculo veiculo) {
        this.placa = veiculo.getPlaca();
        this.km = veiculo.getKm();
        this.anoFabricacao = veiculo.getAnoFabricacao();
        this.modelo = new ModeloDTO(veiculo.getModelo());
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public ModeloDTO getModelo() {
        return modelo;
    }

    public void setModelo(ModeloDTO modelo) {
        this.modelo = modelo;
    }

}
