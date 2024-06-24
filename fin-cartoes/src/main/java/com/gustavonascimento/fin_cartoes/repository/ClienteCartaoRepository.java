package com.gustavonascimento.fin_cartoes.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavonascimento.fin_cartoes.entities.ClienteCartao;

@Repository
public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, UUID> {

	List<ClienteCartao> findByCpf(String cpf);
}