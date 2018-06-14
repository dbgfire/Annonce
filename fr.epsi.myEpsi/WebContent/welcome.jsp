<%@page import="fr.epsi.myEpsi.beans.Utilisateur"%>
<%@page import="fr.epsi.myEpsi.beans.Annonce"%>
<%@page import="fr.epsi.myEpsi.Constantes"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.List" %>
<%@page import="javax.servlet.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Swag page</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>

<body>
	<% Utilisateur utilisateur = (Utilisateur) session.getAttribute(Constantes.PARAM_UTILISATEUR); 
	List<Annonce> attribut = (List<Annonce>)session.getAttribute(Constantes.PARAM_ANNONCE);  
	List<Annonce> all = (List<Annonce>)session.getAttribute(Constantes.PARAM_ANNONCE_ALL); 
	//System.out.println(all.get(0).getTitre()+" "+attribut.get(0).getTitre());
	//Annonce a =(Annonce)session.getAttribute(Constantes.PARAM_ANNONCE);
	//List<Annonce> annonce= (Annonce) session.getAttribute(Constantes.PARAM_ANNONCE);

	%>
	<header>
		<h1 >Bonjour <%=utilisateur.getNom() %> 	</h1>
		<input type="button" id="out" value="Se déconnecter"  />
	</header>
	
	<div id="textWelcome">
	<p>Bienvenue sur notre site de petites annonces :</p>
	Vos petites annonces:
	<input type="button" id="creer" value="Crée"  onclick="javascript:location.href='creer.jsp'"/>
	<br>
	Nombre de vos annonces: <%=attribut.size() %> Nombre d'annonces public: <%=all.size() %>
	
 <table border="1" cellpadding="40" cellspacing="1">
<%
     for(int i=0;i<attribut.size();i++)
     {  %>
               <tr>
                <td>
                     <%= attribut.get(i).getTitre() %>
                </td>
                <td>
                     <%= attribut.get(i).getPrix() %>
                </td>
              	<td>
       			<input type="button" id="del" value="Supprimé une annonce"  />
       			<input type="button" id="update" value="Modifier une annonce"  />
       			
            	</td>
               </tr>
          <%
     }
%>

<%
     for(int i=0;i<all.size();i++)
     {  %>
               <tr>
                <td>
                     <%= all.get(i).getTitre() %>
                </td>
                <td>
                     <%= all.get(i).getPrix() %>
                </td>
              	<td>
       			<input type="button" id="Achater" value="Acheter"  />
       			
       
            	</td>
               </tr>
          <%
     }
%>
     </table>
</div>
</body>
</html>