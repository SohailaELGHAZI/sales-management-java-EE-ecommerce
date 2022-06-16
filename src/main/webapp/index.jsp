<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Inscription</title>
    <link rel="stylesheet" href="css/style.css">
</head>

 <div class="container">
        <div class="logo">
            <img src="img/logo1.png">
        </div>
        <div class="center">
            <!-- #CBB26A-->

            <div class="imag">
                <img src="img/Sign up-amico (2).png">

            </div>
            <div class="form">
                <h1>Inscription</h1>

 <form action="login" method="POST">               
<div class="inp">
 <input type="text" name="nom" placeholder="nom" required="" /><br/>
 <input type="text" name="prenom" placeholder="prenom" required="" /><br/>
 <input type="email" name="login" placeholder="email" required="" /><br/>
 <input type="password" name="pass" placeholder="password" required="" /><br/> 
</div>
                    <div class="button">
                        <input type="submit" name="valider" value="valider" id="popUpYes" />
                    </div>

                </form>
                <div class="button1">
                    <a href="connection.jsp"> <button>Connection</button></a>
                </div>
            </div>
        </div>
    </div>
</body>

</html>