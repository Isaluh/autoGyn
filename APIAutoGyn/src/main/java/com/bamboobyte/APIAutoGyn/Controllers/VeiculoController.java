package com.bamboobyte.APIAutoGyn.Controllers;

import com.bamboobyte.APIAutoGyn.DTO.*;
import com.bamboobyte.APIAutoGyn.Services.VeiculoService;
import com.bamboobyte.APIAutoGyn.Validacoes.GatewayValidacao;
import com.bamboobyte.APIAutoGyn.Validacoes.MensagemErro;
import com.bamboobyte.APIAutoGyn.Validacoes.StatusValidacao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
@CrossOrigin("*")
public class VeiculoController {

    private final VeiculoService veiculoService;
    private final GatewayValidacao validador;

    public VeiculoController(VeiculoService veiculoService, GatewayValidacao validador) {
        this.veiculoService = veiculoService;
        this.validador = validador;
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> listarVeiculosCadastrados() {
        List<VeiculoDTO> lista = veiculoService.listarVeiculosCadastrados();
        return ResponseEntity.ok(lista);
    }

    @PostMapping("/novo")
    public ResponseEntity<?> criarVeiculo(@RequestBody CadastrarVeiculoDTO novoVeiculo) {
        List<StatusValidacao> erros = validador.validar(novoVeiculo);
        if (!erros.isEmpty()) {
            return ResponseEntity.badRequest().body(new MensagemErro(erros));
        }

        String resposta = veiculoService.criarVeiculo(novoVeiculo);
        if (resposta != null) {
            return ResponseEntity.badRequest().body(new MensagemErro(resposta));
        }

        return ResponseEntity.ok("Veículo criado com sucesso.");
    }

    @PutMapping("/{placa}")
    public ResponseEntity<String> atualizarVeiculo(@PathVariable String placa,
            @RequestBody AtualizarVeiculoDTO atualizarVeiculo) {
        String resposta = veiculoService.atualizarVeiculo(placa, atualizarVeiculo);
        return ResponseEntity.ok(resposta);
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