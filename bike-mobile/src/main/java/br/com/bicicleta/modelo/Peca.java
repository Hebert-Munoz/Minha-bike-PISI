package br.com.bicicleta.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Peca {

	@Id
	@GeneratedValue
	private Long id;

	private String nome;

	private String tipo;

	private String marca;

	private String descricao;
	
	@ManyToMany(mappedBy = "pecas",fetch = FetchType.EAGER)
	private List<Bicicleta> bicicletas = new ArrayList<Bicicleta>();
	
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public boolean equals(Object other){
		if (other == null) {
			return false;
		}
		
		if (this == other) {
			return true;
		}
		
		Peca otherPeca = (Peca) other;
		
		StringBuilder strBuilderThis = new StringBuilder();
		strBuilderThis.append(this.nome)
		.append(this.tipo)
		.append(this.marca)
		.append(this.descricao);
		
		StringBuilder strBuilderOther = new StringBuilder();
		strBuilderOther.append(otherPeca.getNome())
		.append(otherPeca.getTipo())
		.append(otherPeca.getMarca())
		.append(otherPeca.getDescricao());
		
		return strBuilderThis.toString().equals(strBuilderOther.toString());
	}

}
