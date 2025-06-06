package com.bamboobyte.APIAutoGyn.Controllers;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarModeloDTO;
import com.bamboobyte.APIAutoGyn.DTO.ModeloDTO;
import com.bamboobyte.APIAutoGyn.Entities.Modelo;
import com.bamboobyte.APIAutoGyn.Services.ModeloService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    private final ModeloService modeloServico;

    public ModeloController(ModeloService modeloServico) {
        this.modeloServico = modeloServico;
    }

    @GetMapping
    public List<ModeloDTO> listarTodos() {
        return modeloServico.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloDTO> buscarPorId(@PathVariable Long id) {
        try {
            Modelo modelo = modeloServico.buscarPorId(id);
            return ResponseEntity.ok(new ModeloDTO(modelo));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ModeloDTO> criar(@RequestBody CadastrarModeloDTO dto) {
        try {
            Modelo modelo = modeloServico.incluirModelo(dto);
            return new ResponseEntity<>(new ModeloDTO(modelo), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloDTO> atualizar(@PathVariable Long id, @RequestBody CadastrarModeloDTO dto) {
        try {
            Modelo modeloAtualizado = modeloServico.atualizarModelo(id, dto);
            return ResponseEntity.ok(new ModeloDTO(modeloAtualizado));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        try {
            modeloServico.excluirModelo(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
