package com.contas.pagar.contas.controller;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * IController
 */
public interface IController<T> {

    ResponseEntity<?> index();

    ResponseEntity<?> findById(Long id) throws JsonProcessingException;

    ResponseEntity<?> insert(T entity);

    ResponseEntity<?> update(Long id, T entity);

    ResponseEntity<?> delete(Long id);
}