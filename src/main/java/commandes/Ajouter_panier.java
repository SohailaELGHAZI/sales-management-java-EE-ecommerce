package commandes;
import action.HibernateUtil;
import org.hibernate.HibernateException;


import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Commandes;
public class Ajouter_panier {
	//methode s'exécute lors on clique sur ajouter au panier 
	public Ajouter_panier(Commandes cmd) {
		super();
		
		  Session session=null;
		  Transaction tx=null;
		  try
		  {
			  
		    session =HibernateUtil.openSession();
		    session.beginTransaction();
		    session.save(cmd);
		    session.getTransaction().commit();
		   
		    
		    //session.flush();
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
}
}
