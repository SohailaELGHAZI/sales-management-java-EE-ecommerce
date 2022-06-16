package commandes;

import java.util.Map;

import java.util.Calendar;
import java.util.Date;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import models.ArticlesPrix;
import models.Commandes;
import models.Users;
import action.HibernateUtil;
public class panier extends ActionSupport implements SessionAware {
	private String id;
	private String qte;
	private String idu;
	private String idcmd;
	
	public String getIdu() {
		return idu;
	}
	public void setIdu(String idu) {
		this.idu = idu;
	}
	public int iduser;
	private String pan;
	private SessionMap<String,Object> sessionMap;  
	public void setSession(Map<String, Object> map) {  
	    sessionMap=(SessionMap)map;  
	}  
	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	
	public String getIdcmd() {
		return idcmd;
	}
	public void setIdcmd(String idcmd) {
		this.idcmd = idcmd;
	}
	public String getQte() {
		return qte;
	}

	public void setQte(String qte) {
		this.qte = qte;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
//ajouter au panier c'est a dire dans table Commandes avec etatCmd=panier	
	public String ajouter() {
		iduser=(Integer)sessionMap.get("id"); 
		Date date = Calendar.getInstance().getTime();
		Commandes cmd= new Commandes();
		cmd.setEtatCmd("panier");
		final String SEPARATEUR = ", ";
        String conte = getQte();
 System.out.println("quant"+conte);
        String mots[] = conte.split(SEPARATEUR);
		cmd.setQteCmd(Integer.parseInt(mots[0]));
		cmd.setDateCmd(date);
		Users u= new Users();
		ArticlesPrix art=new ArticlesPrix();
		u.setCodeUser(iduser);
		art.setCodeArt(Integer.parseInt(getId()));
		System.out.print(getId());
		cmd.setUsers(u);
		cmd.setArticlesPrix(art);
		Ajouter_panier ajt_pan=new Ajouter_panier(cmd);
		sessionMap.put("id", iduser);
		return "success";
	}
	
	
	//acheter un produit	
public String acheter() {
		sessionMap.put("idArt", Integer.parseInt(getId()));
		 String conte = getQte();
		 System.out.println(conte);
	        String mots[] = conte.split(", ");
	        System.out.println(Integer.parseInt(mots[1]));
		sessionMap.put("qteCmd", Integer.parseInt(mots[1]));
		sessionMap.put("nbr_ach","acheter1");
		return "success";
	}
//Acheter du panier
public String acheter_panier() {
	sessionMap.put("nbr_ach","acheter_pan");
	return "success";
	
}
	public String panier_o()
	{
		return "success";
	}
	public String acc_op()
	{
		return "success";	
	}
	//Supprimer les produits du panier
	public String remove_pan()
	{
		    Session session=null;
			  Transaction tx=null;
			  try
			  {
				  
			    session =HibernateUtil.openSession();
			    session.beginTransaction();
			    String qryString = "delete Commandes c where c.codeCmd='" + getIdcmd() + "'";
			    Query query = session.createQuery(qryString);
		        query.executeUpdate();
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
		return "success";	
	}
	
	
} 
