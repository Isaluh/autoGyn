package com.bamboobyte.APIAutoGyn.DTO;

import com.bamboobyte.APIAutoGyn.Entities.Veiculo;
public class VeiculoDTO {
    private String placa;
    private int km;
    private int anoFabricacao;
    private ModeloDTO modelo;
    private MinimalMarcaDTO marca;
    
    public VeiculoDTO(Veiculo veiculo) {
        this.placa = veiculo.getPlaca();
        this.km = veiculo.getKm();
        this.anoFabricacao = veiculo.getAnoFabricacao();
        this.modelo = new ModeloDTO(veiculo.getModelo());
        this.marca = new MinimalMarcaDTO(veiculo.getModelo().getMarca());
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // public String getProprietario() {
    //     return proprietario;
    // }

    // public void setProprietario(String proprietario) {
    //     this.proprietario = proprietario;
    // }

    // public String getMarca() {
    //     return marca;
    // }

    // public void setMarca(String marca) {
    //     this.marca = marca;
    // }

    // public ModeloDTO getModelo() {
    //     return modelo;
    // }

    // public void setModelo(String modelo) {
    //     this.modelo = modelo;
    // }

    public MinimalMarcaDTO getMarca() {
        return marca;
    }

    public void setMarca(MinimalMarcaDTO marca) {
        this.marca = marca;
    }

}
