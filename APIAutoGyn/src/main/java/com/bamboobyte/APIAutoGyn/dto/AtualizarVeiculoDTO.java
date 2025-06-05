package com.bamboobyte.APIAutoGyn.DTO;

public class AtualizarVeiculoDTO {

    private Integer km;
    private Long idNovoProprietario;
    private Integer anoFabricacao;    
    private Integer anoModelo;        
    private String numeroChassi;      
    private String numeroPatrimonio;  

    public AtualizarVeiculoDTO() {
    }

    public AtualizarVeiculoDTO(Integer km, Long idNovoProprietario, Integer anoFabricacao, Integer anoModelo,
            String numeroChassi, String numeroPatrimonio) {
        this.km = km;
        this.idNovoProprietario = idNovoProprietario;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.numeroChassi = numeroChassi;
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public Long getIdNovoProprietario() {
        return idNovoProprietario;
    }

    public void setIdNovoProprietario(Long idNovoProprietario) {
        this.idNovoProprietario = idNovoProprietario;
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
}
