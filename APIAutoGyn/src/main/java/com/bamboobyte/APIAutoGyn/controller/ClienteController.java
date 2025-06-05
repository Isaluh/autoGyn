package com.bamboobyte.APIAutoGyn.controller;

import com.bamboobyte.APIAutoGyn.dto.CadastrarClienteDTO;
import com.bamboobyte.APIAutoGyn.dto.ClienteDTO;
import com.bamboobyte.APIAutoGyn.entity.Cliente;
import com.bamboobyte.APIAutoGyn.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarClientes() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @PostMapping
    public ResponseEntity<?> cadastrarCliente(@RequestBody CadastrarClienteDTO dto) {
        Cliente cliente = service.salvar(dto);
        return ResponseEntity.ok("Criado Cliente com ID " + cliente.getId());
    }
}
