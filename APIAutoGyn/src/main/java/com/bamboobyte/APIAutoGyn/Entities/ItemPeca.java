package com.bamboobyte.APIAutoGyn.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "item_peca")
public class ItemPeca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_peca")
    private Long id;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "valor_total")
    private double valorTotal;

    @Column(name = "valor_unitario")
    private double valorUnitario;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_os", nullable = false)
    private OS os;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_peca", nullable = false)
    private Peca peca;

    public ItemPeca() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    @Override
    public String toString() {
        return "ItemPeca [id=" + id + ", quantidade=" + quantidade + ", valorTotal=" + valorTotal + ", valorUnitario=" + valorUnitario
                + ", os=" + (os != null ? os.getId() : null) + ", peca=" + (peca != null ? peca.getId() : null) + "]";
    }
}
