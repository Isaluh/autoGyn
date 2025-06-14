package com.bamboobyte.APIAutoGyn.Validacoes;

import java.text.NumberFormat;
import java.util.Locale;

//Singleton + Adapter para adaptação de formatação numérica.

public class FormatacoesComuns implements FormatadorAdapter {

    private static final FormatacoesComuns instancia = new FormatacoesComuns();

    private FormatacoesComuns() {
    }

    public static FormatacoesComuns getInstancia() {
        return instancia;
    }

    @Override
    public String formatarParaMoedaBR(Double valor) {
        if (valor == null)
            return "R$ 0,00";
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        return formatter.format(valor);
    }
}
