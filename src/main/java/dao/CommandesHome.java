package dao;
// Generated 26 mai 2022 à 00:06:19 by Hibernate Tools 4.3.6.Final



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.Commandes;


/**
 * Home object for domain model class Commandes.
 * @see dao.Commandes
 * @author Hibernate Tools
 */

public class CommandesHome {

	

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Commandes transientInstance) {
		
		try {
			entityManager.persist(transientInstance);
			
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public void remove(Commandes persistentInstance) {
		
		try {
			entityManager.remove(persistentInstance);
			
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public Commandes merge(Commandes detachedInstance) {
		
		try {
			Commandes result = entityManager.merge(detachedInstance);
			
			return result;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public Commandes findById(Integer id) {
		
		try {
			Commandes instance = entityManager.find(Commandes.class, id);
			
			return instance;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}
}
