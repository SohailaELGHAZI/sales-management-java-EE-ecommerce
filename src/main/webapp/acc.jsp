<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Inscription</title>
    <link rel="stylesheet" href="css/style_acc1.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">
</head>

<body>
    <header>
        <div class="header">
            <div class="logo">
                <img src="img/logo1.png">
            </div>
            <div class="logout" id="popUpOut">
                <span class="glyphicon glyphicon-log-out"></span> <input type="submit" name="Deconnection" value="Deconnection" id="popUpOut1" />
            </div>

        </div>
    </header>
    <div class="center">
        <div class="nav">
            <ul>
                <li><a class="ho" href="#">Accueil</a></li>

                <li><a class="ho" href="acc">Produits</a></li>

                <li><a class="ho" href="profile">Profil</a></li>

                <li><a class="ho" href="panier">Panier</a></li>
                

            </ul>
        </div>
   <div class="nom">
       <h3> Bienvenue <s:property value="#session.name"/></h3>
   </div>
 <div class="fat">
        <div class="slider">
            <span style="--i:1;"><img src="dior_i/img1.png" alt=""></span>
            <span style="--i:2;"><img src="dior_i/img2.png" alt=""></span>
            <span style="--i:3;"><img src="dior_i/img3.png" alt=""></span>
            <span style="--i:4;"><img src="dior_i/img4.png"  alt=""></span>
            <span style="--i:5;"><img src="dior_i/img5.png" alt=""></span>
            <span style="--i:6;"><img src="dior_i/img6.png"  alt=""></span>
            <span style="--i:7;"><img src="dior_i/img7.png"  alt=""></span>
            <span style="--i:8;"><img src="dior_i/img8.png"  alt=""></span>
        </div>
        </div>
    </div>
        
    </body>

    </html>       