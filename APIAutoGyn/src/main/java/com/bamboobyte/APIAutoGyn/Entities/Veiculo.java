package com.bamboobyte.APIAutoGyn.Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

    @Column(name = "num_patrimonio")
    private String numPatrimonio;

    @Column(name = "num_chassi")
    private String numChassi;

    @Column(name = "ano_modelo")
    private int anoModelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "veiculo_id")
    private List<Acessorio> acessorios;

    @OneToMany(mappedBy = "veiculo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Propriedade> propriedades;

    public Veiculo() {
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

    public String getNumPatrimonio() {
        return numPatrimonio;
    }

    public void setNumPatrimonio(String numPatrimonio) {
        this.numPatrimonio = numPatrimonio;
    }

    public String getNumChassi() {
        return numChassi;
    }

    public void setNumChassi(String numChassi) {
        this.numChassi = numChassi;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }

    public List<Propriedade> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(List<Propriedade> propriedades) {
        this.propriedades = propriedades;
    }

    public Cliente getProprietarioMaisRecente() {
        Cliente proprietarioMaisRecente = null;
        Date dataMaisRecente = null;
        if (this.propriedades == null) {
            return null;
        }
        for (Propriedade propriedade : this.propriedades) {
            Date dataInicio = propriedade.getDataInicio();
            if (dataInicio == null) {
                continue;
            }
            if (dataMaisRecente == null || dataInicio.after(dataMaisRecente)) {
                dataMaisRecente = dataInicio;
                proprietarioMaisRecente = propriedade.getCliente();
            }
        }
        return proprietarioMaisRecente;
    }
}