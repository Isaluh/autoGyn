package com.bamboobyte.APIAutoGyn.Controllers;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarMarcaDTO;
import com.bamboobyte.APIAutoGyn.DTO.MinimalMarcaDTO;
import com.bamboobyte.APIAutoGyn.Entities.Marca;
import com.bamboobyte.APIAutoGyn.Services.MarcaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService marcaServico;

    public MarcaController(MarcaService marcaServico) {
        this.marcaServico = marcaServico;
    }

    @GetMapping
    public List<MinimalMarcaDTO> listarTodos() {
        return marcaServico.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MinimalMarcaDTO> buscarPorId(@PathVariable Long id) {
        try {
            Marca marca = marcaServico.buscarPorId(id);
            return ResponseEntity.ok(new MinimalMarcaDTO(marca));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MinimalMarcaDTO> criar(@RequestBody CadastrarMarcaDTO dto) {
        try {
            Marca marca = marcaServico.incluirMarca(dto);
            return new ResponseEntity<>(new MinimalMarcaDTO(marca), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MinimalMarcaDTO> atualizar(@PathVariable Long id, @RequestBody CadastrarMarcaDTO dto) {
        try {
            Marca marcaAtualizada = marcaServico.atualizarMarca(id, dto);
            return ResponseEntity.ok(new MinimalMarcaDTO(marcaAtualizada));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            marcaServico.excluirMarca(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
