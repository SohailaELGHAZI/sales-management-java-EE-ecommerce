package commandes;
import action.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import org.hibernate.Query;
import models.Commandes;
import models.ArticlesStock;
public class passer_commande extends ActionSupport implements SessionAware {
	int qt;
	
	List result=null;
	List<Integer> codeCmd = new ArrayList<Integer>();
	private SessionMap<String,Object> sessionMap;  
	public void setSession(Map<String, Object> map) {  
	    sessionMap=(SessionMap)map;  
	   
	}
	
	public List passer(Commandes cmd){
		 ActionContext context =ActionContext.getContext();
		  Session session=null;
		  Transaction tx=null;
		  try
		  {
			  
		    session =HibernateUtil.openSession();
		    session.beginTransaction();
		    
		    Serializable res=session.save(cmd);
		    //codecmd=(Integer)res;
		    codeCmd.add((Integer)res);
		    
		    String hql = "FROM ArticlesStock s where s.codeArt="+context.getSession().get("idArt");
		    Query query = session.createQuery(hql);
		   List results = query.list();
		   for (Iterator iterator = results.iterator(); iterator.hasNext();){
		    	ArticlesStock art = (ArticlesStock) iterator.next(); 
		    qt=art.getQteArt();
		   }
		   qt=qt-cmd.getQteCmd();
		   String qryString = "update ArticlesStock s set s.qteArt='" + qt + "' where s.codeArt='" + context.getSession().get("idArt") + "'";
		    Query query1 = session.createQuery(qryString);
	        query1.executeUpdate();
		   
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
		  
		return codeCmd; 
             
	}
	
	public List commande_passe2() {
		ActionContext context = ActionContext.getContext();
		  Transaction tx=null;
		  Session  session=null;
		  List res=null;
		  List<Integer> cmds=((List<Integer>)context.getSession().get("codeCmds"));
		  for (int i = 0; i < cmds.size(); i++) {
		      System.out.println(cmds.get(i));

		  try
		  {
			  
			    session =HibernateUtil.openSession();
		    session.beginTransaction();
		  
		    session =HibernateUtil.openSession();
		    session.beginTransaction();
		   
		    String hql ="select t1.nomArt,t2.qteCmd,t1.prixArt,t1.image,t2.codeCmd,t1.codeArt FROM ArticlesPrix t1,Commandes t2 WHERE t1.codeArt=t2.articlesPrix and t2.codeCmd="+cmds.get(i);
			  
			 
			    Query query = session.createQuery(hql);
			   result = query.list();
			 if(res==null) {
				 res = query.list(); 
			 }else {
			  
			 
			   Collection collection =result;
			 res.addAll(collection);
			 }
			 System.out.println(res);
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
		  System.out.println(res);
		 return res;
		 
	}
	
	
	}


