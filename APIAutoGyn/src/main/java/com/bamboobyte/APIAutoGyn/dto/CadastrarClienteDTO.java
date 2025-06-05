package com.bamboobyte.APIAutoGyn.DTO;

public record CadastrarClienteDTO(
    String nome,
    String email,
    String logradouro,
    String complemento,
    String numero,
    String cep,
    String cidade,
    String uf,
    Integer ddd,
    Integer telefone,
    Integer ddd2,
    Integer telefone2,
    String cnpj,
    String inscricaoEstadual,
    String nomeContato,
    String cpf,
    boolean isPJ,
    boolean isPF
) {}
