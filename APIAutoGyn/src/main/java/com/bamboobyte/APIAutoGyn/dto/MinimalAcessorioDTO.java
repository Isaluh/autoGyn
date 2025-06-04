package com.bamboobyte.APIAutoGyn.dto;

import com.bamboobyte.APIAutoGyn.entity.*;

public class MinimalAcessorioDTO {
	private Long id;
	private String nome;

	public MinimalAcessorioDTO(Acessorio acessorio) {
		this.id = acessorio.getId();
		this.nome = acessorio.getDescricao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
