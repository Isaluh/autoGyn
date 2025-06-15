package com.bamboobyte.APIAutoGyn.Validacoes;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.regex.Pattern;

//Singleton que centraliza validações de entrada de dados.
// 1.1 - Linguagens Formais e Autômatos e Compiladores

class Validador {

    private static final Validador instancia = new Validador();

    private Validador() {
    }

    public static Validador getInstancia() {
        return instancia;
    }

    public StatusValidacao validaCPF(String CPF) {
        if (CPF == null)
            return StatusValidacao.CPF_INVALIDO;

        CPF = CPF.replaceAll("[^\\d]", "");

        if (CPF.length() != 11)
            return StatusValidacao.CPF_TAMANHO_ERRADO;

        if (CPF.matches("(\\d)\\1{10}"))
            return StatusValidacao.CPF_INVALIDO;

        CharacterIterator it = new StringCharacterIterator(CPF);
        int d1 = 0, d2 = 0, d1Input, d2Input;
        int[] digitos = new int[11];
        int pos = 0;
        while (it.current() != CharacterIterator.DONE) {
            digitos[pos++] = Character.getNumericValue(it.current());
            it.next();
        }

        d1Input = digitos[9];
        d2Input = digitos[10];

        // Cálculo do primeiro dígito
        int val = 0, peso = 10;
        for (int i = 0; i < 9; i++)
            val += digitos[i] * peso--;
        int res1 = val % 11;
        d1 = (res1 < 2) ? 0 : 11 - res1;
        if (d1 != d1Input)
            return StatusValidacao.CPF_INVALIDO;

        // Cálculo do segundo dígito
        val = 0;
        peso = 11;
        for (int i = 0; i < 10; i++)
            val += digitos[i] * peso--;
        int res2 = val % 11;
        d2 = (res2 < 2) ? 0 : 11 - res2;
        if (d2 != d2Input)
            return StatusValidacao.CPF_INVALIDO;

        return null;
    }

    public StatusValidacao validaCNPJ(String CNPJ) {
        if (CNPJ == null)
            return StatusValidacao.CNPJ_INVALIDO;

        // Remove caracteres especiais
        CNPJ = CNPJ.replaceAll("[^\\d]", "");

        if (CNPJ.length() != 14)
            return StatusValidacao.CNPJ_TAMANHO_ERRADO;
        if (CNPJ.matches("(\\d)\\1{13}"))
            return StatusValidacao.CNPJ_INVALIDO;

        CharacterIterator it = new StringCharacterIterator(CNPJ);
        int[] digitos = new int[14];
        int pos = 0;
        while (it.current() != CharacterIterator.DONE) {
            digitos[pos++] = Character.getNumericValue(it.current());
            it.next();
        }

        int d1Input = digitos[12];
        int d2Input = digitos[13];
        int d1 = 0, d2 = 0, val = 0, peso = 5;

        // Primeiro dígito
        for (int i = 0; i < 12; i++) {
            val += digitos[i] * peso--;
            if (peso == 1)
                peso = 9;
        }
        int res1 = val % 11;
        d1 = (res1 < 2) ? 0 : 11 - res1;
        if (d1 != d1Input)
            return StatusValidacao.CNPJ_INVALIDO;

        // Segundo dígito
        val = 0;
        peso = 6;
        for (int i = 0; i < 13; i++) {
            val += digitos[i] * peso--;
            if (peso == 1)
                peso = 9;
        }
        int res2 = val % 11;
        d2 = (res2 < 2) ? 0 : 11 - res2;
        if (d2 != d2Input)
            return StatusValidacao.CNPJ_INVALIDO;

        return null;
    }

    public StatusValidacao validaEmail(String email) {
        if (email == null)
            return StatusValidacao.EMAIL_INVALIDO;

        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,7}$";
        return Pattern.matches(regex, email) ? null : StatusValidacao.EMAIL_INVALIDO;
    }

    public StatusValidacao validaTelefone(Integer telefone) {
        if (telefone == null)
            return StatusValidacao.TELEFONE_INVALIDO;

        String telefoneStr = String.valueOf(telefone);
        return telefoneStr.matches("^[1-9][0-9]{7,8}$") ? null : StatusValidacao.TELEFONE_INVALIDO;
    }

    public StatusValidacao validaCEP(String CEP) {
        return (CEP != null && CEP.matches("^\\d{8}$")) ? null : StatusValidacao.CEP_INVALIDO;
    }

    public StatusValidacao validaUF(String UF) {
        return (UF != null && UF.matches("^[A-Z]{2}$")) ? null : StatusValidacao.UF_INVALIDA;
    }

    public StatusValidacao validaDDD(Integer DDD) {
        return (DDD != null && DDD >= 1 && DDD <= 999) ? null : StatusValidacao.DDD_INVALIDO;
    }

    public StatusValidacao validaInscricaoEstadual(String inscricao) {
        if (inscricao == null || inscricao.trim().isEmpty()) {
            return StatusValidacao.IE_INVALIDA;
        }

        String regex = "^\\d{9,14}$";
        boolean formatoValido = Pattern.matches(regex, inscricao);

        return formatoValido ? null : StatusValidacao.IE_INVALIDA;
    }

    public StatusValidacao validaPlaca(String placa) {
        if (placa == null)
            return StatusValidacao.PLACA_INVALIDA;
        return (placa.matches("^[A-Z]{3}[0-9][A-Z][0-9]{2}$") || placa.matches("^[A-Z]{3}-[0-9]{4}$"))
                ? null
                : StatusValidacao.PLACA_INVALIDA;
    }

    public StatusValidacao validaSKU(String sku) {
        return (sku != null && sku.matches("^SKU-\\d{4}$")) ? null : StatusValidacao.SKU_INVALIDO;
    }
}
