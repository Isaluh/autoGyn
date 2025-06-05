package com.bamboobyte.APIAutoGyn.DTO;

import com.bamboobyte.APIAutoGyn.Entities.Veiculo;
import java.util.List;

public class VeiculoDTO {

    private String placa;
    private int km;
    private int anoFabricacao;
    private String numPatrimonio;
    private String numChassi;
    private int anoModelo;
    private ModeloDTO modelo;
    private List<AcessorioDTO> acessorios;

    public VeiculoDTO(Veiculo veiculo) {
        this.placa = veiculo.getPlaca();
        this.km = veiculo.getKm();
        this.anoFabricacao = veiculo.getAnoFabricacao();
        this.numPatrimonio = veiculo.getNumPatrimonio();
        this.numChassi = veiculo.getNumChassi();
        this.anoModelo = veiculo.getAnoModelo();
        this.modelo = new ModeloDTO(veiculo.getModelo());
        this.acessorios = AcessorioDTO.convertAcessorios(veiculo.getAcessorios());
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

    public String getNumPatrimonio() {
        return numPatrimonio;
    }

    public void setNumPatrimonio(String numPatrimonio) {
        this.numPatrimonio = numPatrimonio;
    }

    public String getNumChassi() {
        return numChassi;
    }

    public void setNumChassi(String numChassi) {
        this.numChassi = numChassi;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

    public ModeloDTO getModelo() {
        return modelo;
    }

    public void setModelo(ModeloDTO modelo) {
        this.modelo = modelo;
    }

    public List<AcessorioDTO> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<AcessorioDTO> acessorios) {
        this.acessorios = acessorios;
    }
}
