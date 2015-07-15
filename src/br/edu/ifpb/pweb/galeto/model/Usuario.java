package br.edu.ifpb.pweb.galeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	@Id		
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length=250)
	private String login;
	@Column(length=250)
	private String senha;
	@Column(length=250)
	private String email;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nome, String senha,String email) {
		this.login = nome;
		this.senha = senha;
		this.email = email;
	
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNome() {
		return login;
	}


	public void setNome(String nome) {
		this.login = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
}
