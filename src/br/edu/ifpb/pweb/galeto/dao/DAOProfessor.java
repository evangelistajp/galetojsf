package br.edu.ifpb.pweb.galeto.dao;

import br.edu.ifpb.pweb.galeto.model.Professor;

public class DAOProfessor extends DAO<Professor> {
	
	public Professor findByNome(String nomeprofessor){
		return (Professor) super.findByQuery("select p from Professor p where p.nomeprofessor = " + nomeprofessor);
	}

	public Professor findByMatricula(String matriculaprofessor){
		return (Professor) super.findByQuery("select p from Professor p where p.matriculaprofessor = " + matriculaprofessor);
	}

}
