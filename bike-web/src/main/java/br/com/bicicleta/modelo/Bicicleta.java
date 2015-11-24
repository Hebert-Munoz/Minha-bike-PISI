package br.com.bicicleta.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Bicicleta {

	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String descricao;
	private int nota;

	@ManyToMany(fetch = FetchType.EAGER)
	private List<Peca> pecas = new ArrayList<Peca>();

	@OneToMany
	private List<Comentario> comentarios = new ArrayList<Comentario>();
	
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public List<Peca> getPecas() {
		return pecas;
	}

	public void setPecas(List<Peca> pecas) {
		this.pecas = pecas;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Peca getBanco() {

		for (int i = 0; i < this.pecas.size(); i++) {
			if (this.pecas.get(i).getTipo().equals("Banco")) {
				return this.pecas.get(i);
			}
		}
		return null;
	}


	public Peca getQuadro() {
		for (int i = 0; i < this.pecas.size(); i++) {
			if (this.pecas.get(i).getTipo().equals("Quadro")) {
				return this.pecas.get(i);
			}
		}
		return null;

	}

	public Peca getCambio() {
		for (int i = 0; i < this.pecas.size(); i++) {
			if (this.pecas.get(i).getTipo().equals("Cambio")) {
				return this.pecas.get(i);
			}
		}
		return null;
	}

	public Peca getRodas() {
		for (int i = 0; i < this.pecas.size(); i++) {
			if (this.pecas.get(i).getTipo().equals("Rodas")) {
				return this.pecas.get(i);
			}
		}
		return null;
	}

	public Peca getGuidao() {
		for (int i = 0; i < this.pecas.size(); i++) {
			if (this.pecas.get(i).getTipo().equals("Guidao")) {
				return this.pecas.get(i);
			}
		}
		return null;
	}
}
