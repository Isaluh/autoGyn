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

import com.bamboobyte.APIAutoGyn.DTO.ListaColaboradorDTO;
import com.bamboobyte.APIAutoGyn.Entities.Colaborador;
import com.bamboobyte.APIAutoGyn.Services.ColaboradorService;
import com.bamboobyte.APIAutoGyn.Validacoes.GatewayValidacao;
import com.bamboobyte.APIAutoGyn.Validacoes.MensagemErroFactory;
import com.bamboobyte.APIAutoGyn.Validacoes.StatusValidacao;

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
            return ResponseEntity.badRequest().body(MensagemErroFactory.criarMensagem(erros)); // utilizando a factory para criar a mensagem de erro
        }

        Colaborador colaborador = colaboradorService.incluirColaborador(novoColaborador);
        if (colaborador == null) {
            return ResponseEntity.badRequest().body(MensagemErroFactory.criarMensagem("Colaborador não pôde ser criado.")); // utilizando a factory para criar a mensagem de erro

        }

        return ResponseEntity.ok("");
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
