package commandes;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Acheter  extends ActionSupport implements SessionAware{
	
	private String id;
	private String qte;
	private String idu;
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
	//methode s'exécute lors on clique sur acheter maintenant
public String acheter() {
		
		sessionMap.put("idArt", Integer.parseInt(getId()));
		 String conte = getQte();
	        String mots[] = conte.split(",");
		sessionMap.put("qteCmd", Integer.parseInt(mots[0]));
		return "success";
	}
}
