package com.bamboobyte.APIAutoGyn.Controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
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

import com.bamboobyte.APIAutoGyn.DTO.CadastrarMarcaDTO;
import com.bamboobyte.APIAutoGyn.DTO.ListaMarcaDTO;
import com.bamboobyte.APIAutoGyn.DTO.MarcaDTO;
import com.bamboobyte.APIAutoGyn.Entities.Marca;
import com.bamboobyte.APIAutoGyn.Services.MarcaService;

@RestController
@RequestMapping("/marcas")
@CrossOrigin("*")
public class MarcaController {

    private final MarcaService marcaServico;

    public MarcaController(MarcaService marcaServico) {
        this.marcaServico = marcaServico;
    }

    @GetMapping
    public List<MarcaDTO> listarTodos() {
        return marcaServico.listarTodos();
    }

    @GetMapping("/modelos")
    public ResponseEntity<List<ListaMarcaDTO>> listarMarcasComModelos() {
        List<ListaMarcaDTO> marcasComModelos = marcaServico.listarMarcasComModelos();
        return ResponseEntity.ok(marcasComModelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaDTO> buscarPorId(@PathVariable Long id) {
        try {
            Marca marca = marcaServico.buscarPorId(id);
            return ResponseEntity.ok(new MarcaDTO(marca));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MarcaDTO> criar(@RequestBody CadastrarMarcaDTO dto) {
        try {
            Marca marca = marcaServico.incluirMarca(dto);
            return new ResponseEntity<>(new MarcaDTO(marca), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaDTO> atualizar(@PathVariable Long id, @RequestBody CadastrarMarcaDTO dto) {
        try {
            Marca marcaAtualizada = marcaServico.atualizarMarca(id, dto);
            return ResponseEntity.ok(new MarcaDTO(marcaAtualizada));
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
