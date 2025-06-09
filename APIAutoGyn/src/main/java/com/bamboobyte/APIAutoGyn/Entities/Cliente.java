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
    @AttributeOverrides({
        @AttributeOverride(name = "ddd", column = @Column(name = "ddd_telefone_principal")),
        @AttributeOverride(name = "telefone", column = @Column(name = "numero_telefone_principal"))
    })
    private Telefone telefonePrincipal;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "ddd", column = @Column(name = "ddd_telefone_secundario")),
        @AttributeOverride(name = "telefone", column = @Column(name = "numero_telefone_secundario"))
    })
    private Telefone telefoneSecundario;

    @Embedded
    private PJ pessoaJuridica;

    @Embedded
    private PF pessoaFisica;

    @OneToMany(mappedBy = "cliente")
    private List<Propriedade> propriedades;

    public Cliente(CadastrarClienteDTO dto) {
        this.nome = dto.nome();
        this.email = dto.email();

        this.endereco = new Endereco(
            dto.logradouro(),
            dto.complemento(),
            dto.numero(),
            dto.cep(),
            dto.cidade(),
            dto.uf()
        );

        this.telefonePrincipal = new Telefone(
            dto.ddd(),
            dto.telefone()
        );

        this.telefoneSecundario = new Telefone(
            dto.ddd2(),
            dto.telefone2()
        );

        if (dto.isPJ()) {
            this.pessoaJuridica = new PJ(
                dto.cnpj(),
                dto.inscricaoEstadual(),
                dto.nomeContato()
            );
            this.pessoaFisica = null;
        } else if (dto.isPF()) {
            this.pessoaFisica = new PF(dto.cpf());
            this.pessoaJuridica = null;
        } else {
            throw new IllegalArgumentException("Cliente deve ser PF ou PJ.");
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

    public List<Propriedade> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(List<Propriedade> propriedades) {
        this.propriedades = propriedades;
    }

}
