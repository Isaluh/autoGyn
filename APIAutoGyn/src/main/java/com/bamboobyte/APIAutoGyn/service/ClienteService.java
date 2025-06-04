package com.bamboobyte.APIAutoGyn.service;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.pi.autogyn.persistencia.dao.ClienteDao;
import com.bamboobyte.APIAutoGyn.entity.Cliente;
import com.bamboobyte.APIAutoGyn.dto.CadastrarClienteDTO;
import com.bamboobyte.APIAutoGyn.dto.ClienteDTO;

public class ClienteService {
	public static Long inserirCliente(CadastrarClienteDTO novoCliente) throws SQLException {
		return ClienteDao.insert(new Cliente(novoCliente));
	}

	public static List<ClienteDTO> listarTodosFormatados() throws SQLException {
		List<ClienteDTO> lista = new LinkedList<>();
		for (Cliente cliente : ClienteDao.getAll()) {
			lista.add(new ClienteDTO(cliente));
		}
		return lista;
	}

}
