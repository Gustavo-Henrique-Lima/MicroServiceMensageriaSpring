package com.gustavonascimento.fin_cartoes.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavonascimento.fin_cartoes.entities.ClienteCartao;
import com.gustavonascimento.fin_cartoes.entities.dto.ClienteCartaoDTO;
import com.gustavonascimento.fin_cartoes.repository.ClienteCartaoRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteCartaoService {

	@Autowired
	private ClienteCartaoRepository repository;

	@Transactional
	public List<ClienteCartaoDTO> listCartoesByCpf(String cpf) {
		List<ClienteCartao> obj = repository.findByCpf(cpf);
		List<ClienteCartaoDTO> entities = obj.stream().map(cartao -> new ClienteCartaoDTO(cartao))
				.collect(Collectors.toList());
		return entities;
	}
}
