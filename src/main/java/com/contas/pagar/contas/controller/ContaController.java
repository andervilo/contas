package com.contas.pagar.contas.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
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

import com.contas.pagar.contas.models.Conta;
import com.contas.pagar.contas.repository.ContaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

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
    public ResponseEntity<?> index(HttpServletRequest request) throws JsonMappingException, JsonProcessingException {
        return ResponseEntity.ok().body(getListaContasComLink(repo.findAll(), request));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<?> findById(@PathVariable Long id, HttpServletRequest request) throws JsonProcessingException {    	
    	Conta _conta = repo.findById(id).get();    	    	
        return ResponseEntity.ok().body(getContaComLinks(_conta, request));
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
    
    private List<JsonNode> getListaContasComLink(List<Conta> _contas, HttpServletRequest request) throws JsonMappingException, JsonProcessingException {
    	List<JsonNode> ljn = new ArrayList<JsonNode>();
    	
    	_contas.forEach(conta -> {
    		try {
				ljn.add(getContaComLinks(conta, request));
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
    	});
    	
    	return ljn;
    }
    
    private JsonNode getContaComLinks(Conta _conta, HttpServletRequest request) throws JsonMappingException, JsonProcessingException {
    	ObjectMapper mapper = new ObjectMapper();
    	JsonNode contaJsonNode = mapper.readTree(mapper.writeValueAsString(_conta));
    	((ObjectNode)contaJsonNode).set("credor", getCredorUrl(_conta, request));
    	((ObjectNode)contaJsonNode).set("url", getUrl(_conta, request));
    	
    	return contaJsonNode;
    }
    
    private String getBaseUrl(HttpServletRequest request) {
    	return String.format("%s://%s:%d"
    			.concat("/api/v1/contas/")
    			,request.getScheme(),  request.getServerName(), request.getServerPort());
    }
    
    private JsonNode getCredorUrl(Conta _conta, HttpServletRequest request) {
    	String urlCredor = getBaseUrl(request);
    	urlCredor = urlCredor.concat(Long.toString(_conta.getId())).concat("/credor");
    	
    	JsonNode credorNode = new TextNode(urlCredor);
    	
    	return credorNode;
    }
    
    private JsonNode getUrl(Conta _conta, HttpServletRequest request) {
    	String url = getBaseUrl(request);
    	url = url.concat(Long.toString(_conta.getId()));
    	
    	JsonNode urlNode = new TextNode(url);
    	
    	return urlNode;
    }
    
}