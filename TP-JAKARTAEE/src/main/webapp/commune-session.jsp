<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Models.Client"%>
    <%@page import="Models.Commune"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
// Vérifiez si l'attribut "count" est présent dans la session
if(session.getAttribute("count") != null && ((Long) session.getAttribute("count")).longValue() == 0) {
    // Code pour la section où "count" est présent
    
    Client client = (Client)request.getAttribute("Commune_Session");
    
%>
    <h1><p>Vous etes = <%= client.getNom() + " " + client.getPrenom() %></p></h1>
    <p>Requete Numero = <%= session.getAttribute("count") %></p>
<%
} else {
    // Code pour la section où "commune" est présent
    Commune com = (Commune)session.getAttribute("commune");
    if(com != null) { // Vérifiez également si l'objet "commune" est présent pour éviter un NullPointerException
%>
         <h1><p>Vous etes = <%= session.getAttribute("nom") + " " + session.getAttribute("prenom") %></p></h1>
        <p>Requete Numero = <%= session.getAttribute("count") %></p>
        <p>Derniere commune saisie = <%= com.getCodePostael() + " " + com.getName() %></p>
<%
    }
}
%>

<br>
<br>
<form action="CommmuneSession" method="post">

 <table>
  <tr>
  <td> codePostal </td>
  </tr>
  <td> <input type="text" name="cp" /></td>
  <tr>
  <tr>
  <td> name</td>
  </tr>
  <td><input type="text" name="name" /></td>
  <tr>
  <td> &nbsp</td>
  <td><input type="submit"  /></td>
  </tr>
  </table>
 
</form>

</body>
</html>