package com.bamboobyte.APIAutoGyn.Entities;

import java.util.Date;
import java.util.List;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarOSDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "os")
public class OS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_os")
    private Long id;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "valor_total")
    private double valorTotal;

    @Column(name = "valor_pago")
    private double valorPago;

    @Enumerated(EnumType.STRING)
    @Column(name = "etapa")
    private Etapa etapa;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "placa") 
    private Veiculo veiculo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "os", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemPeca> itensPeca;

    @OneToMany(mappedBy = "os", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ItemServico> itensServico;

    public OS(CadastrarOSDTO novaOS) {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPeca> getItensPeca() {
        return itensPeca;
    }

    public void setItensPeca(List<ItemPeca> itensPeca) {
        this.itensPeca = itensPeca;
    }

    public List<ItemServico> getItensServico() {
        return itensServico;
    }

    public void setItensServico(List<ItemServico> itensServico) {
        this.itensServico = itensServico;
    }

    @Override
    public String toString() {
        return "OS [id=" + id + ", data=" + data + ", valorTotal=" + valorTotal + ", valorPago=" + valorPago + ", etapa=" + etapa
                + ", veiculo=" + (veiculo != null ? veiculo.getPlaca() : null) + ", cliente=" + (cliente != null ? cliente.getId() : null) + "]";
    }
}
