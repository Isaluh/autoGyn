package com.bamboobyte.APIAutoGyn.Validacoes;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatacoesComuns {
    public static String doubleToBRL(Double value) {
        if (value == null) {
            return "R$ 0,00";
        }

        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));
        return formatter.format(value);
    }
}
