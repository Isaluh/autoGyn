package com.bamboobyte.APIAutoGyn.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarClienteDTO;
import com.bamboobyte.APIAutoGyn.DTO.ListaClienteDTO;
import com.bamboobyte.APIAutoGyn.Entities.Cliente;
import com.bamboobyte.APIAutoGyn.Services.ClienteService;
import com.bamboobyte.APIAutoGyn.Validacoes.GatewayValidacao;
import com.bamboobyte.APIAutoGyn.Validacoes.MensagemErro;
import com.bamboobyte.APIAutoGyn.Validacoes.StatusValidacao;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

    private final ClienteService clienteService;
    private final GatewayValidacao validador;

    public ClienteController(ClienteService clienteService, GatewayValidacao validador) {
        this.clienteService = clienteService;
        this.validador = validador;
    }

    @PostMapping
    public ResponseEntity<?> salvarCliente(@RequestBody CadastrarClienteDTO dto) {
        List<StatusValidacao> erros = validador.validar(dto);
        if (erros.size() > 0) {
            return ResponseEntity.badRequest().body(new MensagemErro(erros));
            // fazer isso aparecer no front ([CEP_INVALIDO, UF_INVALIDA, TELEFONE_INVALIDO, TELEFONE_INVALIDO])
        }
        Cliente idCliente = clienteService.salvar(dto);
        if (idCliente == null) {
            return ResponseEntity.badRequest().body(new MensagemErro("Cliente não criado."));
        }
        return ResponseEntity.ok("");
    }

    @GetMapping
    public ResponseEntity<List<ListaClienteDTO>> listarTodosClientes() {
        List<ListaClienteDTO> clientes = clienteService.listarTodos();
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
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Long id,
            @RequestBody CadastrarClienteDTO clienteAtualizadoDTO) {
        try {
            Cliente clienteAtualizado = clienteService.atualizarCliente(id,
                    clienteAtualizadoDTO);
            return ResponseEntity.ok(clienteAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(null);
        }
    }
}
