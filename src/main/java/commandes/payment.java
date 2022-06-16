package commandes;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import models.ArticlesPrix;
import models.Commandes;
import models.Users;
public class payment extends ActionSupport implements SessionAware {
	private String nom;
	private String prenom;
	private String email;
	private String adrs;
	private String pay;	
	private String tel;
	private String ville;	
	private String code_postal;
	private String num_carte;
	
	private SessionMap<String,Object> sessionMap;  
	public void setSession(Map<String, Object> map) {  
	    sessionMap=(SessionMap)map;  
	}  	
	
	
public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdrs() {
		return adrs;
	}
public void setAdrs(String adrs) {
		this.adrs = adrs;
	}

	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getNum_carte() {
		return num_carte;
	}
	public void setNum_carte(String num_carte) {
		this.num_carte = num_carte;
	}




public String payer() {
	ActionContext context = ActionContext.getContext();
	sessionMap.put("nomPay", getNom());
	sessionMap.put("prenomPay", getPrenom());
	sessionMap.put("emailPay",getEmail());
	sessionMap.put("telPay", getTel());
	sessionMap.put("adrsPay", getAdrs());
	sessionMap.put("payePay", getPay());
	sessionMap.put("villePay", getVille());
	sessionMap.put("code_postalPay", getCode_postal());
	sessionMap.put("num_cartePay", getNum_carte());
if(context.getSession().get("nbr_ach")=="acheter1")	{
	Date date = Calendar.getInstance().getTime();
Commandes cmd=new Commandes();
Users use = new Users();
use.setCodeUser((Integer)context.getSession().get("id"));
cmd.setUsers(use);
ArticlesPrix art=new ArticlesPrix();
art.setCodeArt((Integer)context.getSession().get("idArt"));
cmd.setArticlesPrix(art);
cmd.setQteCmd((Integer)context.getSession().get("qteCmd"));
cmd.setEtatCmd("commander");
cmd.setDateCmd(date);
passer_commande pass=new passer_commande();
List codeCmds=pass.passer(cmd);
System.out.print("testt"+codeCmds);
sessionMap.put("codeCmds", codeCmds);
}
if(context.getSession().get("nbr_ach")=="acheter_pan") {
	passer_cmd_panier cmdPan=new passer_cmd_panier();
	List codeCmds=cmdPan.passer();
	sessionMap.put("codeCmds", codeCmds);
}
	return "success";
}
	
}
