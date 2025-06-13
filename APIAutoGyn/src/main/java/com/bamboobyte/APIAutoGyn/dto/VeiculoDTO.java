package com.bamboobyte.APIAutoGyn.DTO;

import com.bamboobyte.APIAutoGyn.Entities.Cliente;
import com.bamboobyte.APIAutoGyn.Entities.Veiculo;
public class VeiculoDTO {
    private String placa;
    private int km;
    private int anoFabricacao;
    private int anoModelo;

    private ModeloDTO modelo;
    private MinimalMarcaDTO marca;
    private ListaClienteDTO proprietario;

    public VeiculoDTO(Veiculo veiculo) {
        this.placa = veiculo.getPlaca();
        this.km = veiculo.getKm();
        this.anoFabricacao = veiculo.getAnoFabricacao();
        this.anoModelo = veiculo.getAnoModelo();

        this.modelo = new ModeloDTO(veiculo.getModelo());
        this.marca = new MinimalMarcaDTO(veiculo.getModelo().getMarca());

        Cliente cliente = veiculo.getCliente();
        if (cliente != null) {
            if (cliente.getPessoaFisica() != null && cliente.getPessoaFisica().getCpf() != null) {
                this.proprietario = new ListaClienteDTO(
                    cliente.getId(),
                    "[" + cliente.getPessoaFisica().getCpf() + "] | " + cliente.getNome()
                );
            } else if (cliente.getPessoaJuridica() != null && cliente.getPessoaJuridica().getCnpj() != null) {
                this.proprietario = new ListaClienteDTO(
                    cliente.getId(),
                    "[" + cliente.getPessoaJuridica().getCnpj() + "] | " + cliente.getNome()
                );
            }
        }
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

    public MinimalMarcaDTO getMarca() {
        return marca;
    }

    public void setMarca(MinimalMarcaDTO marca) {
        this.marca = marca;
    }

    public ListaClienteDTO getProprietario() {
        return proprietario;
    }

    public void setProprietario(ListaClienteDTO proprietario) {
        this.proprietario = proprietario;
    }

    

}
