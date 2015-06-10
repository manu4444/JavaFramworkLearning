package com.service;
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

import com.dao.FormDao;
import com.model.FormModel;

@Path("/formDetail")
public class FormService {

  FormDao dao;
  
  public FormService(){
	  EntityManagerFactory factory =   Persistence.createEntityManagerFactory("formFilling");
	  EntityManager em = factory.createEntityManager();
	  this.dao = new FormDao(em);
  }

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