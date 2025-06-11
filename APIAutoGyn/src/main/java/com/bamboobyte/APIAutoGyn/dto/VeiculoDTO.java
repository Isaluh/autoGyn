package com.bamboobyte.APIAutoGyn.DTO;

import com.bamboobyte.APIAutoGyn.Entities.Cliente;
import com.bamboobyte.APIAutoGyn.Entities.Veiculo;

public class VeiculoDTO {
    private String placa;
    private String proprietario;
    private String marca;
    private String modelo;
    private Integer anoModelo;
    private Integer anoFabricacao;

    public VeiculoDTO(Veiculo v) {
        this.placa = v.getPlaca();

        Cliente atual = v.getProprietarioAtual();

        String cpf = "";
        String nome = "";
        if (atual != null) {
            if (atual.getPessoaFisica() != null) {
                cpf = atual.getPessoaFisica().getCpf();
            }
            nome = atual.getNome();
        }

        this.proprietario = !cpf.isEmpty() ? cpf + " | " + nome : "Desconhecido";

        this.modelo = v.getModelo() != null ? v.getModelo().getNome() : "";
        this.marca = (v.getModelo() != null && v.getModelo().getMarca() != null)
            ? v.getModelo().getMarca().getNome()
            : "";

        this.anoModelo = v.getAnoModelo();
        this.anoFabricacao = v.getAnoFabricacao();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(Integer anoModelo) {
        this.anoModelo = anoModelo;
    }

    public Integer getAnoFabricacao() {
        return anoFabricacao;
    }

    public void setAnoFabricacao(Integer anoFabricacao) {
        this.anoFabricacao = anoFabricacao;
    }

}
