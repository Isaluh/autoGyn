package com.bamboobyte.APIAutoGyn.DTO;

import java.util.LinkedList;
import java.util.List;

import com.bamboobyte.APIAutoGyn.Entities.*;

public class OSDTO {
    
    private Long id;
    private String cliente;
    private Double valorTotal;
    private String etapa;
    private List<ServicoOSDTO> servicos = new LinkedList<>();

    public OSDTO() {}

    public OSDTO(OS os) {
        this.id = os.getId();
        
        this.etapa = os.getEtapa().getDescricao(); 

        if (os.getCliente().getPessoaFisica() != null) {
            this.cliente = String.format(
                    "[%s] %s",
                    os.getCliente().getPessoaFisica().getCpf(),
                    os.getCliente().getNome());
        } else if (os.getCliente().getPessoaJuridica() != null) {
            this.cliente = String.format(
                    "[%s] %s",
                    os.getCliente().getPessoaJuridica().getCnpj(),
                    os.getCliente().getNome());
        } else if (os.getCliente() != null) {
            this.cliente = os.getCliente().getNome();
        } else {
            this.cliente = "[Cliente não encontrado]";
        }
        
        this.valorTotal = os.getValorTotal();
        
        for (ItemServico item : os.getItensServico()) {
            servicos.add(new ServicoOSDTO(item));
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

    public List<ServicoOSDTO> getServicos() {
        return servicos;
    }

    public void setServicos(List<ServicoOSDTO> servicos) {
        this.servicos = servicos;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }
}