package com.gustavonascimento.fin_cartoes.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.gustavonascimento.fin_cartoes.entities.dto.CartaoDTO;
import com.gustavonascimento.fin_cartoes.entities.enums.BandeiraCartao;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cartao")
public class Cartao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@UuidGenerator
	private UUID id;
	private String nome;
	private BandeiraCartao bandeiraCartao;
	private BigDecimal rendaMinima;
	private BigDecimal limiteBasico;

	public Cartao() {
	}

	public Cartao(UUID id, String nome, BandeiraCartao bandeiraCartao, BigDecimal rendaMinima,
			BigDecimal limiteBasico) {
		this.id = id;
		this.nome = nome;
		this.bandeiraCartao = bandeiraCartao;
		this.rendaMinima = rendaMinima;
		this.limiteBasico = limiteBasico;
	}

	public Cartao(CartaoDTO entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.bandeiraCartao = entity.getBandeiraCartao();
		this.rendaMinima = entity.getRendaMinima();
		this.limiteBasico = entity.getLimiteBasico();
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

	public BandeiraCartao getBandeiraCartao() {
		return bandeiraCartao;
	}

	public void setBandeiraCartao(BandeiraCartao bandeiraCartao) {
		this.bandeiraCartao = bandeiraCartao;
	}

	public BigDecimal getRendaMinima() {
		return rendaMinima;
	}

	public void setRendaMinima(BigDecimal rendaMinima) {
		this.rendaMinima = rendaMinima;
	}

	public BigDecimal getLimiteBasico() {
		return limiteBasico;
	}

	public void setLimiteBasico(BigDecimal limiteBasico) {
		this.limiteBasico = limiteBasico;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cartao other = (Cartao) obj;
		return Objects.equals(id, other.id);
	}

}