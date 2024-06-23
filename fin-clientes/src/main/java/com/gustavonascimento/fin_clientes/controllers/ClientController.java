package com.gustavonascimento.fin_clientes.controllers;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.gustavonascimento.fin_clientes.entities.Client;
import com.gustavonascimento.fin_clientes.entities.dto.ClientDTO;
import com.gustavonascimento.fin_clientes.services.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientService service;

	@GetMapping
	public String status() {
		return "Clientes Ok!";
	}

	@PostMapping
	public ResponseEntity<ClientDTO> inserClient(@Valid @RequestBody ClientDTO entity) {
		ClientDTO client = service.insertClient(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).body(client);
	}

	@GetMapping(params = "cpf")
	public ResponseEntity<Optional<Client>> findByCPF(@RequestParam("cpf") String cpf) {
		var entity = service.findByCpf(cpf);
		if (entity.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(entity);
	}

}