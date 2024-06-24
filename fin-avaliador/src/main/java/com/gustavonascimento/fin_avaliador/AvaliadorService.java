package com.gustavonascimento.fin_avaliador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gustavonascimento.fin_avaliador.controllers.exception.MicroServiceComunicattionException;
import com.gustavonascimento.fin_avaliador.controllers.exception.ResourceNotFoundException;
import com.gustavonascimento.fin_avaliador.entities.CartaoCliente;
import com.gustavonascimento.fin_avaliador.entities.DadosCliente;
import com.gustavonascimento.fin_avaliador.entities.SituacaoCliente;
import com.gustavonascimento.fin_avaliador.infra.CartoesResourceClient;
import com.gustavonascimento.fin_avaliador.infra.ClientsResourceClient;

@Service
public class AvaliadorService {

	@Autowired
	private ClientsResourceClient clientsClient;

	@Autowired
	private CartoesResourceClient cartoesClient;

	public SituacaoCliente obterSituacaoCliente(String cpf)
			throws ResourceNotFoundException, MicroServiceComunicattionException {
		try {
			ResponseEntity<DadosCliente> dadosClientes = clientsClient.findByCPF(cpf);
			ResponseEntity<List<CartaoCliente>> cartoesCliente = cartoesClient.getCartoesByCliente(cpf);
			return new SituacaoCliente(dadosClientes.getBody(), cartoesCliente.getBody());
		} catch (feign.FeignException.FeignClientException e) {
			int status = e.status();
			if (HttpStatus.NOT_FOUND.value() == status) {
				throw new ResourceNotFoundException("Cliente não encontrado na nossa base de dados.");
			}
			throw new MicroServiceComunicattionException(e.getMessage());
		}

	}
}
