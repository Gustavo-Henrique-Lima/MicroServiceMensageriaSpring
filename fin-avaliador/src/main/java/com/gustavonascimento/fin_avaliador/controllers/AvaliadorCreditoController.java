package com.gustavonascimento.fin_avaliador.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gustavonascimento.fin_avaliador.AvaliadorService;
import com.gustavonascimento.fin_avaliador.controllers.exception.MicroServiceComunicattionException;
import com.gustavonascimento.fin_avaliador.controllers.exception.ResourceNotFoundException;
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

	@GetMapping(value = "/situacao-cliente", params = "cpf")
	public ResponseEntity<SituacaoCliente> consultaSituacaoCliente(@RequestParam("cpf") String cpf) {
		try {
			SituacaoCliente situacaoCliente = service.obterSituacaoCliente(cpf);
			return ResponseEntity.ok(situacaoCliente);
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (MicroServiceComunicattionException e) {
			return ResponseEntity.badRequest().build();
		}

	}
}