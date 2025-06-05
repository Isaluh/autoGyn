package com.bamboobyte.APIAutoGyn.Entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "marca")
public class Marca {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
	private List<Modelo> modelos;

	public Marca() {

	}

	public Marca(Long id, String nome, List<Modelo> modelos) {
		this.id = id;
		this.nome = nome;
		this.modelos = modelos;
	}

	@Override
	public String toString() {
		return "Marca [id=" + id + ", nome=" + nome + ", modelos=" + getModelos() + "]";
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

	public List<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(List<Modelo> modelos) {
		this.modelos = modelos;
	}

}
