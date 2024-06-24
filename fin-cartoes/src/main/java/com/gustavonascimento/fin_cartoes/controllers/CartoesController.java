package com.gustavonascimento.fin_cartoes.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavonascimento.fin_cartoes.entities.dto.CartaoDTO;
import com.gustavonascimento.fin_cartoes.entities.dto.ClienteCartaoDTO;
import com.gustavonascimento.fin_cartoes.service.CartaoService;
import com.gustavonascimento.fin_cartoes.service.ClienteCartaoService;

@RestController
@RequestMapping(value = "/cartoes")
public class CartoesController {

	@Autowired
	private CartaoService cartaoService;

	@Autowired
	private ClienteCartaoService clienteCartaoService;

	@GetMapping
	public String status() {
		return "Cartões Ok!";
	}

	@PostMapping
	public ResponseEntity<CartaoDTO> insertCartao(@RequestBody CartaoDTO entity) {
		CartaoDTO cartao = cartaoService.insertCartao(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).body(cartao);
	}

	@GetMapping(value = "/{renda}")
	public ResponseEntity<List<CartaoDTO>> getCartaoByRenda(@PathVariable Long renda) {
		List<CartaoDTO> entities = cartaoService.getCartoesRendaMenorIgual(renda);
		return ResponseEntity.ok(entities);
	}

	@GetMapping(value = "/cliente={cpf}")
	public ResponseEntity<List<ClienteCartaoDTO>> getCartoesByCliente(@PathVariable String cpf) {
		List<ClienteCartaoDTO> entities = clienteCartaoService.listCartoesByCpf(cpf);
		return ResponseEntity.ok(entities);
	}
}