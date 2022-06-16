package user;

import models.Users;


import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
public class LoginUser extends ActionSupport implements SessionAware{
private String nom;
private String prenom;
private String login;
private String pass;
private String id;


private SessionMap<String,Object> sessionMap;  
 


public void setSession(Map<String, Object> map) {  
    sessionMap=(SessionMap)map;  
}  
public String getId() {
	return id;
	
}


public void setId(String id) {
	this.id = id;
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


public String getLogin() {
	return login;
}


public void setLogin(String login) {
	this.login = login;
}


public String getPass() {
	return pass;
}


public void setPass(String pass) {
	this.pass = pass;
}
public String ajouter() {
	System.out.print("yess1"); 
	return "success";
}
//cette method appelé quand l'utilisateur veifaire l'inscription  
public String execute() {
	
	Users use = new Users();
	use.setNom( getNom());
	use.setPrenom(getPrenom());
	use.setPass(getPass().toString());
	use.setLogin(getLogin());
	use.setImageUser("img/pro1.png");
	inserer us = new inserer();
	int iduser=us.insererUser(use);
	if(iduser!=0) {
	sessionMap.put("id", iduser);
	sessionMap.put("name",getPrenom());
	sessionMap.put("password",getPass());
	return "success";
	}
	return "error";
}

public String connection()
{
	 
	test_conx t=new test_conx(getLogin(),getPass());
	Users us=t.verfier();
	if(us!=null) { 
		sessionMap.put("name",us.getPrenom());
		sessionMap.put("id", us.getCodeUser());
		sessionMap.put("password",us.getPass());
		
	return "success";
}
	else {
		this.addActionError("Invalid UserName and Password..");
		return "error";
	}
}







}
