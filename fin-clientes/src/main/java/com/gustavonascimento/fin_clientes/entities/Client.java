package com.gustavonascimento.fin_clientes.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.gustavonascimento.fin_clientes.entities.dto.ClientDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_clientes")
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@UuidGenerator
	private UUID id;
	private String cpf;
	private String nome;
	private Integer idade;
	private Integer score;

	public Client() {
	}

	public Client(UUID id, String cpf, String nome, Integer idade, Integer score) {
		this.id = id;
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.score = score;
	}

	public Client(ClientDTO entity) {
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

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}

}