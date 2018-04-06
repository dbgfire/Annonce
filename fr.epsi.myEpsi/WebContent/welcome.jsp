<%@page import="fr.epsi.myEpsi.beans.Utilisateur"%>
<%@page import="fr.epsi.myEpsi.beans.Annonce"%>
<%@page import="fr.epsi.myEpsi.Constantes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Swag page</title>
</head>
<body>
	<% Utilisateur utilisateur = (Utilisateur) session.getAttribute(Constantes.PARAM_UTILISATEUR); %>
	
	<h1>Bonjour <%=utilisateur.getNom() %> 	</h1>
	<p>Bienvenue sur notre site de petites annonces :</p>
 <table border="1" cellpadding="40" cellspacing="1">
<%
     for(int i=1;i<=10;i++)
     {
          %>
               <tr>
          <%
          for(int j=1;j<=5;j++)
          {
          %>
                <td>
                     <%  %>
                </td>
          <%
          }
          %>
               </tr>
          <%
     }
%>
     </table>
	

</body>
</html>