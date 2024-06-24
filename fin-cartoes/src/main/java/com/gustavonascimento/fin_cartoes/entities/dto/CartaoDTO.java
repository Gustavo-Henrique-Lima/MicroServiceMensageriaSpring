package com.gustavonascimento.fin_cartoes.entities.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import com.gustavonascimento.fin_cartoes.entities.Cartao;
import com.gustavonascimento.fin_cartoes.entities.enums.BandeiraCartao;

public class CartaoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;
	private String nome;
	private BandeiraCartao bandeiraCartao;
	private BigDecimal rendaMinima;
	private BigDecimal limiteBasico;

	public CartaoDTO() {
	}

	public CartaoDTO(UUID id, String nome, BandeiraCartao bandeiraCartao, BigDecimal rendaMinima,
			BigDecimal limiteBasico) {
		this.id = id;
		this.nome = nome;
		this.bandeiraCartao = bandeiraCartao;
		this.rendaMinima = rendaMinima;
		this.limiteBasico = limiteBasico;
	}

	public CartaoDTO(Cartao entity) {
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

}