package com.contas.pagar.contas.controller;

import com.contas.pagar.contas.models.Credor;
import com.contas.pagar.contas.repository.CredorRepository;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CredorController
 */
@RestController
@RequestMapping("/api/v1/credores")
@CrossOrigin(origins = "*")
public class CredorController implements IController<Credor> {

    @Autowired
    private CredorRepository repo;

    @GetMapping("")
    @Override
    public ResponseEntity<?> index(HttpServletRequest request) {
        return ResponseEntity.ok().body(repo.findAll());
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> findById(@PathVariable Long id, HttpServletRequest request) {
        return ResponseEntity.ok().body(repo.findById(id).get());
    }

    @GetMapping("/{id}/contas")
    public ResponseEntity<?> findContasByCredorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(repo.findById(id).get().getContas());
    }

    @PostMapping("")
    @Override
    public ResponseEntity<?> insert(@RequestBody Credor entity) {
        return ResponseEntity.ok().body(repo.saveAndFlush(entity));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Credor entity) {
        Credor _credor =  repo.findById(id).get();
        _credor.setNome(entity.getNome());
        _credor.setCpf(entity.getCpf());
        return ResponseEntity.ok().body(repo.saveAndFlush(_credor));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok().body(true);
    }

    
}