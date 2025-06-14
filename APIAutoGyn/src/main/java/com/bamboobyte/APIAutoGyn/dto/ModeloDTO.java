package com.bamboobyte.APIAutoGyn.DTO;

import com.bamboobyte.APIAutoGyn.Entities.Modelo;

public class ModeloDTO {
    private Long id;
    private String nome;
    private MarcaDTO marca;

    public ModeloDTO() {}

    public ModeloDTO(Modelo modelo) {
        this.id = modelo.getId();
        this.nome = modelo.getNome();
        this.marca = new MarcaDTO(modelo.getMarca());
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
