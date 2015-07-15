package br.edu.ifpb.pweb.galeto.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Processo {
	@Id		
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String numero;
	@OneToOne
	private Aluno aluno = new Aluno();
	private Double nota;
	@OneToOne
	private Professor orientador = new Professor();
	@OneToMany
	private List<Professor> banca = new ArrayList<Professor>();
	@OneToMany
	private List<Evento> eventos = new ArrayList<Evento>();
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	public Professor getOrientador() {
		return orientador;
	}
	public void setOrientador(Professor orientador) {
		this.orientador = orientador;
	}
	public List<Professor> getBanca() {
		return banca;
	}
	public void setBanca(List<Professor> banca) {
		this.banca = banca;
	}
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}


}
