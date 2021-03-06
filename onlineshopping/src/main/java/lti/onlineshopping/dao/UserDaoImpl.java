package lti.onlineshopping.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import lti.onlineshopping.model.User;


@Repository("userDao")
public class UserDaoImpl implements UserDaoIntf{

	public boolean insertUser(User user) {

		boolean res = false;
		
		try{
			System.out.println("Dao called");
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			res = true;
			em.close();
			emf.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return res;
	}
	
	public User validateUser(User user) {
	    
	    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		User f =null;
		try{
			f=(User)em.createQuery("SELECT f FROM User f WHERE f.username=:username and f.password=:password")
		         .setParameter("username", user.getUsername())
		         .setParameter("password",user.getPassword())
		         .getSingleResult();
		}
		catch(Exception e) {System.out.println(e); }
		em.close();
		emf.close();
		System.out.println(f);
		return f;
	  }

}
