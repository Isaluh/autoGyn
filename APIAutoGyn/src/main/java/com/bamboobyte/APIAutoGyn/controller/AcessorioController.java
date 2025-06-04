package com.bamboobyte.APIAutoGyn.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.bamboobyte.APIAutoGyn.service.AcessorioService;
import com.bamboobyte.APIAutoGyn.dto.CadastrarAcessorioDTO;
import com.bamboobyte.APIAutoGyn.valiForm.*;

@Controller
public class AcessorioController {

    private static GatewayValidacao validador = new GatewayValidacao();

    @PostMapping("/acessorio")
    public ResponseEntity<?> criarAcessorio(CadastrarAcessorioDTO novoAcessorio) throws SQLException {
        List<StatusValidacao> erros = validador.validar(novoAcessorio);
        if (erros.size() > 0) {
            return ResponseEntity.badRequest().body(new MensagemErro(erros));
        }
        if (novoAcessorio == null) {
            return ResponseEntity.badRequest().body(new MensagemErro("Envie o campo descricao."));
        }
        boolean criado = AcessorioService.criarProduto(novoAcessorio.getDescricao());
        if (criado) {
            return ResponseEntity.ok(new MensagemErro("Acessorio criado com sucesso."));
        } else {
            return ResponseEntity.badRequest().body(new MensagemErro("Já existe um acessorio com este nome"));
        }
    }

}
