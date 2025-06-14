package com.bamboobyte.APIAutoGyn.DTO;

public class CadastrarClienteDTO {
    private String nome;
    private String email;

    private boolean isPJ;
    private boolean isPF;

    private String cpf;
    private String cnpj;

    private String inscricao_estadual;
    private String nomeContato;

    private Integer ddd;
    private Integer ddd2;
    private Integer telefone;
    private Integer telefone2;
    private String cep;
    private String cidade;
    private String uf;
    private String numero;
    private String logradouro;
    private String complemento;

    public CadastrarClienteDTO(String nome, String email, boolean isPJ, boolean isPF, String cpf, String cnpj,
            String inscricao_estadual, String nomeContato, Integer ddd, Integer ddd2, Integer telefone,
            Integer telefone2, String cep, String cidade, String uf, String numero, String logradouro,
            String complemento) {
        this.nome = nome;
        this.email = email;
        this.isPJ = isPJ;
        this.isPF = isPF;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.inscricao_estadual = inscricao_estadual;
        this.nomeContato = nomeContato;
        this.ddd = ddd;
        this.ddd2 = ddd2;
        this.telefone = telefone;
        this.telefone2 = telefone2;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.numero = numero;
        this.logradouro = logradouro;
        this.complemento = complemento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isPJ() {
        return isPJ;
    }

    public void setPJ(boolean isPJ) {
        this.isPJ = isPJ;
    }

    public Integer getDdd() {
        return ddd;
    }

    public void setDdd(Integer ddd) {
        this.ddd = ddd;
    }

    public Integer getDdd2() {
        return ddd2;
    }

    public void setDdd2(Integer ddd2) {
        this.ddd2 = ddd2;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public Integer getTelefone2() {
        return telefone2;
    }

    public void setTelefone2(Integer telefone2) {
        this.telefone2 = telefone2;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricao_estadual() {
        return inscricao_estadual;
    }

    public void setInscricao_estadual(String inscricao_estadual) {
        this.inscricao_estadual = inscricao_estadual;
    }

    public String getNomeContato() {
        return nomeContato;
    }

    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    public boolean isPF() {
        return isPF;
    }

    public void setPF(boolean isPF) {
        this.isPF = isPF;
    }

}