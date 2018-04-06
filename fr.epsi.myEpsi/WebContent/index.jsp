<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Boutique de cafeti&egrave;re</title>
	<link rel="stylesheet" type="text/css" href="style.css" />
	<link href="https://fonts.googleapis.com/css?family=Oleo+Script|Poppins|Raleway" rel="stylesheet" />
</head>
<body>
	<div id="blurBackground"></div>
	<header>
		<h1>Coff'E'shop</h1>
		<h2><span>Bienvenu</span>e</h2>
	</header>
	<p id="textWelcome">Bonjour &agrave; vous,<br /><br />C'est un plaisir de vous accueillir ici. Notre site vous proposes une s&eacute;lection des meilleures cafeti&egrave;res de la terre.</p>
	<section id="buttons">	
		<button id="subscribe">Inscription</button>
		<button id="login">Connexion</button>
	</section>
	<div id="content">
		<img src="img/exit.png" alt="exit cross" onclick="closeContent()" />
		<h3></h3>
	</div>
	<script src="main.js"></script>
</body>
</html>