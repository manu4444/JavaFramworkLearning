package com.eclipseLink;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FormDao {
	
//	@PersistenceContext
	EntityManager em;
	
//	@Transactional
	public void save(FormModel fm){
		//return em.merge(fm);
		em.getTransaction().begin();
		em.persist(fm);
		em.getTransaction().commit();
		
	}
	
	public FormDao( EntityManager em ){
		this.em = em;
	}

}
