package com.bamboobyte.APIAutoGyn.DTO;

public class CadastrarAcessorioDTO {
	private String descricao;

	public CadastrarAcessorioDTO(String descricao) {
		this.descricao = descricao;
	}

	public CadastrarAcessorioDTO() {

	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
