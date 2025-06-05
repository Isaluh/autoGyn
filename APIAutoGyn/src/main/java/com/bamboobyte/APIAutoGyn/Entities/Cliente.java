package com.bamboobyte.APIAutoGyn.Entities;

import jakarta.persistence.*;
import java.util.List;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarClienteDTO;

@Entity
@Table(name = "cliente")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String email;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Telefone telefonePrincipal;

    @Embedded
    private Telefone telefoneSecundario;

    @Embedded
    private PJ pessoaJuridica;

    @Embedded
    private PF pessoaFisica;

    @OneToMany(mappedBy = "cliente")
    private List<Propriedade> propriedades;
    
    public Cliente(String nome, String email, Endereco endereco, Telefone telefonePrincipal,
            Telefone telefoneSecundario, PJ pessoaJuridica, PF pessoaFisica) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.telefonePrincipal = telefonePrincipal;
        this.telefoneSecundario = telefoneSecundario;
        this.pessoaJuridica = pessoaJuridica;
        this.pessoaFisica = pessoaFisica;
    }

    public Cliente(CadastrarClienteDTO dto) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getTelefonePrincipal() {
        return telefonePrincipal;
    }

    public void setTelefonePrincipal(Telefone telefonePrincipal) {
        this.telefonePrincipal = telefonePrincipal;
    }

    public Telefone getTelefoneSecundario() {
        return telefoneSecundario;
    }

    public void setTelefoneSecundario(Telefone telefoneSecundario) {
        this.telefoneSecundario = telefoneSecundario;
    }

    public PJ getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PJ pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }

    public PF getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PF pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public List<Propriedade> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(List<Propriedade> propriedades) {
        this.propriedades = propriedades;
    }

}
