package com.bamboobyte.APIAutoGyn.Controllers;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarClienteDTO;
import com.bamboobyte.APIAutoGyn.DTO.ClienteDTO;
import com.bamboobyte.APIAutoGyn.Entities.Cliente;
import com.bamboobyte.APIAutoGyn.Services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> salvarCliente(@RequestBody CadastrarClienteDTO dto) {
        Cliente cliente = clienteService.salvar(dto); 
        return ResponseEntity.ok(cliente); 
    }

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listarTodosClientes() {
        List<ClienteDTO> clientes = clienteService.listarTodos();  
        return ResponseEntity.ok(clientes);  
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long id) {
        try {
            Cliente cliente = clienteService.buscarClientePorId(id);  
            return ResponseEntity.ok(cliente);  
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null); 
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        try {
            clienteService.excluirCliente(id);  
            return ResponseEntity.noContent().build();  
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);  
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id, @RequestBody CadastrarClienteDTO clienteAtualizadoDTO) {
        try {
            Cliente clienteAtualizado = clienteService.atualizarCliente(id, clienteAtualizadoDTO);  
            return ResponseEntity.ok(clienteAtualizado); 
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);  
        }
    }
}
