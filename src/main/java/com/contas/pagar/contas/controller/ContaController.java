package com.contas.pagar.contas.controller;

import javax.servlet.ServletContext;

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

import com.contas.pagar.contas.models.Conta;
import com.contas.pagar.contas.repository.ContaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * Conta
 */
@RestController
@RequestMapping("/api/v1/contas")
@CrossOrigin(origins = "*")
public class ContaController implements IController<Conta> {

    @Autowired
    private ContaRepository repo;
    
    @Autowired
    ServletContext context;

    @GetMapping("")
    @Override
    public ResponseEntity<?> index() {
        return ResponseEntity.ok().body(repo.findAll());
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> findById(@PathVariable Long id) throws JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
    	
    	Conta _conta = repo.findById(id).get();
    	
    	String contaString = mapper.writeValueAsString(_conta);
    	
    	JsonNode jsonNode = mapper.readTree(contaString);
    	
    	String newString = "{\"link\": \"cowtowncoder\"}";
    	
        JsonNode newNode = mapper.readTree(newString);
    	
    	((ObjectNode)jsonNode).set("credor", newNode);
    	
        return ResponseEntity.ok().body(jsonNode);
    }

    @GetMapping("/{id}/credor")
    public ResponseEntity<?> findCredorByContaId(@PathVariable Long id) {
        return ResponseEntity.ok().body(repo.findById(id).get().getCredor());
    }

    @PostMapping("")
    @Override
    public ResponseEntity<?> insert(@RequestBody Conta entity) {
        System.out.println(entity);
        return ResponseEntity.ok().body(repo.saveAndFlush(entity));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Conta entity) {
        Conta _conta = repo.findById(id).get();
        _conta.setValor(entity.getValor());
        _conta.setVencimento(entity.getVencimento());
        return ResponseEntity.ok().body(repo.saveAndFlush(_conta));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<?> delete(@PathVariable Long id) {
        repo.deleteById(id);
        return ResponseEntity.ok().body(true);
    }

}