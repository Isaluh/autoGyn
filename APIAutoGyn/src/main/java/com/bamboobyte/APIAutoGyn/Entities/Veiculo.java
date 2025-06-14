package com.bamboobyte.APIAutoGyn.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @Column(name = "placa")
    private String placa;

    @Column(name = "km")
    private int km;

    @Column(name = "ano_fabricacao")
    private int anoFabricacao;

    @Column(name = "ano_modelo")
    private int anoModelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Veiculo() {
    }

    public Veiculo(String placa, int km, int anoFabricacao, int anoModelo, Modelo modelo, Cliente cliente) {
        this.placa = placa;
        this.km = km;
        this.anoFabricacao = anoFabricacao;
        this.anoModelo = anoModelo;
        this.modelo = modelo;
        this.cliente = cliente;
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

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        this.anoModelo = anoModelo;
    }

}