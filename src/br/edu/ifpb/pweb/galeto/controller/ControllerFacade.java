package br.edu.ifpb.pweb.galeto.controller;

import br.edu.ifpb.pweb.galeto.dao.DAOAluno;
import br.edu.ifpb.pweb.galeto.dao.DAOProfessor;
import br.edu.ifpb.pweb.galeto.dao.DAOUsuario;
import br.edu.ifpb.pweb.galeto.model.Aluno;
import br.edu.ifpb.pweb.galeto.model.Professor;
import br.edu.ifpb.pweb.galeto.model.Usuario;

public class ControllerFacade {
	
	private DAOUsuario dusuario = new DAOUsuario();
	private DAOAluno daluno = new DAOAluno();
	private DAOProfessor dprofessor = new DAOProfessor();
	private Aluno aluno;
	private Professor professor;
	
	public Usuario login(String login, String senha){
		return dusuario.findByLogin(login, senha);
	}

	public Usuario nome(String nome){
		return dusuario.findByNome(nome);
	}
	

	public void cadastrarAluno(String nome,long matricula, String email,
			int fone) {
		this.aluno = new Aluno(nome,matricula, email, fone);
		this.daluno.create(this.aluno);
	}
	
	public void cadastrarProfessor(String nomeprofessor,String matriculaprofessor) {
		this.professor = new Professor(nomeprofessor,matriculaprofessor);
		this.dprofessor.create(this.professor);
	}

	
	public Aluno VerificarMatricula(long matricula){
		return daluno.findByMatricula(matricula);
	}

	public Professor VerificarProfessor(String matriculaprofessor){
		return dprofessor.findByMatricula(matriculaprofessor);
	}

}
