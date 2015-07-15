package br.edu.ifpb.pweb.galeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aluno {

	@Id		
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length=250)
	private String nome;
	@Column(length=250)
	private long matricula;
	@Column
	private double nota;
	@Column(length=250)
	private String titulodadefesa;
	@Column(length=250)
	private String email;
	@Column
	private int fone;
	
	
	public Aluno() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Aluno(String nome, long matricula,String email,int fone) {
		this.nome = nome;
		this.matricula = matricula;
		this.email = email;
		this.fone = fone;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public long getMatricula() {
		return matricula;
	}
	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public int getFone() {
		return fone;
	}

	public void setFone(int fone) {
		this.fone = fone;
	}


	public double getNota() {
		return nota;
	}


	public void setNota(double nota) {
		this.nota = nota;
	}


	public String getTitulodadefesa() {
		return titulodadefesa;
	}


	public void setTitulodadefesa(String titulodadefesa) {
		this.titulodadefesa = titulodadefesa;
	}

	
}
