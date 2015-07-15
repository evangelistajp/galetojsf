package br.edu.ifpb.pweb.galeto.dao;

import java.util.List;

import javax.persistence.PersistenceUtil;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.exception.DataException;

import br.edu.ifpb.pweb.galeto.model.Aluno;

public class DAOAluno extends DAO<Aluno>{
	
	
	
	public Aluno findByNome(String nome){
		return (Aluno) super.findByQuery("select u from Aluno u where u.nome = " + nome);
	}

	public Aluno findByMatricula(long matricula){
		return (Aluno) super.findByQuery("select u from Aluno u where u.matricula = " + matricula);
		/* Query q = manager.createQuery("select u from Aluno u where u.matricula = " + matricula);
		 try{
	            Aluno alu = (Aluno) q.getSingleResult();
	            return alu;
	        }catch(NoResultException e){
	            return null;
	        } */
	}
	
/*	public List<Aluno> findAll() throws DataException{
		List<Aluno> alunos = null;
	    Query q = manager.createQuery("select a from Aluno");
		alunos = (List<Aluno>) q.getResultList();
		return alunos;
			

	}*/
}
