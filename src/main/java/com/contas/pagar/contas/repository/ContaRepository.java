package com.contas.pagar.contas.repository;

import com.contas.pagar.contas.models.Conta;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ContaRepository
 */
public interface ContaRepository extends JpaRepository<Conta, Long>{

    
}