package com.gustavonascimento.fin_avaliador.infra;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gustavonascimento.fin_avaliador.entities.CartaoCliente;

@FeignClient(value = "fin-cartoes", path = "/cartoes")
public interface CartoesResourceClient {

	@GetMapping(params = "cpf")
	ResponseEntity<List<CartaoCliente>> getCartoesByCliente(@RequestParam("cpf") String cpf);
}