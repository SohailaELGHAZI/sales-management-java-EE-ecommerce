<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="user.Info_pro"%> 
<%@page import="java.util.List"%>      <%--Importing all the dependent classes--%>
<%@page import="java.util.Iterator"%>
<%@page import="models.Users"%>
<!DOCTYPE html>
<html>
<head>
<head>
    <meta charset="ISO-8859-1">
    <title>Inscription</title>
    <link rel="stylesheet" href="css/style_profile.css">
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

                <li><a class="ho" href="Accuiel.jsp">Produits</a></li>

                <li><a class="ho" href="#">Profil</a></li>

                <li><a class="ho" href="panier.jsp">Panier</a></li>

            </ul>
        </div>
        <%Info_pro pro=new Info_pro();
List results=pro.afficher();
for (Iterator iterator = results.iterator(); iterator.hasNext();){
	Users pr = (Users) iterator.next(); 
%>
        <div class="produit">

            <div class="avatar-upload">
                <div class="avatar-edit">
                    <label for="imageUpload"></label>
                </div>
                <div class="avatar-preview">
                    <div id="imagePreview" style="background-image: url('<%=pr.getImageUser() %>');">
                    </div>
                </div>
            </div>

            <div class="info">
                <h3>Nom :</h3>
                <p><%=pr.getNom() %></p>
               <h3>Prenom :</h3>
               
                <p><%=pr.getPrenom() %></p>
                <h3>Email :</h3>
                <p><%=pr.getLogin() %></p>

              <%} %>

                <div class="button1">
                    <a href="pro"> <button>Edit profile</button></a>


                </div>



            </div>


</body>

</html>