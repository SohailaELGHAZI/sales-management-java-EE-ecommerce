package commandes;

import java.util.Iterator;


import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import action.HibernateUtil;
public class ListePan extends ActionSupport implements SessionAware  {
	List results=null;
	int iduser;
	private SessionMap<String,Object> sessionMap;  
	public void setSession(Map<String, Object> map) {  
	    sessionMap=(SessionMap)map;  
	   
	}  
	//Pour récupérer les articles qui ont été ajoutés au panier
	public List verfier() {
		ActionContext context = ActionContext.getContext();
		System.out.println("Username from session: " + context.getSession().get("name"));
		iduser=(Integer) context.getSession().get("id");
		System.out.println("Username from session: " + iduser);
		  Transaction tx=null;
		  Session  session=null;
		  try
		  {
			  
			    session =HibernateUtil.openSession();
		    session.beginTransaction();
		  
		    String hql ="select t1.nomArt,t2.qteCmd,t1.prixArt,t1.image,t2.codeCmd,t1.codeArt FROM ArticlesPrix t1,Commandes t2 WHERE t1.codeArt=t2.articlesPrix and t2.etatCmd='panier'and t2.users="+iduser;
		    Query query = session.createQuery(hql);
		    results = query.list();
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
		 return results;
		 
	}
	
}
