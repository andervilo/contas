package com.contas.pagar.contas.controller;

import org.springframework.http.ResponseEntity;

/**
 * IController
 */
public interface IController<T> {

    ResponseEntity<?> index();

    ResponseEntity<?> findById(Long id);

    ResponseEntity<?> insert(T entity);

    ResponseEntity<?> update(Long id, T entity);

    ResponseEntity<?> delete(Long id);
}