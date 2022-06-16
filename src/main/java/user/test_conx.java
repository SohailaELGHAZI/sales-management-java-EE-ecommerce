package user;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Users;
import action.HibernateUtil;
public class  test_conx{ 
	private String login;
	private String password;
	private   Users employee=null;
	public test_conx(String login,String password) {
		
		super();
		this.login=login;
		this.password=password;
	}
	//cette méthode pour vérfier l'existance des données forné par l'utilisateur dans la base de données 
	public Users verfier() {
		
		  Session session=null;
		  Transaction tx=null;
		  try
		  {
			  
		    session =HibernateUtil.openSession();
		    session.beginTransaction();
		    String hql = "FROM Users where login=:login AND pass=:password ";
		    Query query = session.createQuery(hql);
		    query.setParameter("login", login);
		    query.setParameter("password", password);
		    List results = query.list();
		   if(!results.isEmpty()) {
		    for (Iterator iterator = results.iterator(); iterator.hasNext();){
	             employee = (Users) iterator.next(); 
	            System.out.print("First Name: " + employee.getLogin()); 
	            System.out.print("  Last Name: " + employee.getNom()); 
	            System.out.println("  Salary: " + employee.getPass()); 
	         
	         }
		    return employee;
		   }
		  
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
		  return null;
		 
	}
}

