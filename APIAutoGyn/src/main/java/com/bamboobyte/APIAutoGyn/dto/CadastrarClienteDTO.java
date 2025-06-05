package com.bamboobyte.APIAutoGyn.dto;

public record CadastrarClienteDTO(
    String nome,
    String email,
    boolean isPJ,
    String cpf,
    String cnpj,
    String inscricaoEstadual,
    String nomeContato,
    Integer ddd,
    Integer ddd2,
    Integer telefone,
    Integer telefone2,
    String cep,
    String cidade,
    String uf,
    String numero,
    String logradouro,
    String complemento
) {}
