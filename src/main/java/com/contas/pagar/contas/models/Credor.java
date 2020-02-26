package com.contas.pagar.contas.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Credor
 */
@Entity
public class Credor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private String nome;

    private String cpf;

	@JsonIgnore
    @OneToMany(mappedBy = "credor", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Conta> contas = new ArrayList<Conta>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
    
    
}