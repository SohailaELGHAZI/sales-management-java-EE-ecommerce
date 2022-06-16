package dao;
// Generated 26 mai 2022 à 00:06:19 by Hibernate Tools 4.3.6.Final



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import models.ArticlesPrix;

/**
 * Home object for domain model class ArticlesPrix.
 * @see dao.ArticlesPrix
 * @author Hibernate Tools
 */

public class ArticlesPrixHome {



	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ArticlesPrix transientInstance) {
		
		try {
			entityManager.persist(transientInstance);
			
		} catch (RuntimeException re) {
	
			throw re;
		}
	}

	public void remove(ArticlesPrix persistentInstance) {
		
		try {
			entityManager.remove(persistentInstance);
		
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public ArticlesPrix merge(ArticlesPrix detachedInstance) {
		
		try {
			ArticlesPrix result = entityManager.merge(detachedInstance);
			
			return result;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}

	public ArticlesPrix findById(int id) {

		try {
			ArticlesPrix instance = entityManager.find(ArticlesPrix.class, id);
			
			return instance;
		} catch (RuntimeException re) {
			
			throw re;
		}
	}
}
