<%@page import="Models.Commune"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>commune</title>
</head>
<body>
<h1>Commune</h1>
<p>Ma commune</p>
<% Commune commune = (Commune)request.getAttribute("commune"); %>
<p>ID = <%=commune.getCodePostael() %></p>
<p>Name = <%=commune.getName() %></p>
</body>
</html>