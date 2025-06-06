package com.bamboobyte.APIAutoGyn.Validacoes;

public enum StatusValidacao {
    OK("OK"),

    CPF_INVALIDO("CPF inserido é inválido. Verifique os dígitos verificadores."),
    CNPJ_INVALIDO("CNPJ inserido é inválido. Verifique os dígitos verificadores."),
    CPF_TAMANHO_ERRADO("CPF deve ter 11 dígitos."),
    CNPJ_TAMANHO_ERRADO("CNPJ deve ter 14 dígitos."),
    EMAIL_INVALIDO("Email inserido é inválido."),
    TELEFONE_INVALIDO("Número de telefone inserido é inválido. Verifique o formato."),
    DDD_INVALIDO("DDD inserido é inválido. Deve estar entre 1 e 999."),
    UF_INVALIDA("UF inserida é inválida. Deve ter 2 letras."),
    CEP_INVALIDO("CEP inserido é inválido. Deve ter 8 dígitos."),
    IE_INVALIDA("Inscrição Estadual inserida é inválida."),
    NC_INVALIDO("Número de chassi inserido é inválido. Verifique o formato."),
    PLACA_INVALIDA("Placa inserida é inválida. O formato correto é AAA1A11 ou AAA-1234."),
    SKU_INVALIDO("SKU inserido é inválido. O formato correto é SKU-XXXX (onde X é um número de 4 dígitos)."),
    VEICULO_NAO_ENCONTRADO("Veículo não encontrado no sistema."),
    SEM_CPF_COLABORADOR("Faltando CPF do colaborador na requisição."),
    COLABORADOR_NAO_ENCONTRADO("Colaborador não encontrado no sistema."),
    SEM_ID_SERVICO("ID de serviço não foi informado na requisição."),
    SERVICO_NAO_ENCONTRADO("Serviço com o ID informado não encontrado no banco de dados."),
    ORCAMENTO_SEM_VALOR("Insira um valor para o orçamento."),
    QUANTIDADE_PECAS_NULA("Quantidade de peças não foi informada."),
    QUANTIDADE_PECAS_NEGATIVA("Quantidade de peças deve ser maior que zero."),
    SEM_ID_PECA("ID da peça não foi informado."),
    PECA_NAO_ENCONTRADA("Peça não encontrada no sistema."),
    QUANTIDADE_SERVICO_NULA("Quantidade de serviços não foi informada."),
    QUANTIDADE_SERVICO_NEGATIVA("Quantidade de serviços deve ser maior que zero."),
    SEM_ESTOQUE("Estoque insuficiente para o serviço.");

    private String mensagem;

    private StatusValidacao(String msg) {
        this.mensagem = msg;
    }

    public String getMensagem() {
        return this.mensagem;
    }
}
