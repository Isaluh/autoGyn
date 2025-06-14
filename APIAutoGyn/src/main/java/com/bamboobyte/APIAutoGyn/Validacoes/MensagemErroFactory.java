package com.bamboobyte.APIAutoGyn.Validacoes;

import java.util.List;

//Factory Method para criar instâncias de MensagemErro de forma padronizada.

public class MensagemErroFactory {

    public static MensagemErro criarMensagem(String msg) {
        return new MensagemErro(msg);
    }

    public static MensagemErro criarMensagem(StatusValidacao status) {
        return new MensagemErro(status);
    }

    public static MensagemErro criarMensagem(List<StatusValidacao> erros) {
        return new MensagemErro(erros);
    }
}
