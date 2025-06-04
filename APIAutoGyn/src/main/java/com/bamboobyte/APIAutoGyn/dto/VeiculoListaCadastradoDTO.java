package com.bamboobyte.APIAutoGyn.dto;

import com.bamboobyte.APIAutoGyn.entity.Cliente;
import com.bamboobyte.APIAutoGyn.entity.Modelo;
import com.bamboobyte.APIAutoGyn.entity.Veiculo;

public class VeiculoListaCadastradoDTO {
    public String nomeCliente = "";
    public String placa;
    public String marca;
    public String modelo;
    public int anoModelo;
    public int anoFabricacao;

    public VeiculoListaCadastradoDTO(Veiculo veiculo) {
        Cliente proprietario = veiculo.getProprietarioMaisRecente();
        if (proprietario != null) {
            this.nomeCliente = proprietario.getNome();
        }
        this.placa = veiculo.getPlaca();
        Modelo modelo = veiculo.getModelo();
        this.modelo = modelo.getNome();
        this.marca = modelo.getMarca().getNome();
        this.anoModelo = veiculo.getAnoModelo();
        this.anoFabricacao = veiculo.getAnoFabricacao();
    }

}
