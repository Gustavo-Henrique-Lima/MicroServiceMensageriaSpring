package com.gustavonascimento.fin_avaliador.entities;

import java.util.Objects;
import java.util.UUID;

public class DadosCliente {

	private UUID id;
	private String nome;
	private Integer idade;
	private Integer score;

	public DadosCliente() {
	}

	public DadosCliente(UUID id, String nome, Integer idade, Integer score) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.score = score;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DadosCliente other = (DadosCliente) obj;
		return Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "DadosCliente [id=" + id + ", nome=" + nome + ", idade=" + idade + ", score=" + score + "]";
	}
	
	

}