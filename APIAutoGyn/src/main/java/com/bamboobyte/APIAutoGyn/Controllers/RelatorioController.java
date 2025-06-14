package com.bamboobyte.APIAutoGyn.Controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bamboobyte.APIAutoGyn.Services.OSService;
import com.bamboobyte.APIAutoGyn.Services.RelatorioService;

@RestController
@RequestMapping("/api/os")
public class RelatorioController {

    private final OSService osService;
    private final RelatorioService relatorioService;

    public RelatorioController(OSService osService, RelatorioService relatorioService) {
        this.osService = osService;
        this.relatorioService = relatorioService;
    }

    @GetMapping("/relatorio-geral")
    public ResponseEntity<byte[]> gerarRelatorioGeral() {
        var listaOs = osService.buscarEntidadesOS();
        byte[] pdf = relatorioService.gerarRelatorioGeral(listaOs);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=relatorio_geral_os.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdf);
    }

}
