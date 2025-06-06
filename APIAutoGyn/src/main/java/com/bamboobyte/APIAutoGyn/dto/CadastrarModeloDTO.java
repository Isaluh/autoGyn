package com.bamboobyte.APIAutoGyn.DTO;

public class CadastrarModeloDTO {
	private Long marcaId;
	private String nomeModelo;

	public Long getMarcaId() {
		return marcaId;
	}

	public void setMarcaId(Long marcaId) {
		this.marcaId = marcaId;
	}

	public String getNome() {
		return nomeModelo;
	}

	public void setNome(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

}
