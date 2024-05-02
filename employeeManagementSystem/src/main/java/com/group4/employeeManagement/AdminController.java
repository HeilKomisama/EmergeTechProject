package com.group4.employeeManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


// Class acts as Controller for Users
public class AdminController {
	private final EntityManagerFactory emf;
	
	public AdminController() {
		emf = Persistence.createEntityManagerFactory("employeeschema");
	}
	
	public Admin findUserByUsername(String username) {
		EntityManager em = emf.createEntityManager();
		try {
			return em.createQuery("SELECT u FROM User u where u.username = :username", Admin.class)
					.setParameter("username", username).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			em.close();
		}
	}
	
	public Admin checkUser(String username) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeschema"); //manager factory to access the database
        EntityManager em = emf.createEntityManager(); //manager to perform database operations
        try {
            return em.createQuery("SELECT u FROM Admin u WHERE u.username = :username", Admin.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }

    public Admin checkPass(String password) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeschema"); //manager factory to access the database
        EntityManager em = emf.createEntityManager(); //manager to perform database operations
        try {
            return em.createQuery("SELECT u FROM Admin u WHERE u.password = :password", Admin.class)
                    .setParameter("password", password)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
    }
    
    @SuppressWarnings("null")
    public int getMaxId() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeschema");
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT MAX(e.id) FROM Admin e", int.class)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return (Integer) null;
        } finally {
            em.close();
            emf.close();
        }
    }
}
