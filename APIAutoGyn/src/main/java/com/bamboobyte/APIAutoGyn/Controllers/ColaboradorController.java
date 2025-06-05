package com.bamboobyte.APIAutoGyn.Controllers;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarColaboradorDTO;
import com.bamboobyte.APIAutoGyn.DTO.ColaboradorDTO;
import com.bamboobyte.APIAutoGyn.Entities.Colaborador;
import com.bamboobyte.APIAutoGyn.Services.ColaboradorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/colaboradores")
@CrossOrigin("*")
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    public ColaboradorController(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> listarTodos() {
        List<ColaboradorDTO> colaboradores = colaboradorService.listarTodos();
        return ResponseEntity.ok(colaboradores);
    }

    @PostMapping
    public ResponseEntity<Colaborador> incluirColaborador(@RequestBody CadastrarColaboradorDTO novoColaboradorDTO) {
        Colaborador colaborador = colaboradorService.incluirColaborador(novoColaboradorDTO);
        return ResponseEntity.ok(colaborador);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Colaborador> buscarColaboradorPorId(@PathVariable Long id) {
        Colaborador colaborador = colaboradorService.buscarPorId(id);
        return ResponseEntity.ok(colaborador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Colaborador> atualizarColaborador(@PathVariable Long id, 
                                                           @RequestBody CadastrarColaboradorDTO colaboradorDTO) {
        Colaborador colaboradorAtualizado = colaboradorService.atualizarColaborador(id, colaboradorDTO);
        return ResponseEntity.ok(colaboradorAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirColaborador(@PathVariable Long id) {
        colaboradorService.excluirColaborador(id);
        return ResponseEntity.noContent().build();
    }
}
