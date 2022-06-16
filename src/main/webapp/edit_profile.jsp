<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
   <%@ page import="user.Info_pro"%> 
<%@page import="java.util.List"%>      <%--Importing all the dependent classes--%>
<%@page import="java.util.Iterator"%>
<%@page import="models.Users"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Inscription</title>
    <link rel="stylesheet" href="css/style_edit.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>

<body>
    <header>
        <div class="header">
            <div class="logo">
                <img src="img/logo1.png">
            </div>

        </div>
    </header>
    <div class="center">
        <div class="nav">
            <ul>
                <li><a class="ho" href="acc.jsp">Accueil</a></li>

                <li><a class="ho" href="accuiel.jsp">Produits</a></li>

                <li><a class="ho" href="profile.jsp">profile</a></li>

                <li><a class="ho" href="panier.jsp">Panier</a></li>

            </ul>
        </div>
        <s:actionerror/>
<form action="save_mod" method="POST" enctype = "multipart/form-data">
<%Info_pro pro=new Info_pro();
List results=pro.afficher();
for (Iterator iterator = results.iterator(); iterator.hasNext();){
	Users pr = (Users) iterator.next(); 
%>
        <div class="produit">

            <!--     <div class="user">
                <img src="img/profil.jpeg">

            </div>-->
              
            <div class="avatar-upload">
                <div class="avatar-edit">
                    <input type='file' id="imageUpload" name="myFile" accept=".png, .jpg, .jpeg" />
                    <label for="imageUpload"></label>
                    
                </div>
                <div class="avatar-preview">
                    <div id="imagePreview" style="background-image: url('<%=pr.getImageUser() %>');">
                    </div>
                </div>
            </div>
            <div class="info">
                <div class="inp">

              
                    <label>Nom   </label> <input type="text" name="Nom" value=<%=pr.getNom() %>><br/>
                    <label>Prenom </label> <input type="text" name="prenom" value=<%=pr.getPrenom() %>><br/>
                    <label>Email </label> <input type="email" name="email" value=<%=pr.getLogin() %>><br/>
                   
                    <label>Mot de passe actuel </label> <input type="password" name="passAnc"><br/>
                    <label>Nouveau mot de passe </label><input type="password" name="passNv"><br/>
                </div>
                <div class="sumbit">
                    <div class="button">
                       <input type="submit" name="valider" value="Save" id="popUpYes" /> 
                     
                    </div>
                    </form>
                    
                        <div class="button1">
                            <a href="profile.jsp"> <button>Cancel</button></a>
                        </div>
                   
                    
                </div>
                
                </div>
            </div>
<%} %>


        

        <script src="js/script_edit.js"></script>
</body>

</html>