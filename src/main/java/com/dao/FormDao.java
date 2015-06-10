package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.model.FormModel;

//@Repository
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
	
	public FormModel get(int id){
		Query q = em.createQuery("select t from FormModel t where t.id="+id, FormModel.class);
		FormModel formModels = (FormModel)q.getSingleResult();
		return formModels;
	}
	
	public List<FormModel> get(){
		TypedQuery<FormModel> q = em.createQuery("select t from FormModel t", FormModel.class);
		List<FormModel> formModels = q.getResultList();
		return formModels;
	}
	
	public List<FormModel> save( List<FormModel> fm){
		/*TypedQuery<FormModel> q = em.createQuery("select t from FormModel t", FormModel.class);
		List<FormModel> formModels = q.getResultList();
		return formModels;*/
		em.getTransaction().begin();
		em.persist(fm.get(0));
		em.getTransaction().commit();
		
		return fm;
	}
	
	public int update(int id, FormModel fm){
		Query q = em.createQuery("update FormModel t set t.name='"+fm.getName()+"', t.password='"+fm.getPassword()+"' where t.id="+id, FormModel.class);
		em.getTransaction().begin();
		int a = q.executeUpdate();
		em.getTransaction().commit();
		return a;
		//return formModels;
	}
	
	public int delete(int id){
		Query q = em.createQuery("delete from FormModel t where t.id="+id, FormModel.class);
		em.getTransaction().begin();
		int a = q.executeUpdate();
		em.getTransaction().commit();
		return a;
		//return formModels;
	}
	

}
