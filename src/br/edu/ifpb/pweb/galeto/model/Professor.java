package br.edu.ifpb.pweb.galeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {
	@Id		
	@GeneratedValue
	private long id;
	@Column(length=250)
	private String matricula;
	@Column(length=250)
	private String nome;

	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Professor [id=" + id + ", matricula=" + matricula + ", nome="
				+ nome + "]";
	}
	
	

}
