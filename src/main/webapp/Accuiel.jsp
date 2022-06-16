<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<%@ page import="Articles.ListeArt"%> 
<%@page import="java.util.List"%>      <%--Importing all the dependent classes--%>
<%@page import="java.util.Iterator"%>
<%@page import="models.Art_commandes"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Inscription</title>
       <link rel="stylesheet" href="css/style_acc.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Sofia">



    <script src="https://www.kryogenix.org/code/browser/sorttable/sorttable.js"></script>
</head>
<body>
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
                <li><a class="ho" href="acc.jsp">Accueil</a></li>

                <li><a class="ho" href="#">Produits</a></li>

                <li><a class="ho" href="profile">Profil</a></li>

                <li>
            <a class="ho" href="panier">Panier</a>
                </li>

            </ul>
        </div>
          <div class="produit">
         <h1>Listes des Produits</h1>
            <div style="max-width:700px;margin:auto">
                <div class="input-icons">
                    <i class="fa fa-search icon"></i>
                    <input id="myInput" class="input-field" type="text" name="" value="" onkeyup="myFunction()" placeholder="Search for product.." />
                </div>
            </div>
 <form action="ajt_pan" method="POST">   
<% List results=null; %>
<%ListeArt a=new ListeArt();
results=a.verfier();
  %>

   <table id="myTable" class="table sortable table-hover table-bordered table-striped ">
   <tr>
   
  <th>Code de produit </th>
  <th>Nom de produit </th>
  <th>Prix de produit </th>
  <th>Quantité </th>
  <th>Ajouter au Panier </th>
   </tr>
   
   <tr>
    
   <%for (Iterator iterator = results.iterator(); iterator.hasNext();){ 
	   Art_commandes art = (Art_commandes) iterator.next(); %>
  <td><%=art.getCodeArt()  %></td>
  <td>
   <div class="products-desc">

                            <div class="product" data-name=<%=art.getCodeArt()  %>>
  <%=art.getNomArt()  %>
  </div>
    </div>
    </td>
  <td><%=art.getPrixArt() +"Dh" %></td>
  <td><%=art.getQteArt()  %></td>
    <td>
    <div class="products-container">

                            <div class="product" data-name=<%=art.getCodeArt()  %>>
                                <span class="glyphicon glyphicon-shopping-cart"></span>
                          
                            </div>
                        </div>
    </td>
  </tr>
 
  <%} %> 
   </table>
 <% List results1=null; %>
<%ListeArt a1=new ListeArt();
results1=a1.verfier();
  %> 
  
 <div class="products-preview">
<%for (Iterator iterator1 = results1.iterator(); iterator1.hasNext();){ 
	   Art_commandes art1 = (Art_commandes) iterator1.next(); 
	%>
        <div class="preview" data-target=<%=art1.getCodeArt()  %>>
             <div class="photo">
                            <img src=<%=art1.getImage()  %>>
                        </div>
            <i class="fa fa-times"></i>
             
            <h3><%=art1.getNomArt()  %></h3>
            
            <div class="price"><%=art1.getPrixArt()  %> MAD</div>
            <div class="qte">
                <h4>Quantite: </h4>

                <div class="num-block skin-2">
                    <div class="num-in">

                        <span class="minus dis"></span>
                        <input type="text" name="qte" class="in-num" value="1" readonly="">
                        <span class="plus"></span>
                    </div>
                </div>
            </div>
            <div class="buttons">
           
                      <s:submit action="acht"  name="Acheter" id="buy" value="Acheter maintenant"></s:submit>
            
               <div class="tt"></div>
             <input type="submit" name="Ajouter" id="cart" value="Ajouter au panier" /> 
              
            </div>
           
            </div>
              <%} %> 
<input type="hidden" id="id" name="id" /> 
            
</div>
 <div class="products-preview-desc">
<%for (Iterator iterator2 = results1.iterator(); iterator2.hasNext();){ 
	   Art_commandes art2 = (Art_commandes) iterator2.next(); 
	%>
       
                    <div class="preview" data-target=<%=art2.getCodeArt()  %>>
                        <i class="fa fa-times"></i>
                        <div class="photo">
                            <img src=<%=art2.getImage() %>>
                        </div>

                        <h3><%=art2.getNomArt() %></h3>
                        <p><%=art2.getDescArt() %></p>



                    </div>
                     <%} %>
                </div>
                
 </form>
 

        <script src="js/script.js"></script>
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
    
     <script type="text/javascript">
    function myFunction() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("myInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("myTable");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[1];
        if (td) {
            txtValue = td.textContent || td.innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}
</script>   
        
</body>

</html>