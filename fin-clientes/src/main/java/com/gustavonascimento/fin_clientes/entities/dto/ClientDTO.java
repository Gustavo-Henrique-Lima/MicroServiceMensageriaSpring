package com.gustavonascimento.fin_clientes.entities.dto;

import java.io.Serializable;
import java.util.UUID;

import com.gustavonascimento.fin_clientes.entities.Client;

import jakarta.persistence.Column;

public class ClientDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;
	@Column(unique = true)
	private String cpf;
	private String nome;
	private Integer idade;
	private Integer score;

	public ClientDTO() {
	}

	public ClientDTO(UUID id, String cpf, String nome, Integer idade, Integer score) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.score = score;
	}

	public ClientDTO(Client entity) {
		this.id = entity.getId();
		this.cpf = entity.getCpf();
		this.nome = entity.getNome();
		this.idade = entity.getIdade();
		this.score = entity.getScore();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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

}