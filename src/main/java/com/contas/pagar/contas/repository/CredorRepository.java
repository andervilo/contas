package com.contas.pagar.contas.repository;

import com.contas.pagar.contas.models.Credor;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CredorRepository
 */
public interface CredorRepository extends JpaRepository<Credor, Long>{

    
}