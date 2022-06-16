package commandes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import models.ArticlesStock;
import models.Commandes;
import action.HibernateUtil;
public class passer_cmd_panier {
	int qt;
	List resultT;
	List<Integer> codeCmd = new ArrayList<Integer>();
	public List passer(){
		 ActionContext context =ActionContext.getContext();
		  Session session=null;
		  Transaction tx=null;
		
		  try
		  {
			  
		    session =HibernateUtil.openSession();
		    session.beginTransaction();
		    
		  System.out.print(context.getSession().get("id"));
		    String hql_t = "FROM Commandes c where c.etatCmd='panier' and c.users="+context.getSession().get("id");
		    Query queryT = session.createQuery(hql_t);
			   resultT = queryT.list();
			   session.getTransaction().commit();
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
			  
			   for (Iterator iteratorT = resultT.iterator(); iteratorT.hasNext();){
				   try
					  {
						 
				   session =HibernateUtil.openSession();
				    session.beginTransaction();
				   Commandes cm = (Commandes) iteratorT.next(); 
			      System.out.println(cm.getQteCmd());
		    String hql = "FROM ArticlesStock s where s.codeArt="+cm.getArticlesPrix().getCodeArt();
		    Query query = session.createQuery(hql);
		   List results = query.list();
		   for (Iterator iterator = results.iterator(); iterator.hasNext();){
		    	ArticlesStock art = (ArticlesStock) iterator.next(); 
		    qt=art.getQteArt();
		   }
		   qt=qt-cm.getQteCmd();
		   String qryString = "update ArticlesStock s set s.qteArt='" + qt + "' where s.codeArt='" + cm.getArticlesPrix().getCodeArt() + "'";
		    Query query1 = session.createQuery(qryString);
	        query1.executeUpdate();
	        String qryCmd = "update Commandes cm set cm.etatCmd='commander' where cm.codeCmd='" + cm.getCodeCmd() + "'";
		    Query query2 = session.createQuery(qryCmd);
	        query2.executeUpdate();
	        codeCmd.add(cm.getCodeCmd());
	        session.getTransaction().commit();
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
			  
			  
		  
		  return codeCmd;
	
            
	}
	
}
