package com.bamboobyte.APIAutoGyn.DTO;

import java.util.List;

public class CadastrarOSDTO {
	private String placa;
	private List<ColaboradorServicoDTO> servicos;
	private List<PecaDTO> pecas;

	public List<ColaboradorServicoDTO> getServicos() {
		return servicos;
	}

	public void setServicos(List<ColaboradorServicoDTO> servicos) {
		this.servicos = servicos;
	}

	public List<PecaDTO> getPecas() {
		return pecas;
	}

	public void setPecas(List<PecaDTO> pecas) {
		this.pecas = pecas;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

}
