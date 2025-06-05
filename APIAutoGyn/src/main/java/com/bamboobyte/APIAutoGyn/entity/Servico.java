package com.bamboobyte.APIAutoGyn.entity;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

=======
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

>>>>>>> 47b9dfa1a724ff330a9777e9d2397b8f315db964
@Entity
@Table(name = "servico")
public class Servico {

<<<<<<< HEAD
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descricao;
	private Double valor;
=======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servico")
    private Long id;
>>>>>>> 47b9dfa1a724ff330a9777e9d2397b8f315db964

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor")
    private Double valor;

<<<<<<< HEAD
	public Servico(Long id, String descricao, Double valor) {
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
	}
=======
    @OneToMany(mappedBy = "servico", fetch = FetchType.LAZY)
    private List<ItemServico> itensServico;

    public Servico() {}

    public Long getId() {
        return id;
    }
>>>>>>> 47b9dfa1a724ff330a9777e9d2397b8f315db964

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<ItemServico> getItensServico() {
        return itensServico;
    }

<<<<<<< HEAD
	@Override
	public String toString() {
		return "Servico [id=" + id + ", descricao=" + descricao + ", valor=" + valor + "]";
	}
=======
    public void setItensServico(List<ItemServico> itensServico) {
        this.itensServico = itensServico;
    }
>>>>>>> 47b9dfa1a724ff330a9777e9d2397b8f315db964

    @Override
    public String toString() {
        return "Servico [id=" + id + ", descricao=" + descricao + ", valor=" + valor + "]";
    }
}
