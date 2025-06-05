package com.bamboobyte.APIAutoGyn.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "peca")
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_peca")
    private Long id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "sku")
    private String sku;

    @Column(name = "quantidade_estoque")
    private int quantidadeEstoque;

    @Column(name = "valor_unitario")
    private double valorUnitario;

    public Peca() {}

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    @Override
    public String toString() {
        return "Peca [id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + ", sku=" + sku
                + ", quantidadeEstoque=" + quantidadeEstoque + ", valorUnitario=" + valorUnitario + "]";
    }
}
