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
	        <form method="post" action="ConnectServlet">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="nom">Adresse email <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['email']}</span>
                <br />

                <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motdepasse']}</span>
                <br />

                <input type="submit" value="Connexion" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
        </form>
		<img src="img/exit.png" alt="exit cross" onclick="closeContent()" />
		<h3></h3>
	</div>
	<script src="main.js"></script>
</body>
</html>