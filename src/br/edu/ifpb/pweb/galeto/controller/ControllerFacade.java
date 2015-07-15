package br.edu.ifpb.pweb.galeto.controller;

import br.edu.ifpb.pweb.galeto.dao.DAOAluno;
import br.edu.ifpb.pweb.galeto.dao.DAOUsuario;
import br.edu.ifpb.pweb.galeto.model.Aluno;
import br.edu.ifpb.pweb.galeto.model.Usuario;

public class ControllerFacade {
	
	private DAOUsuario dusuario = new DAOUsuario();
	private DAOAluno daluno = new DAOAluno();
	private Aluno aluno;
	
	
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
	
	public Aluno VerificarMatricula(long matricula){
		return daluno.findByMatricula(matricula);
	}

}
