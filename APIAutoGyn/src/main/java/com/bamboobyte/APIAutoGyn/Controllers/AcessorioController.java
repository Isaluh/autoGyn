package com.bamboobyte.APIAutoGyn.Controllers;

import com.bamboobyte.APIAutoGyn.Entities.Acessorio;
import com.bamboobyte.APIAutoGyn.Services.AcessorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acessorios")
public class AcessorioController {

    private final AcessorioService acessorioService;

    @Autowired
    public AcessorioController(AcessorioService acessorioService) {
        this.acessorioService = acessorioService;
    }

    @PostMapping
    public ResponseEntity<Acessorio> salvarAcessorio(@RequestBody Acessorio acessorio) {
        Acessorio acessorioSalvo = acessorioService.salvarAcessorio(acessorio);
        return ResponseEntity.ok(acessorioSalvo);
    }

    @GetMapping
    public ResponseEntity<List<Acessorio>> listarAcessorios() {
        List<Acessorio> acessorios = acessorioService.listarAcessorios();
        return ResponseEntity.ok(acessorios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Acessorio> buscarAcessorioPorId(@PathVariable Long id) {
        try {
            Acessorio acessorio = acessorioService.buscarAcessorioPorId(id);
            return ResponseEntity.ok(acessorio);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAcessorio(@PathVariable Long id) {
        try {
            acessorioService.excluirAcessorio(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.status(404).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Acessorio> atualizarAcessorio(@PathVariable Long id, @RequestBody Acessorio acessorioAtualizado) {
        try {
            Acessorio acessorio = acessorioService.atualizarAcessorio(id, acessorioAtualizado);
            return ResponseEntity.ok(acessorio);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(404).body(null);
        }
    }
}
