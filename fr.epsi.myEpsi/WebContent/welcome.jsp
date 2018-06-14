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
<title>Bienvenue</title>
<link rel="stylesheet" href="stylesheets/style.css">
<link href="https://fonts.googleapis.com/css?family=Crete+Round|Lato|Lobster" rel="stylesheet">
<link rel="icon" type="image/png" href="img/favicon.png">
</head>

<body>
	<% Utilisateur utilisateur = (Utilisateur) session.getAttribute(Constantes.PARAM_UTILISATEUR); 
	List<Annonce> attribut = (List<Annonce>)session.getAttribute(Constantes.PARAM_ANNONCE);  
	List<Annonce> all = (List<Annonce>)session.getAttribute(Constantes.PARAM_ANNONCE_ALL); 
	//System.out.println(all.get(0).getTitre()+" "+attribut.get(0).getTitre());
	//Annonce a =(Annonce)session.getAttribute(Constantes.PARAM_ANNONCE);
	//List<Annonce> annonce= (Annonce) session.getAttribute(Constantes.PARAM_ANNONCE);

	%>
	<script>
	function out(){
		<%
		session.setAttribute(Constantes.PARAM_ANNONCE,"a");
		session.setAttribute(Constantes.PARAM_UTILISATEUR,"u");%>
		location.href='index.html'
	}
	
	</script>
	<header>
		<h1 >Bonjour <%=utilisateur.getNom() %> 	</h1>
		<input type="button" id="out" value="Se d�connecter" onclick="out()" />
	</header>
	
	<div id="textWelcome">
	<p>Bienvenue sur notre site de petites annonces :</p>
	Vos petites annonces:
	<input type="button" id="creer" value="Cr�e"  onclick="javascript:location.href='creer.jsp'"/>
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

       			<input type="button" id="update" value="Modifier ou supprimer une annonce "    onclick="javascript:location.href='/fr.epsi.myEpsi/update_annonce?id=<%=attribut.get(i).getId()%>'"/>
       			
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