package com.bamboobyte.APIAutoGyn.DTO;

import com.bamboobyte.APIAutoGyn.Entities.Servico;
import com.bamboobyte.APIAutoGyn.Validacoes.FormatacoesComuns;

public class ServicoDTO {
    private Long id;
    private String descricao;
    private Double valor;
    private String formatado;

    public ServicoDTO() {
    }

    public ServicoDTO(Servico servico) {
        this.id = servico.getId();
        this.descricao = servico.getDescricao();
        this.valor = servico.getValor();
        this.formatado = gerarTextoFormatado(servico.getDescricao(), servico.getValor());
    }

    public Servico toEntity() {
        Servico servico = new Servico();
        servico.setId(this.id);
        servico.setDescricao(this.descricao);
        servico.setValor(this.valor);
        return servico;
    }

    private String gerarTextoFormatado(String descricao, Double valor) {
        if (descricao == null || valor == null) return "";
        return String.format("%s | %s", descricao, FormatacoesComuns.doubleToBRL(valor));
    }

    public void atualizarFormatado() {
        this.formatado = gerarTextoFormatado(this.descricao, this.valor);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        atualizarFormatado();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
        atualizarFormatado();
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
        atualizarFormatado();
    }

    public String getFormatado() {
        return formatado;
    }

    public void setFormatado(String formatado) {
        this.formatado = formatado;
    }
}
