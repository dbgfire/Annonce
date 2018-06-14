<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cr�er</title>
<link rel="stylesheet" href="stylesheets/style.css">
<link href="https://fonts.googleapis.com/css?family=Crete+Round|Lato|Lobster" rel="stylesheet">
<link rel="icon" type="image/png" href="img/favicon.png">
</head>
<body>
<form method="POST" action="ConnectServlet">
 <label class="text" for="title">Titre</label><br>
<input class="text text-center"type="text" name="title" id="title"><br>
 <label class="text" for="price">Prix</label><br>
<input class="text text-center"type="text" name="price" id="price"><br>
 <label class="text" for="description">Description</label><br>
<input class="text text-center"type="text" name="description" id="description"><br>
<label for="status">Status de l'annonce</label><br />
       <select name="status" id="status">
           <option value="1">Public</option>
           <option value="2">Priv�</option>
           <option value="3">Archiv�</option>
          
       </select>
<input type="submit" >
</form>
</body>
</html>