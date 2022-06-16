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
    <link rel="stylesheet" href="css/style_checkout.css">
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
            <div class="title">
                <h1>Payment </h1>
            </div>
        </div>

    </header>
    <div class="center">
        <div class="nav">
            <ul>
                <li><a class="ho" href="#">Accueil</a></li>

                <li><a class="ho" href="#">Produits</a></li>

                <li><a class="ho" href="#">profile</a></li>

                <li><a class="ho" href="#">Paniers</a></li>

            </ul>
        </div>
         
        <div class="half">
            <div class="list">
             <form action="payer" method="post">
                <h4>Informations de contact</h4>
                <div class="full-name">
                
                    <div class="input-group">
                    <%Info_pro pro=new Info_pro();
List results=pro.afficher();
for (Iterator iterator = results.iterator(); iterator.hasNext();){
	Users pr = (Users) iterator.next(); 
%>
                  
                        <input required="" type="text" name="prenom" autocomplete="off" class="input" value=<%=pr.getPrenom() %>>
                        <label class="user-label">Prenom</label>
                    </div>

                    <div class="input-group2">
                        <input required="" type="text" name="nom" autocomplete="off" class="input" value=<%=pr.getNom() %>>
                        <label class="user-label">Nom</label>
                    </div>
                </div>
                <br/>
                <div class="input-group3">
                    <input required="" type="text" name="email" autocomplete="off" class="input" value=<%=pr.getLogin() %>>
                    <label class="user-label">E-mail</label>
                </div>
                <%} %>
                <br/>
                <div class="input-group3">
                    <input required="" type="text" name="tel" autocomplete="off" class="input">
                    <label class="user-label">Telephone</label>
                </div>
                <h4>Adresse de livraison</h4>
                <div class="input-group3">
                    <input required="" type="text" name="adrs" autocomplete="off" class="input">
                    <label class="user-label">Adresse</label>
                </div>
                <br/>
                <div class="input-group3">
                    <input required="" type="text" name="pay" autocomplete="off" class="input" list="country-list">

                    <label class="user-label">Pays</label>
                    <datalist id="country-list">
                    <option value="India"></option>
                    <option value="USA"></option>
                    <option value="Morroco"></option>
                    <option value="Japan"></option>
                    <option value="Egypt"></option>
                </datalist>

                </div>
                <br/>
                <div class="full-name">
                    <div class="input-group">
                        <input required="" type="text" name="ville" autocomplete="off" class="input">
                        <label class="user-label">ville</label>
                    </div>
                    <div class="input-group2">
                        <input required="" type="text" name="code_postal" autocomplete="off" class="input">
                        <label class="user-label">code postal</label>
                    </div>
                </div>
            </div>
            <div class="card">
                <h4>Informations sur la carte </h4>
                <div class="input-group5">
                    <input required="" type="text" name="num_carte" autocomplete="off" class="input">
                    <label class="user-label">Numero de carte</label>
                </div>
                <br/>
                <p>Date d'experation</p>
                <div class="date">
                    <div class="input-group7">
                        <input required="" type="text" name="moisExp" autocomplete="off" class="input" list="mois">
                        <datalist id="mois">
                            <option value=" janvier"></option>
                            <option value="fevrier"></option>
                            <option value="mars"></option>
                            <option value="avril"></option>
                            <option value="mai"></option>
                            <option value="juin"></option>
                            <option value="juillet"></option>
                            <option value="aout"></option>
                            <option value="septembre"></option>
                            <option value="octobre"></option>
                            <option value="novembre"></option>
                            <option value="decembre"></option>
                        </datalist>
                        <label class="user-label">Mois</label>
                    </div>
                    <div class="input-group8">
                        <input required="" type="text" name="annExp" autocomplete="off" class="input" list="annee">
                        <label class="user-label">Annee</label>
                        <datalist id="annee">
                            <option value="2022"></option>
                            <option value="2023"></option>
                            <option value="2024"></option>
                            <option value="2025"></option>
                            <option value="2026"></option>
                            <option value="2027"></option>
                            <option value="2028"></option>
                            <option value="2029"></option>
                            <option value="2030"></option>
                            <option value="2031"></option>
                            <option value="2032"></option>
                        </datalist>
                    </div>
                </div>
                <br>
                <div class="input-group5">
                    <input required="" type="text" name="codeSec" autocomplete="off" class="input">
                    <label class="user-label">Code de securite</label>
                </div>
                <div class="button1">
                   <input type="submit" value="Payer" id="popUpYes"/>

                </div>
                <div class="icons">
                    <img src="img/credit carte.png">

                </div>
                
            </div>
            </form>
        </div>
    </div>



</body>

</html>