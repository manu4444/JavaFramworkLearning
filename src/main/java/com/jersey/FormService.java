package com.jersey;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
@Path("/formService")
public class FormService {

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

  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
  }

  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello() {
    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
  }

} 