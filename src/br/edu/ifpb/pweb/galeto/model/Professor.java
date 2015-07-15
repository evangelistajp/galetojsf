package br.edu.ifpb.pweb.galeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Professor {
	@Id		
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(length=250)
	private String matriculaprofessor;
	@Column(length=250)
	private String nomeprofessor;


	public Professor() {
		// TODO Auto-generated constructor stub
	}
	
	public Professor(String nomeprofessor,String matriculaprofessor){
		this.matriculaprofessor = matriculaprofessor;
		this.nomeprofessor = nomeprofessor;
	}

		
	public String getMatriculaprofessor() {
		return matriculaprofessor;
	}


	public void setMatriculaprofessor(String matriculaprofessor) {
		this.matriculaprofessor = matriculaprofessor;
	}


	public String getNomeprofessor() {
		return nomeprofessor;
	}


	public void setNomeprofessor(String nomeprofessor) {
		this.nomeprofessor = nomeprofessor;
	}


	@Override
	public String toString() {
		return "Professor [id=" + id + ", matriculaprofessor="
				+ matriculaprofessor + ", nomeprofessor=" + nomeprofessor + "]";
	}

	

}
