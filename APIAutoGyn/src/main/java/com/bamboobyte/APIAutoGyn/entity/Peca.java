package com.bamboobyte.APIAutoGyn.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Peca {
	private Long id;
	private String codigo;
	private String descricao;
	private String sku;
	private int quantidadeEstoque;
	private double valorUnitario;
	
	public Peca() {
		
	}
	
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

	public boolean isLazyload() {
		return lazyload;
	}

	public Peca(ResultSet source) throws SQLException {
		this.id = source.getLong("id_peca");
		this.codigo = source.getString("codigo");
		this.descricao = source.getString("descricao");
		this.sku = source.getString("sku");
		this.quantidadeEstoque = source.getInt("quantidade_estoque");
		this.valorUnitario = source.getDouble("valor_unitario");	this.lazyload = true;
	}
	
	private boolean lazyload = false;
	public void setLazyload(boolean ligado) {
		this.lazyload = ligado;
	}

	@Override
	public String toString() {
		return "Peca [id=" + id + ", codigo=" + codigo + ", descricao=" + descricao + ", sku=" + sku
				+ ", quantidadeEstoque=" + quantidadeEstoque + ", valorUnitario=" + valorUnitario + "]";
	}
	
	
	
	
}
