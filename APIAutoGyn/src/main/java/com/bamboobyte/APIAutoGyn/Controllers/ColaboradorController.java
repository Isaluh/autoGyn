package com.bamboobyte.APIAutoGyn.Controllers;

import com.bamboobyte.APIAutoGyn.DTO.ListaColaboradorDTO;
import com.bamboobyte.APIAutoGyn.Entities.Colaborador;
import com.bamboobyte.APIAutoGyn.Services.ColaboradorService;
import com.bamboobyte.APIAutoGyn.Validacoes.GatewayValidacao;
import com.bamboobyte.APIAutoGyn.Validacoes.MensagemErro;
import com.bamboobyte.APIAutoGyn.Validacoes.StatusValidacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
@CrossOrigin("*")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;
    private final GatewayValidacao validador;

    public ColaboradorController(ColaboradorService colaboradorService, GatewayValidacao validador) {
        this.colaboradorService = colaboradorService;
        this.validador = validador;
    }

    @GetMapping
    public ResponseEntity<List<ListaColaboradorDTO>> listarTodos() {
        List<ListaColaboradorDTO> colaboradores = colaboradorService.listarTodos();
        return ResponseEntity.ok(colaboradores);
    }

    @PostMapping
    public ResponseEntity<?> incluirColaborador(@RequestBody Colaborador novoColaborador) {
        List<StatusValidacao> erros = validador.validar(novoColaborador);
        if (!erros.isEmpty()) {
            return ResponseEntity.badRequest().body(new MensagemErro(erros));
        }

        Colaborador colaborador = colaboradorService.incluirColaborador(novoColaborador);
        if (colaborador == null) {
            return ResponseEntity.badRequest().body(new MensagemErro("Colaborador não pôde ser criado."));
        }

        return ResponseEntity.ok("Colaborador criado com sucesso. ID: " + colaborador.getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> buscarColaboradorPorId(@PathVariable Long id) {
        Colaborador colaborador = colaboradorService.buscarPorId(id);
        return ResponseEntity.ok(colaborador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> atualizarColaborador(@PathVariable Long id,
            @RequestBody Colaborador Colaborador) {
        Colaborador colaboradorAtualizado = colaboradorService.atualizarColaborador(id, Colaborador);
        return ResponseEntity.ok(colaboradorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirColaborador(@PathVariable Long id) {
        colaboradorService.excluirColaborador(id);
        return ResponseEntity.noContent().build();
    }
}
