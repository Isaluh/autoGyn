package com.bamboobyte.APIAutoGyn.Controllers;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarOSDTO;
import com.bamboobyte.APIAutoGyn.DTO.OSDTO;
import com.bamboobyte.APIAutoGyn.DTO.OrdemServicoListaDTO;
import com.bamboobyte.APIAutoGyn.Services.OSService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OS")
public class OSController {

    private final OSService osService;

    public OSController(OSService osService) {
        this.osService = osService;
    }

    @GetMapping
    public ResponseEntity<List<OrdemServicoListaDTO>> listarOSCadastradas() {
        List<OrdemServicoListaDTO> osList = osService.listarOSCadastradas();
        return ResponseEntity.ok(osList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OSDTO> getOs(@PathVariable Long id) {
        OSDTO os = osService.getOs(id);
        return ResponseEntity.ok(os);
    }

    @PostMapping
    public ResponseEntity<Long> criarOS(@RequestBody CadastrarOSDTO novaOS) {
        Long idOs = osService.criarOS(novaOS);
        return ResponseEntity.ok(idOs);
    }

    @PostMapping("/{id}/aprovar")
    public ResponseEntity<String> aprovarOS(@PathVariable Long id) {
        String response = osService.aprovarOS(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/iniciar-execucao")
    public ResponseEntity<String> iniciarExecucaoOS(@PathVariable Long id) {
        String response = osService.iniciarExecucaoOS(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelarOS(@PathVariable Long id) {
        String response = osService.cancelarOS(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/pagar")
    public ResponseEntity<String> pagarOS(@PathVariable Long id, @RequestParam Double valorPago) {
        String response = osService.pagarOS(id, valorPago);
        return ResponseEntity.ok(response);
    }
}
