package dao;
// Generated 26 mai 2022 à 00:06:34 by Hibernate Tools 4.3.6.Final



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.ArticlesStock;


/**
 * Home object for domain model class ArticlesStock.
 * @see dao.ArticlesStock
 * @author Hibernate Tools
 */

public class ArticlesStockHome {

	
	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ArticlesStock transientInstance) {
		
		try {
			entityManager.persist(transientInstance);
			
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public void remove(ArticlesStock persistentInstance) {
		
		try {
			entityManager.remove(persistentInstance);
			
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public ArticlesStock merge(ArticlesStock detachedInstance) {
		
		try {
			ArticlesStock result = entityManager.merge(detachedInstance);
			
			return result;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public ArticlesStock findById(int id) {
		
		try {
			ArticlesStock instance = entityManager.find(ArticlesStock.class, id);
			
			return instance;
		} catch (RuntimeException re) {
		
			throw re;
		}
	}
}
