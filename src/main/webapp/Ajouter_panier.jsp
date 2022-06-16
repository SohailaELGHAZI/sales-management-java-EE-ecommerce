<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
</head>
<body>
<h1>Connection</h1>
<f:view>
<s:actionerror/>
   hello:<s:property value="#session.id1"/>
         hii:<s:property value="#session.name"/>
          hello:<s:property value="#session.id"/> 
<s:form action="conx" method="POST" validate="true">
<pre>
<s:textfield label="email     " name="login"></s:textfield>
<s:password label="password     " name="pass" ></s:password>
<s:submit value="valider" name="valider"></s:submit>
</s:form>
</pre>
</f:view>
</body>
</html>
