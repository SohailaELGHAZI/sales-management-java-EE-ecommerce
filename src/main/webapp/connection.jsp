<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
   
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Inscription</title>
    <link rel="stylesheet" href="css/style_conx.css">
</head>
<body>
<div class="container">
        <div class="logo">
            <img src="img/logo1.png">
        </div>
        <div class="center">
            <!-- #CBB26A-->

            <div class="imag">
                <img src="img/Login-amico.png">

            </div>
            <div class="form">
                <h1>Connection</h1>
                <s:actionerror/>                
                <form action="conx" method="POST">
 <div class="inp">
  <input type="email" name="login" placeholder="email" required="" /><br/>
                        <input type="password" name="pass" placeholder="password" required="" /><br/>

                    </div>
                    <div class="parameter">
                        <label id="memo" for="rememberMe"> <input type="checkbox" name="memory" id="rememberMe">memoriser mot de passe</label>
                        
                    </div>
                    
                    <div class="button">
                        <input type="submit" name="valider" value="valider" id="popUpYes" onclick="lsRememberMe()"/>
                    </div>

                </form>
                <div class="button1">
                    <a href="index.jsp"> <button>s'inscrire</button></a>
                </div>
            </div>
        </div>
    </div>
    
    <script>
        const rmCheck = document.getElementById("rememberMe"),
            emailInput = document.getElementById("login");
        passInput = document.getElementById("pass");
        if (localStorage.checkbox && localStorage.checkbox !== "") {
            rmCheck.setAttribute("checked", "checked");
            emailInput.value = localStorage.username;
            passInput.value = localStorage.password;
        } else {
            rmCheck.removeAttribute("checked");
            emailInput.value = "";
            passInput.value = "";
        }

        function lsRememberMe() {
            if (rmCheck.checked && emailInput.value !== "" && passInput.value !== "") {
                localStorage.username = emailInput.value;
                localStorage.password = passInput.value;
                localStorage.checkbox = rmCheck.value;
            } else {
                localStorage.username = "";
                localStorage.checkbox = "";
            }
        }
    </script>
</body>
</html>
