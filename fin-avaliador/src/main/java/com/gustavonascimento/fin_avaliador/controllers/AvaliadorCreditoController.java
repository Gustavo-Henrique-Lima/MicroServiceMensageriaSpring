package com.gustavonascimento.fin_avaliador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gustavonascimento.fin_avaliador.AvaliadorService;
import com.gustavonascimento.fin_avaliador.entities.SituacaoCliente;

@RestController
@RequestMapping(value = "/avaliacoes-credito")
public class AvaliadorCreditoController {
	
	@Autowired
	private AvaliadorService service;

	@GetMapping
	public String status() {
		return "Avaliador de crédito Ok!";
	}
	
	@GetMapping(value = "cliente={cpf}")
	public ResponseEntity<SituacaoCliente> consultaSituacaoCliente(@PathVariable String cpf) {
		SituacaoCliente situacaoCliente = service.obterSituacaoCliente(cpf);
	}
}