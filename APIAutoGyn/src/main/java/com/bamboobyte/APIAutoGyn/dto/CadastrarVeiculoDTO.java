package com.bamboobyte.APIAutoGyn.DTO;

import java.util.LinkedList;
import java.util.List;

public class CadastrarVeiculoDTO {
    private String placa;
    private Long idCliente;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private Long idModelo;
    private Integer km;
    private String numeroChassi;
    private String numeroPatrimonio;

    private List<Long> acessorios = new LinkedList<>();

    @Override
    public String toString() {
        return "CadastrarVeiculoDTO [placa=" + placa + ", idCliente=" + idCliente + ", anoFabricacao="
                + anoFabricacao + ", anoModelo=" + anoModelo + ", idModelo=" + idModelo
                + ", km=" + km + ", numeroChassi=" + numeroChassi + ", numeroPatrimonio="
                + numeroPatrimonio + ", acessorios=" + acessorios + "]";
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Long getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(Long idModelo) {
        this.idModelo = idModelo;
    }

    public Integer getkm() {
        return km;
    }

    public void setkm(Integer km) {
        this.km = km;
    }

    public String getNumeroChassi() {
        return numeroChassi;
    }

    public void setNumeroChassi(String numeroChassi) {
        this.numeroChassi = numeroChassi;
    }

    public String getNumeroPatrimonio() {
        return numeroPatrimonio;
    }

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public List<Long> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Long> acessorios) {
        this.acessorios = acessorios;
    }
}
