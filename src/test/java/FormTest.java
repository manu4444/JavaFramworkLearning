import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;

import com.dao.FormDao;
import com.model.FormModel;

public class FormTest {
	
	  private static final String PERSISTENCE_UNIT_NAME = "formFilling";
	  EntityManagerFactory factory;
	  FormDao dao;
	  EntityManager em;
	  
	@Before
	 public void setUp() throws Exception {
		factory =   Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		em = factory.createEntityManager();
		dao = new FormDao(em);

	    // Begin a new local transaction so that we can persist a new entity
	    em.getTransaction().begin();

	    // read the existing entries
	    Query q = em.createQuery("select t from FormModel t");
	    // FormModel should be empty

	    // do we have entries?
	    boolean createNewEntries = (q.getResultList().size() == 0);

	    // No, so lets create new entries
	    if (createNewEntries) {
	      assertTrue(q.getResultList().size() == 0);
	      
	      for (int i = 0; i < 10; i++) {
	    	FormModel fm = new FormModel();
	    	fm.setName("Jim_" + i);
	    	fm.setPassword("Knopf_" + i);
	        em.persist(fm);
	      }
	    }

	    // Commit the transaction, which will cause the entity to
	    // be stored in the database
	    em.getTransaction().commit();
	  }
	
	@Test
	public void checkRead(){
		assertTrue(dao.get().size() == 10);
	}
	
	@Test
	public void checkCreate(){
		FormModel fm = new FormModel();
		fm.setName("manu");
    	fm.setPassword("khandelwal");
    	dao.save(fm);
    	assertTrue(dao.get().size() == 11);
	}
	
	@Test
	public void checkUpdate(){
		FormModel fm = new FormModel();
		fm.setName("manu");
    	fm.setPassword("kk");
    	assertTrue(dao.update(1, fm) == 0);
	}
	
	@Test
	public void checkDelete(){
		assertTrue(dao.delete(1) == 1);
		assertTrue(dao.get().size() == 10);
		
		// It is always good practice to close the EntityManager so that
	    // resources are conserved.
	    em.close();
	}

}
