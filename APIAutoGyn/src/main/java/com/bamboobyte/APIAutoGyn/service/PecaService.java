package com.bamboobyte.APIAutoGyn.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.pi.autogyn.persistencia.dao.PecaDao;
import com.bamboobyte.APIAutoGyn.entity.Peca;
import com.bamboobyte.APIAutoGyn.dto.*;

public class PecaService {

	public static String cadastrarPeca(CadastrarPecaDTO novaPeca) throws SQLException {
		if (PecaDao.insert(novaPeca)) {
			return "Peça cadastrada com sucesso.";
		}
		return "Peça não foi cadastrada";
	}

	public static List<PecaListaDTO> listarPecas() throws SQLException {
		List<PecaListaDTO> pecas = new LinkedList<>();
		for (Peca peca : PecaDao.getAll()) {
			pecas.add(new PecaListaDTO(peca));
		}
		return pecas;
	}

	public static Peca findById(Long idPeca) throws SQLException {
		if (idPeca == null) {
			return null;
		}
		return PecaDao.getById(idPeca);
	}

	public static boolean addNoEstoque(Long idPeca, Integer quantidade) throws SQLException {
		return PecaDao.addQuantidade(idPeca, quantidade);

	}

	public static String atualizarPeca(Long idPeca, AtualizarPecaDTO atualizarPeca) throws SQLException {

		return PecaDao.update(idPeca, atualizarPeca);
	}

}
