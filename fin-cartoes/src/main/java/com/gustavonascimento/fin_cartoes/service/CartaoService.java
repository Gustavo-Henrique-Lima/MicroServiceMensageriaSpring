package com.gustavonascimento.fin_cartoes.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.fin_cartoes.entities.Cartao;
import com.gustavonascimento.fin_cartoes.entities.dto.CartaoDTO;
import com.gustavonascimento.fin_cartoes.repository.CartaoRepository;

import jakarta.transaction.Transactional;

@Service
public class CartaoService {

	@Autowired
	private CartaoRepository repository;

	@Transactional
	public CartaoDTO insertCartao(CartaoDTO dto) {
		Cartao entity = new Cartao();
		copyDtoToEntity(entity, dto);
		entity = repository.save(entity);
		return new CartaoDTO(entity);
	}

	@Transactional
	public List<CartaoDTO> getCartoesRendaMenorIgual(Long renda) {
		List<Cartao> obj = repository.findByRendaLessThanEquals(new BigDecimal(renda));
		List<CartaoDTO> entities = obj.stream().map(cartao -> new CartaoDTO(cartao)).collect(Collectors.toList());
		return entities;
	}

	private void copyDtoToEntity(Cartao entity, CartaoDTO dto) {
		entity.setNome(dto.getNome());
		entity.setBandeiraCartao(dto.getBandeiraCartao());
		entity.setRendaMinima(dto.getRendaMinima());
		entity.setLimiteBasico(dto.getLimiteBasico());
	}
}