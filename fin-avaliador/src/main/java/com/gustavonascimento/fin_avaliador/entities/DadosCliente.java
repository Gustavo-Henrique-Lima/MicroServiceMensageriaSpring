package com.gustavonascimento.fin_avaliador.entities;

import java.util.Objects;
import java.util.UUID;

public class DadosCliente {

	private UUID id;
	private String nome;

	public DadosCliente() {
	}

	public DadosCliente(UUID id, String nome) {
		this.id = id;
		this.nome = nome;
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

}