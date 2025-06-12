package com.bamboobyte.APIAutoGyn.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarVeiculoDTO;
import com.bamboobyte.APIAutoGyn.DTO.VeiculoDTO;
import com.bamboobyte.APIAutoGyn.Services.VeiculoService;
import com.bamboobyte.APIAutoGyn.Validacoes.GatewayValidacao;
import com.bamboobyte.APIAutoGyn.Validacoes.MensagemErro;
import com.bamboobyte.APIAutoGyn.Validacoes.StatusValidacao;

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

    @PostMapping("")
    public ResponseEntity<?> criarVeiculo(@RequestBody CadastrarVeiculoDTO novoVeiculo) {
        List<StatusValidacao> erros = validador.validar(novoVeiculo);
        if (!erros.isEmpty()) {
            return ResponseEntity.badRequest().body(new MensagemErro(erros));
        }
        veiculoService.criarVeiculo(novoVeiculo);
        return ResponseEntity.ok("");
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

    @DeleteMapping("/{placa}")
    public ResponseEntity<String> deletarVeiculo(@PathVariable String placa) {
        try {
            String resposta = veiculoService.deletarVeiculoPorId(placa);
            return ResponseEntity.ok(resposta);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

}