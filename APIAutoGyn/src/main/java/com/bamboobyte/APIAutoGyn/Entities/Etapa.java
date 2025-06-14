package com.bamboobyte.APIAutoGyn.Entities;

public enum Etapa {
    ORCAMENTO("Orçamento"),
    EXECUCAO("Execução"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado");

    private final String descricao;

    Etapa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
