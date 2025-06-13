package com.bamboobyte.APIAutoGyn.DTO;

import java.util.LinkedList;
import java.util.List;

import com.bamboobyte.APIAutoGyn.Entities.Cliente;
import com.bamboobyte.APIAutoGyn.Entities.ItemServico;
import com.bamboobyte.APIAutoGyn.Entities.OS;

public class OSDTO {

    private Long id;
    private String cliente;
    private Double valorTotal;
    private String etapa;
    private List<ServicoOSDTO> servicos = new LinkedList<>();

    public OSDTO() {}

    public OSDTO(OS os) {
        this.id = os.getId();
        this.valorTotal = os.getValorTotal();
        this.etapa = os.getEtapa() != null ? os.getEtapa().getDescricao() : "[Sem etapa]";

        if (os.getVeiculo() != null && os.getVeiculo().getCliente() != null) {
            Cliente cliente = os.getVeiculo().getCliente();

            if (cliente.getPessoaFisica() != null) {
                var pf = cliente.getPessoaFisica();
                this.cliente = String.format("[%s] %s", pf.getCpf(), cliente.getNome());

            } else if (cliente.getPessoaJuridica() != null) {
                var pj = cliente.getPessoaJuridica();
                this.cliente = String.format("[%s] %s", pj.getCnpj(), cliente.getNome());

            } else {
                this.cliente = cliente.getNome();
            }

        } else {
            this.cliente = "[Cliente não vinculado ao veículo]";
        }

        if (os.getItensServico() != null) {
            for (ItemServico item : os.getItensServico()) {
                servicos.add(new ServicoOSDTO(item));
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public List<ServicoOSDTO> getServicos() {
        return servicos;
    }

    public void setServicos(List<ServicoOSDTO> servicos) {
        this.servicos = servicos;
    }
}
