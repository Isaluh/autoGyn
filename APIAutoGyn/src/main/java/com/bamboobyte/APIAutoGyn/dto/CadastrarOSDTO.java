package com.bamboobyte.APIAutoGyn.DTO;

import java.util.List;

public class CadastrarOSDTO {
    private String veiculo;
    private String orcamento;
    private List<Long> peca;
    private List<ColaboradorServicoDTO> servicosColaboradores;

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(String orcamento) {
        this.orcamento = orcamento;
    }

    public List<Long> getPeca() {
        return peca;
    }

    public void setPeca(List<Long> peca) {
        this.peca = peca;
    }

    public List<ColaboradorServicoDTO> getServicosColaboradores() {
        return servicosColaboradores;
    }

    public void setServicosColaboradores(List<ColaboradorServicoDTO> servicosColaboradores) {
        this.servicosColaboradores = servicosColaboradores;
    }
}
