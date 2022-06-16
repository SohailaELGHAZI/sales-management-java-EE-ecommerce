<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Random"%>
<%@ page import="commandes.passer_commande"%> 
<%@page import="java.util.List"%>      <%--Importing all the dependent classes--%>
<%@page import="java.util.Iterator"%>
<%@page import="models.Commandes"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Facture</title>


    <link rel="stylesheet" href="css/style_fac.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>

<body>


    <div id="tblCustomers">

        <div class="logo">
            <h1>DIOR</h1>
        </div>
        <div class="center">
            <h1>Facture</h1>
            <div class="produit">
                <div class="info">
                    <p><s:property value="#session.nomPay"/> <s:property value="#session.prenomPay"/></p>
                    <p><s:property value="#session.adrsPay"/></p>
                    <p><s:property value="#session.code_postalPay"/>,<s:property value="#session.villePay"/></p>
                    <p><s:property value="#session.payePay"/></p>
                    <p><s:property value="#session.telPay"/><br/></p>
                </div>
                <div class="info2">
                
                    <p>N de Facture :DR20220615</p>
                    <%Date date = Calendar.getInstance().getTime();%>
                    <p><%=date %></p>
                    <p>
                    <s:property value="#session.num_cartePay"/>
                    </p>
                </div>
            </div>

            <div class="tab">
                <h3>Les informations de la commande effectuee</h3>
                <table>
                 <div id=" tab1">
                    <tr class="table-hover table-bordered table-striped ">

                        <th style=" border: 1px solid #DDDDDD">Code de produit </th>
                        <th style=" border: 1px solid #DDDDDD">Nom de produit </th>
                        <th style=" border: 1px solid #DDDDDD">Prix de produit </th>
                        <th style=" border: 1px solid #DDDDDD">Quantite </th>
                        <th style=" border: 1px solid #DDDDDD">Total </th>
                    </tr>
<%passer_commande cm=new passer_commande();
List results=cm.commande_passe2();
List<Object> result = (List<Object>) results;
Iterator itr = result.iterator();
int som=0;
  %>
  <%while(itr.hasNext()){
      			      Object[] obj = (Object[]) itr.next(); %>
                    <tr class="table-hover table-bordered table-striped ">
                        <td style=" border: 1px solid #DDDDDD"><%=Integer.parseInt(String.valueOf(obj[5])) %></td>
                        <td style=" border: 1px solid #DDDDDD"><%= String.valueOf(obj[0]) %></td>
                        <td style=" border: 1px solid #DDDDDD"><%=Integer.parseInt(String.valueOf(obj[2])) %> DH</td>
                        <td style=" border: 1px solid #DDDDDD"><%=Integer.parseInt(String.valueOf(obj[1])) %></td>
                        <td style=" border: 1px solid #DDDDDD"><%=Integer.parseInt(String.valueOf(obj[2]))*Integer.parseInt(String.valueOf(obj[1])) %>DH</td>
                        
                    </tr>
                     <%som=som+Integer.parseInt(String.valueOf(obj[2]))*Integer.parseInt(String.valueOf(obj[1])); %>
                   <%} %>
               
                </div>
                <tr id="tab2">
                        <td class="t"> </td>
                        <td class="t"></td>
                        <td></td>
                            <td style=" border: 1px solid #DDDDDD">Total</td>
                            <td style=" border: 1px solid #DDDDDD"><%=som %> DH</td>
                        </tr>
                    </table>
                </div>
            </div>
    </div>
    <div class="sumb">
        <div class="bn1">
            <span class="icon-input-btn">
                <i class="fa fa-home"></i> 
               
                <a href="Accuiel.jsp">  Accueil </a>     
        </div>

        <div class="bn">
            <button class="download-button" id="btnExport">
             <div class="docs">
            <svg class="css-i6dzq1" stroke-linejoin="round" stroke-linecap="round" fill="none" stroke-width="2" stroke="currentColor" height="20" width="20" viewBox="0 0 24 24"><path d="M14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8z"></path><polyline points="14 2 14 8 20 8"></polyline><line y2="13" x2="8" y1="13" x1="16"></line><line y2="17" x2="8" y1="17" x1="16"></line><polyline points="10 9 9 9 8 9"></polyline></svg> Telecharger PDF</div>
        <div class="download">
          <svg class="css-i6dzq1" stroke-linejoin="round" stroke-linecap="round" fill="none" stroke-width="2" stroke="currentColor" height="24" width="24" viewBox="0 0 24 24"><path d="M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-4"></path><polyline points="7 10 12 15 17 10"></polyline><line y2="3" x2="12" y1="15" x1="12"></line></svg>
        </div>
      </button>
        </div>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>
    <script type="text/javascript">
        $("body").on("click", "#btnExport", function() {
            html2canvas($('#tblCustomers')[0], {
                onrendered: function(canvas) {
                    var data = canvas.toDataURL();
                    var docDefinition = {
                        content: [{
                            image: data,
                            width: 500
                        }]
                    };
                    pdfMake.createPdf(docDefinition).download("Facture.pdf");
                }
            });
        });
    </script>
</body>
</html>







