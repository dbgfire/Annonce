<%@page import="fr.epsi.myEpsi.beans.Utilisateur"%>
<%@page import="fr.epsi.myEpsi.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acceuil</title>
</head>
<body>
<% Utilisateur utilisateur = (Utilisateur) session.getAttribute(Constantes.PARAM_UTILISATEUR); %>
Bonjour <%= utilisateur.getId() %>
</body>
</html>