package com.jersey;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
//	  EntityManagerFactory factory =   Persistence.createEntityManagerFactory("example");
//	  EntityManager em = factory.createEntityManager();
//	  // Create it
//	  com.eclipseLink.Hello t = new com.eclipseLink.Hello();
//	  t.setText("Heya");
//	  
//	  // Add it
//	  EntityTransaction trans = em.getTransaction();
//	  trans.begin();
//	  em.persist(t);
//	  trans.commit();
//	  
//	  // Close the entity manager
//	  em.close();
//	  factory.close();
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