package com.gustavonascimento.fin_cartoes.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavonascimento.fin_cartoes.entities.CartaoCliente;

@Repository
public interface CartaoClienteRepository extends JpaRepository<CartaoCliente, UUID>{

}
