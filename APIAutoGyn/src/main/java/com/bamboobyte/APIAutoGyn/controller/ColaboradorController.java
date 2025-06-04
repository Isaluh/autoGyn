package com.bamboobyte.APIAutoGyn.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.bamboobyte.APIAutoGyn.service.ColaboradorService;
import com.bamboobyte.APIAutoGyn.dto.CadastrarColaboradorDTO;
import com.bamboobyte.APIAutoGyn.dto.ColaboradorDTO;
import com.bamboobyte.APIAutoGyn.valiForm.*;

@Controller
public class ColaboradorController {

    private static GatewayValidacao validador = new GatewayValidacao();

    @GetMapping("/colaborador")
    public ResponseEntity<List<ColaboradorDTO>> todosColaboradores() throws SQLException {
        return ResponseEntity.ok(ColaboradorService.listarTodos());
    }

    @PostMapping("/colaborador")
    public ResponseEntity<?> novoColaborador(CadastrarColaboradorDTO novoColaboradorDTO) throws SQLException {
        List<StatusValidacao> erros = validador.validar(novoColaboradorDTO);

        if (erros.size() > 0) {
            return ResponseEntity.badRequest().body(new MensagemErro(erros));
        }

        String status = ColaboradorService.incluirColaborador(novoColaboradorDTO);
        if (status == null) {
            return ResponseEntity.ok("Colaborador Criado com sucesso.");
        }
        return ResponseEntity.badRequest().body(new MensagemErro(status));
    }
}
