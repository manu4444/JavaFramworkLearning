package com.jersey;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.eclipseLink.FormDao;
import com.eclipseLink.FormModel;

// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/formDetail")
public class FormService {

  FormDao dao;
  
  public FormService(){
	  EntityManagerFactory factory =   Persistence.createEntityManagerFactory("formFilling");
	  EntityManager em = factory.createEntityManager();
	  this.dao = new FormDao(em);
  }
  
  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
    //return "Hello Jersey";
	  EntityManagerFactory factory =   Persistence.createEntityManagerFactory("formFilling");
	  EntityManager em = factory.createEntityManager();
	  FormDao dao = new FormDao(em);
	  // Create it
	  FormModel fm = new FormModel();
	  fm.setName("my address");
	    fm.setPassword("manu");
	  
	  // Add it
	    dao.save(fm);
//	  EntityTransaction trans = em.getTransaction();
//	  trans.begin();
//	  em.persist(fm);
//	  trans.commit();
	  
	  // Close the entity manager
	  em.close();
	  factory.close();
	  
	  
//	  ClassPathXmlApplicationContext context = 
//		        new ClassPathXmlApplicationContext("META-INF/beans.xml");
//		    
//	  
////		    FormDao dao = (FormDao)context.getBean("formDao");//new FormDao();
//		    FormDao dao = context.getBean(FormDao.class);
//		    FormModel fm = new  FormModel();
//		    fm.setName("my address");
//		    fm.setPassword("manu");
//		    dao.save(fm);
//		    context.close();
		    
	  return "Success";
  }

  
//This method is called if HTML is request
 @GET
 @Path("/user/{id}")
 @Produces(MediaType.APPLICATION_JSON)
 public FormModel getUserDetail( @PathParam("id") int id) {
	 
	 FormModel formModels = dao.get(id);
	 return formModels;
 }
 
 @GET
 @Path("/users")
 @Produces(MediaType.APPLICATION_JSON)
 public List<FormModel> getUserDetail() {
	 
	 List<FormModel> formModels = dao.get();
	 return formModels;
 }
 
 @POST
 @Path("/users")
 @Produces(MediaType.APPLICATION_JSON)
 @Consumes(MediaType.APPLICATION_JSON)
 public List<FormModel> saveUserDetail( List<FormModel> fm ) {
	 
	 List<FormModel> formModels = dao.save(fm);
	 return formModels;
 }
 
 @PUT
 @Path("/user/{id}")
 @Consumes(MediaType.APPLICATION_JSON)
 @Produces(MediaType.APPLICATION_JSON)
 public int updateUserDetail( @PathParam("id") int id, FormModel fm ) {
	 
	 int status = dao.update(id, fm);
	 return status;
 }
 
 @DELETE
 @Path("/user/{id}")
 @Produces(MediaType.APPLICATION_JSON)
 public int deleteUserDetail( @PathParam("id") int id) {
	 
	 int status = dao.delete(id);
	 return status;
 }
  

} 