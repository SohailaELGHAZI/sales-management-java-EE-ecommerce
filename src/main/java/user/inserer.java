package user;

import java.io.Serializable;


import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.Transaction;
import models.Users;
import action.HibernateUtil;

public class  inserer {
	public String username;
	public String prenom;
	public String email;
	public String password;
	 int iduser;

		
		public int insererUser(Users use){
		  Session session=null;
		  Transaction tx=null;
		  try
		  {
			  
		    session =HibernateUtil.openSession();
		    session.beginTransaction();
		    session.save(use);
		    session.getTransaction().commit();
		   
		    Serializable res= session.save(use);
		    iduser=(Integer)res;
		    
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
	
		return iduser;
	}

}
