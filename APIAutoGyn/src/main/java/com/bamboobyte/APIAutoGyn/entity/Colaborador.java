package com.bamboobyte.APIAutoGyn.entity;

<<<<<<< HEAD
public class Colaborador {
	private String cpf;
	private String nome;
	

	
	@Override
	public String toString() {
		return "Colaborador [cpf=" + cpf + ", nome=" + nome + "]";
	}
=======
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "colaborador")
public class Colaborador {

    @Id
    @Column(name = "cpf", length = 14)
    private String cpf;
>>>>>>> 47b9dfa1a724ff330a9777e9d2397b8f315db964

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY)
    private List<ItemServico> itensServico;

    public Colaborador() {}

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ItemServico> getItensServico() {
        return itensServico;
    }

    public void setItensServico(List<ItemServico> itensServico) {
        this.itensServico = itensServico;
    }

    @Override
    public String toString() {
        return "Colaborador [cpf=" + cpf + ", nome=" + nome + "]";
    }
}
