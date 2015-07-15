package br.edu.ifpb.pweb.galeto.dao;

import br.edu.ifpb.pweb.galeto.model.Processo;


public class DAOProcesso extends DAO<Processo>{
	
	public Processo findByNome(String id){
		return (Processo) super.findByQuery("select u from processo u where u.id = " + id);
	}

}
