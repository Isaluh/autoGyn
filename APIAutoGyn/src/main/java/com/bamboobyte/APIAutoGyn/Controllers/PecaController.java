package com.bamboobyte.APIAutoGyn.Controllers;

import com.bamboobyte.APIAutoGyn.DTO.AtualizarPecaDTO;
import com.bamboobyte.APIAutoGyn.DTO.CadastrarPecaDTO;
import com.bamboobyte.APIAutoGyn.DTO.PecaListaDTO;
import com.bamboobyte.APIAutoGyn.Entities.Peca;
import com.bamboobyte.APIAutoGyn.Services.PecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pecas")
@CrossOrigin("*")
public class PecaController {

    private final PecaService pecaService;

    @Autowired
    public PecaController(PecaService pecaService) {
        this.pecaService = pecaService;
    }

    @PostMapping
    public ResponseEntity<String> cadastrarPeca(@RequestBody CadastrarPecaDTO novaPeca) {
        String response = pecaService.cadastrarPeca(novaPeca);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<PecaListaDTO>> listarPecas() {
        List<PecaListaDTO> pecas = pecaService.listarPecas();
        return ResponseEntity.ok(pecas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Peca> buscarPecaPorId(@PathVariable Long id) {
        Peca peca = pecaService.findById(id);
        return ResponseEntity.ok(peca);
    }

    @PatchMapping("/{id}/estoque")
    public ResponseEntity<String> adicionarNoEstoque(@PathVariable Long id, @RequestParam Integer quantidade) {
        boolean success = pecaService.addNoEstoque(id, quantidade);
        if (success) {
            return ResponseEntity.ok("Quantidade atualizada com sucesso.");
        } else {
            return ResponseEntity.status(400).body("Erro ao atualizar quantidade.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarPeca(@PathVariable Long id, @RequestBody AtualizarPecaDTO atualizarPeca) {
        String response = pecaService.atualizarPeca(id, atualizarPeca);
        return ResponseEntity.ok(response);
    }
}
