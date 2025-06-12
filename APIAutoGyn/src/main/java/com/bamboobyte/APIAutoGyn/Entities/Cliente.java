package com.bamboobyte.APIAutoGyn.Entities;

import java.util.List;

import com.bamboobyte.APIAutoGyn.DTO.CadastrarClienteDTO;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

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
    @AttributeOverrides({
        @AttributeOverride(name = "ddd", column = @Column(name = "ddd_telefone_principal")),
        @AttributeOverride(name = "telefone", column = @Column(name = "numero_telefone_principal"))
    })
    private Telefone telefonePrincipal;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "ddd", column = @Column(name = "ddd_telefone_secundario", nullable = true)),
        @AttributeOverride(name = "telefone", column = @Column(name = "numero_telefone_secundario", nullable = true))
    })
    private Telefone telefoneSecundario;


    @Embedded
    private PJ pessoaJuridica;

    @Embedded
    private PF pessoaFisica;

    
    public Cliente(CadastrarClienteDTO dto) {
        this.nome = dto.getNome();
        this.email = dto.getEmail();

        this.endereco = new Endereco(
            dto.getLogradouro(),
            dto.getComplemento(),
            dto.getNumero(),
            dto.getCep(),
            dto.getCidade(),
            dto.getUf()
        );

        this.telefonePrincipal = new Telefone(
            dto.getDdd(),
            dto.getTelefone()
        );

        if(dto.getDdd2() != null && dto.getTelefone2() != null){
            this.telefoneSecundario = new Telefone(
                dto.getDdd2(),
                dto.getTelefone2()
            );
        }

        if (dto.isPJ() && dto.isPF()) {
            throw new IllegalArgumentException("Cliente não pode ser PF e PJ ao mesmo tempo.");
        } else if (!dto.isPJ() && !dto.isPF()) {
            throw new IllegalArgumentException("Cliente deve ser PF ou PJ.");
        } else {
            if (dto.isPJ()) {
                this.pessoaJuridica = new PJ(
                    dto.getCnpj(),
                    dto.getInscricao_estadual(),
                    dto.getNomeContato()
                );
                this.pessoaFisica = null;
            } 
            else if (dto.isPF()) {
                this.pessoaFisica = new PF(dto.getCpf());
                this.pessoaJuridica = null;
            }
        }
    }

    public Cliente() {
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

}

