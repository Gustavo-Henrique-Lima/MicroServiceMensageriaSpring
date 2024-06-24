package com.gustavonascimento.fin_avaliador.infra;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gustavonascimento.fin_avaliador.entities.DadosCliente;

@FeignClient(value = "fin-clientes", path = "/clients")
public interface ClientsResourceClient {
	
	@GetMapping(params = "cpf")
	ResponseEntity<DadosCliente> findByCPF(@RequestParam("cpf") String cpf);

}