package Articles;
import java.util.ArrayList;


import java.util.Iterator;



import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import models.ArticlesStock;
import models.Art_commandes;
import models.ArticlesPrix;
import models.Users;
import action.HibernateUtil;

public class ListeArt {
	List results=null;
	List results1=null;

	List<Art_commandes> nameList = new ArrayList<Art_commandes>();
	//methode pour afficher la liste des articles
	public List verfier() {
		
		  Session session=null;
		  Transaction tx=null;
		  try
		  {
			  
		    session =HibernateUtil.openSession();
		    session.beginTransaction();
		    //table ArticlesStock de la base de donnée ge_stock
		    String hql = "FROM ArticlesStock";
		    //table ArticlesSPrix de la base de donnée ge_vente
			  String hql1 = "FROM ArticlesPrix";
			
			    Query query = session.createQuery(hql);
			    results = query.list();
			    
			    Query query1 = session.createQuery(hql1);
			    results1 = query1.list();
			    //On parcourit les résultats du les deux requêtes ,et pour la jonture on fait un test selon codeArt
			   if(!results.isEmpty()) {
				   for (Iterator iterator = results.iterator(); iterator.hasNext();){
				    	ArticlesStock art = (ArticlesStock) iterator.next(); 
				    	for (Iterator iterator1 = results1.iterator(); iterator1.hasNext();){
				    		ArticlesPrix art1 = (ArticlesPrix) iterator1.next();
				    		if(art.getCodeArt()==art1.getCodeArt()) {
				    	//codeArt,DescArt et AteArt de la table articlesStock et nomArt et prixArt de la table ArticlesPrix
				       Art_commandes a= new Art_commandes (art.getCodeArt(),art1.getNomArt(),art1.getPrixArt(),art.getQteArt(),art.getDescArt(),art1.getImage());
				       
				       nameList.add(a);
				    		}
				    		
				    	}
				 
				   }
				 
				  
				   
			   }
	
		  }catch(HibernateException he){
		    if(tx!=null)tx.rollback();
		    System.out.println("Not able to open session");
		    he.printStackTrace();
		  }
		  catch(Exception e){
		    e.printStackTrace();
		  }finally{
			    if(session!=null)
				    session.close();
				  }
		 return nameList;
		 
	}
}
