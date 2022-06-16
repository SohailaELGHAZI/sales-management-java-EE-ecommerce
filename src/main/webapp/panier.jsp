<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
    <%@ page import="commandes.ListePan"%> 
<%@page import="java.util.List"%>      <%--Importing all the dependent classes--%>
<%@page import="java.util.Iterator"%>
<%@page import="models.Art_commandes"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Panier</title>
    <link rel="stylesheet" href="css/style_panier.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style>
        .icon-input-btn {
            display: inline-block;
            position: relative;
        }
        
        .icon-input-btn input[type="submit"] {
            padding-left: 2em;
            border: none;
            background-color: white;
        }
        
        .icon-input-btn .fa {
            display: inline-block;
            position: absolute;
            left: 0.65em;
            top: 30%;
            font-size:20px;
           
        }
    </style>
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

                <li><a class="ho" href="porfile.jsp">Profil</a></li>

                <li><a class="ho" href="panier">Panier</a></li>

            </ul>
        </div> 
        <div class="produit">
            <div class="liste">
            <% List results=null; %>
<%ListePan a=new ListePan();
results=a.verfier();
int som=0;
List<Object> result = (List<Object>) results;
Iterator itr = result.iterator();
  %>
                <table id="myTable">
                    <thead>
                        <tr>
                        <td>remove</td>
                        <td>image</td>
                        <td>product</td>
                        <td>price</td>
                        <td>Quantite</td>
                        <td>Total</td>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                    <%while(itr.hasNext()){
      			      Object[] obj = (Object[]) itr.next(); %>
      			      
                        <td>
                        <form action="remove_pan" method="POST">
                        <input type="hidden" value=<%=Integer.parseInt(String.valueOf(obj[4])) %> name="idcmd" /> 
                         <input type="hidden" value=<%=Integer.parseInt(String.valueOf(obj[5])) %> name="idart" /> 
                        <span class="icon-input-btn">
                        <i class="fa fa-times-circle"></i>
                        <input type="submit" value="">
                        </span>
                        </form>
                        
                        </td>
                        <td><img src=<%=String.valueOf(obj[3]) %>></td>
                        <td><%= String.valueOf(obj[0]) %></td>
                        <td><%=Integer.parseInt(String.valueOf(obj[2])) %> MAD</td>
                        <td><%=Integer.parseInt(String.valueOf(obj[1])) %></td>
                        <td><%=Integer.parseInt(String.valueOf(obj[2]))*Integer.parseInt(String.valueOf(obj[1])) %></td>
                    </tr>
                    <%som=som+Integer.parseInt(String.valueOf(obj[2]))*Integer.parseInt(String.valueOf(obj[1])); %>
                    <%} %>
                    </tbody>
                </table>
            </div>
            <div class="total">
<h3>Total de panier </h3>
<table>
    <tr>
        <td>Total intial</td><td><%=som %> MAD</td></tr>
      <tr>  <td>Livraison</td><td>free</td></tr>
       <tr><td><strong>Total</strong></td>
        <td><strong><%=som %> MAD</strong></td>
    </tr>
</table>
<!-- <button class="normal">Acheter les produits</button>  -->   
<form action="acheter_from_pan" method="POST">
       <div class="button">  
      <input  type="submit" class="normal" value="Acheter les produits" id="popUpYes" >
       </div>                
</form>
<div class="panim">
    <img src="img/Ecommerce campaign-cuate.png">
</div>
    
</div>
       
    </div>
    
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
    <script type="text/javascript" src="js/paging.js"></script>
    <script type="text/javascript">
        $(document).ready(function() {
            $('#myTable').paging({
                limit: 4
            });
        });
    </script>


</body>
</html>