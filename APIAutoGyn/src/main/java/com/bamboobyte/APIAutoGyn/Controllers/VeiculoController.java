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

    @PostMapping("/novo")
    public ResponseEntity<String> criarVeiculo(@RequestBody CadastrarVeiculoDTO novoVeiculo) {
        String resposta = veiculoService.criarVeiculo(novoVeiculo);
        return ResponseEntity.ok(resposta);
    }

    @PutMapping("/{placa}")
    public ResponseEntity<String> atualizarVeiculo(@PathVariable String placa, 
                                                   @RequestBody AtualizarVeiculoDTO atualizarVeiculo) {
        String resposta = veiculoService.atualizarVeiculo(placa, atualizarVeiculo);
        return ResponseEntity.ok(resposta);
    }

    @GetMapping("/{placa}")
    public ResponseEntity<VeiculoDTO> encontrarPorPlaca(@PathVariable String placa) {
        VeiculoDTO veiculoDTO = veiculoService.encontrarPorPlaca(placa);
        if (veiculoDTO == null) {
            return ResponseEntity.status(404).body(null);
        }
        return ResponseEntity.ok(veiculoDTO);
    }
}
