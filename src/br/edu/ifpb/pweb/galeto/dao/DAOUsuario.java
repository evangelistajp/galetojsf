package br.edu.ifpb.pweb.galeto.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.pweb.galeto.dao.DAO;
import br.edu.ifpb.pweb.galeto.model.Usuario;
import br.edu.ifpb.pweb.galeto.bean.UsuarioBean;



public class DAOUsuario extends DAO<Usuario> {

	public Usuario findByNome(String nome){
		return (Usuario) super.findByQuery("select u from Usuario u where u.login = " + nome);
	}
	
	public Usuario findBySenha(String s){
		return (Usuario) super.findByQuery("select u from Usuario u where u.senha = " + s);
	}
	
//	public Usuario findByLogin(String nome, String senha){
//		return (Usuario) super.findByQuery("select u from Usuario u where u.nome = "+ nome + " and u.senha =" + senha);
//	}
	
	public Usuario findByLogin(String login, String senha){
        
        Query q = manager.createQuery("select u from Usuario u where u.login = :l AND u.senha = :s");
        q.setParameter("l",login);
        q.setParameter("s",senha);
        
        try{
            Usuario user = (Usuario) q.getSingleResult();
            return user;
        }catch(NoResultException e){
            return null;
        }
        
    }
}
