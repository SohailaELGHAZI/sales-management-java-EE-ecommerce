package dao;
// Generated 26 mai 2022 à 00:06:19 by Hibernate Tools 4.3.6.Final



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.Users;


/**
 * Home object for domain model class Users.
 * @see dao.Users
 * @author Hibernate Tools
 */

public class UsersHome {

	
	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Users transientInstance) {
		
		try {
			entityManager.persist(transientInstance);
			
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public void remove(Users persistentInstance) {
		
		try {
			entityManager.remove(persistentInstance);
			
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public Users merge(Users detachedInstance) {
		
		try {
			Users result = entityManager.merge(detachedInstance);
			
			return result;
		} catch (RuntimeException re) {
		
			throw re;
		}
	}

	public Users findById(Integer id) {
		
		try {
			Users instance = entityManager.find(Users.class, id);
		
			return instance;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}
}
