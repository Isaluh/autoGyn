package com.bamboobyte.APIAutoGyn.Controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bamboobyte.APIAutoGyn.Services.OSService;
import com.bamboobyte.APIAutoGyn.Services.RelatorioService;

@RestController
@RequestMapping("/api/os")
public class RelatorioController {

    private final OSService osService;
    private final RelatorioService GerarPDFService;

    public RelatorioController(OSService osService, RelatorioService GerarPDFService) {
        this.osService = osService;
        this.GerarPDFService = GerarPDFService;
    }

    @GetMapping("/{id}/relatorio")
    public ResponseEntity<byte[]> gerarRelatorioPDF(@PathVariable Long id) {
        var os = osService.buscarEntidadeOSPorId(id); 

        byte[] pdf = GerarPDFService.gerarRelatorio(os);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=os_" + id + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }

}
