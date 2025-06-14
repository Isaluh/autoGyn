package com.bamboobyte.APIAutoGyn.DTO;

public class CadastrarModeloDTO {
	private Long marcaId;
	private String nome;

	public Long getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Long marcaId) {
		this.marcaId = marcaId;
	}

	public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
