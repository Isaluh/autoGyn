package com.bamboobyte.APIAutoGyn.Controllers;

import com.bamboobyte.APIAutoGyn.DTO.*;
import com.bamboobyte.APIAutoGyn.Services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin("*")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> listarVeiculosCadastrados() {
        List<VeiculoDTO> lista = veiculoService.listarVeiculosCadastrados();
        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<?> criarVeiculo(@RequestBody CadastrarVeiculoDTO novoVeiculo) {
        try {
            String resposta = veiculoService.criarVeiculo(novoVeiculo);
            return ResponseEntity.ok(resposta);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{placa}")
    public ResponseEntity<?> atualizarVeiculo(@PathVariable String placa, @RequestBody AtualizarVeiculoDTO atualizarVeiculo) {
        try {
            String resposta = veiculoService.atualizarVeiculo(placa, atualizarVeiculo);
            return ResponseEntity.ok(resposta);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/{placa}")
    public ResponseEntity<?> encontrarPorPlaca(@PathVariable String placa) {
        try {
            VeiculoDTO veiculoDTO = veiculoService.encontrarPorPlaca(placa);
            return ResponseEntity.ok(veiculoDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}