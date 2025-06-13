package com.bamboobyte.APIAutoGyn.DTO;

import com.bamboobyte.APIAutoGyn.Entities.Marca;

public class MarcaDTO {
	private Long id;
	private String nome;

	public MarcaDTO(Marca marca) {
		this.id = marca.getId();
		this.nome = marca.getNome();
	}

	public MarcaDTO() {

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
