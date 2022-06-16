package user;

import java.io.File;
import java.io.IOException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import models.Users;

public class Profile extends ActionSupport{
private String Nom;
private String prenom;
private String email;
private String passAnc;
private String passNv;	
private String tel;
private File myFile;
private String myFileContentType;
private String myFileFileName; 
private String destPath;

	
public File getMyFile() {
	return myFile;
}

public void setMyFile(File myFile) {
	this.myFile = myFile;
}

public String getMyFileContentType() {
	return myFileContentType;
}

public void setMyFileContentType(String myFileContentType) {
	this.myFileContentType = myFileContentType;
}

public String getMyFileFileName() {
	return myFileFileName;
}

public void setMyFileFileName(String myFileFileName) {
	this.myFileFileName = myFileFileName;
}

public String getDestPath() {
	return destPath;
}

public void setDestPath(String destPath) {
	this.destPath = destPath;
}

public String getTel() {
	return tel;
}

public void setTel(String tel) {
	this.tel = tel;
}

public String getNom() {
	return Nom;
}

public void setNom(String nom) {
	Nom = nom;
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
public String getPassAnc() {
	return passAnc;
}
public void setPassAnc(String passAnc) {
	this.passAnc = passAnc;
}
public String getPassNv() {
	return passNv;
}
public void setPassNv(String passNv) {
	this.passNv = passNv;
}

public String update() {
	ActionContext context = ActionContext.getContext();
	System.out.println("Username from session: " + context.getSession().get("password"));
	if(getPassAnc().equals(context.getSession().get("password"))) {
		Users use = new Users();
		use.setCodeUser((Integer)context.getSession().get("id"));
		use.setNom(getNom());
		use.setPrenom(getPrenom());
		use.setPass(getPassNv());
		use.setLogin(getEmail());
		if(getMyFile()!=null) {
		 //destPath = "C:\\Users\\hp\\eclipse-workspace\\projet_2B_pan\\src\\main\\webapp\\img_users";
			String destPath = ServletActionContext.getServletContext().getRealPath("/").concat("img_user/");
		  try {
		         System.out.println("Src File name: " + myFile);
		         System.out.println("Dst File name: " + myFileFileName);
		     	    	 
		         File destFile  = new File(destPath, "img"+context.getSession().get("id")+".png");
		         FileUtils.copyFile(myFile, destFile);
		  
		      } catch(IOException e) {
		         e.printStackTrace();
		      }
		  
		}
	  use.setImageUser("img_user/img"+context.getSession().get("id")+".png");
		Edit_profile us = new Edit_profile(use);
		return "success";
	}
	else {
		this.addActionError("Invalid Password..");
		return "error";
	}
	}
public String open_modfier() {
	return "success";
}
public String open_prof() {
	
	return "success";
}

}
