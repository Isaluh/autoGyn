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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarOSDTO;
import com.bamboobyte.APIAutoGyn.DTO.ListaOSDTO;
import com.bamboobyte.APIAutoGyn.DTO.OSDTO;
import com.bamboobyte.APIAutoGyn.Services.OSService;

@RestController
@RequestMapping("/OS")
@CrossOrigin("*")
public class OSController {

    private final OSService osService;

    public OSController(OSService osService) {
        this.osService = osService;
    }

    @GetMapping
    public ResponseEntity<List<ListaOSDTO>> listarOSCadastradas() {
        List<ListaOSDTO> osList = osService.listarOSCadastradas();
        return ResponseEntity.ok(osList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OSDTO> getOs(@PathVariable Long id) {
        OSDTO os = osService.getOs(id);
        return ResponseEntity.ok(os);
    }

    @PostMapping
    public ResponseEntity<?> criarOS(@RequestBody CadastrarOSDTO novaOS) {
        System.out.println(novaOS);
        Long idOs = osService.criarOS(novaOS);
        return ResponseEntity.ok(idOs);
    }

    @PostMapping("/{id}/aprovar")
    public ResponseEntity<String> aprovarExecucaoOS(@PathVariable Long id) {
        String response = osService.aprovarExecucaoOS(id);
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
