package com.bamboobyte.APIAutoGyn.Entities;

public enum Etapa {
    ORCAMENTO("Orçamento"),
    APROVADO("Aprovado"),
    EXECUCAO("Execução"),
    FINALIZADO("Finalizado"),
    PAGO("Pago"),
    CANCELADO("Cancelado");

    private final String descricao;

    Etapa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
