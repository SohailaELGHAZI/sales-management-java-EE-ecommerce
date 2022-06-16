package user;

import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Users;
import action.HibernateUtil;
public class  Edit_profile {
	public String username;
	public String prenom;
	public String email;
	public String password;
	 
	public Edit_profile(Users use) {
		super();
		
		  Session session=null;
		  Transaction tx=null;
		  try
		  {
			  
		    session =HibernateUtil.openSession();
		    session.beginTransaction();
		    session.update(use);
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
