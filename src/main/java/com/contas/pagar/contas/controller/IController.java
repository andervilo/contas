package com.contas.pagar.contas.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * IController
 */
public interface IController<T> {

    ResponseEntity<?> index(HttpServletRequest request) throws JsonMappingException, JsonProcessingException;

    ResponseEntity<?> findById(Long id, HttpServletRequest request) throws JsonProcessingException;

    ResponseEntity<?> insert(T entity);

    ResponseEntity<?> update(Long id, T entity);

    ResponseEntity<?> delete(Long id);
}