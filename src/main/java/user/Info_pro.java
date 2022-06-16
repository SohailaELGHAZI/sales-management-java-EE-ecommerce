package user;
import action.HibernateUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;


import models.Users;
public class Info_pro {
	List results=null;
	
	
	public List afficher() {
		ActionContext context = ActionContext.getContext();
		  Session session=null;
		  Transaction tx=null;
		  try
		  {
			  
		    session =HibernateUtil.openSession();
		    session.beginTransaction();
		    String hql = "FROM Users u where u.codeUser="+(Integer)context.getSession().get("id");
			  
			 
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

