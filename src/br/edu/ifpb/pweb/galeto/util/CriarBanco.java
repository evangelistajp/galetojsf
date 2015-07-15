package br.edu.ifpb.pweb.galeto.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriarBanco {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("galeto");
		
		EntityManager manager = factory.createEntityManager();
		
		factory.close();
	}

}
