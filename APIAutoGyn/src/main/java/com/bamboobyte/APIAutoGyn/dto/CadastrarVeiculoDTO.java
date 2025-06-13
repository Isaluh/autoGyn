package com.bamboobyte.APIAutoGyn.DTO;

public class CadastrarVeiculoDTO {
    private String placa;
    private Long idCliente;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private Long idModelo;
    private Integer km;


    @Override
    public String toString() {
        return "CadastrarVeiculoDTO [placa=" + placa + ", idCliente=" + idCliente + ", anoFabricacao="
                + anoFabricacao + ", anoModelo="
                + anoModelo + ", idModelo=" + idModelo + "]";
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

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

}
