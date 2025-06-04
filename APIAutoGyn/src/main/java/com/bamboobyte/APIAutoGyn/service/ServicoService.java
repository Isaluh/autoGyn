package com.bamboobyte.APIAutoGyn.service;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.pi.autogyn.persistencia.dao.ServicoDao;
import com.bamboobyte.APIAutoGyn.entity.Servico;
import com.bamboobyte.APIAutoGyn.dto.CadastrarServicoDTO;
import com.bamboobyte.APIAutoGyn.dto.ServicoFormatadoDTO;

public class ServicoService {
	public static boolean cadastrarServico(CadastrarServicoDTO servico) throws SQLException {
		return ServicoDao.insert(servico.getDescricao(), servico.getValor());
	}

	public static List<ServicoFormatadoDTO> buscarServicosFormatados() throws SQLException {
		List<ServicoFormatadoDTO> lista = new LinkedList<>();
		for (Servico servico : ServicoDao.getAll()) {
			lista.add(new ServicoFormatadoDTO(servico));
		}
		return lista;
	}

}
