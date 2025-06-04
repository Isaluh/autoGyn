package com.bamboobyte.APIAutoGyn.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bamboobyte.APIAutoGyn.service.ClienteService;
import com.bamboobyte.APIAutoGyn.dto.CadastrarClienteDTO;
import com.bamboobyte.APIAutoGyn.dto.ClienteDTO;
import com.bamboobyte.APIAutoGyn.valiForm.*;

@Controller
public class ClienteController {

	private static GatewayValidacao validador = new GatewayValidacao();

	@GetMapping("/cliente")
	public ResponseEntity<List<ClienteDTO>> listarClientes() throws SQLException {
		return ResponseEntity.ok(ClienteService.listarTodosFormatados());
	}

	@PostMapping("/cliente")
	public ResponseEntity<?> cadastrarCliente(@RequestBody CadastrarClienteDTO novoCliente) throws SQLException {
		List<StatusValidacao> erros = validador.validar(novoCliente);

		if (erros.size() > 0) {
			return ResponseEntity.badRequest().body(new MensagemErro(erros));
		}

		Long idCliente = ClienteService.inserirCliente(novoCliente);

		if (idCliente == null) {
			return ResponseEntity.badRequest().body(new MensagemErro("Cliente não criado."));
		}
		return ResponseEntity.ok("Criado Cliente " + idCliente);
	}

}
