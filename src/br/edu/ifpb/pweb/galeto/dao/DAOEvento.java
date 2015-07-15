package br.edu.ifpb.pweb.galeto.dao;

import br.edu.ifpb.pweb.galeto.model.Evento;

public class DAOEvento extends DAO<Evento>{

	public Evento findByNome(String id){
		return (Evento) super.findByQuery("select u from evento u where u.id = " + id);
	}
}
