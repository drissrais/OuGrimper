<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Connexion</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<section class="row">
			<div class="col-lg-offset-3 col-lg-6" id="connexion">
				<form class="well">
					<legend>Accéder à votre compte</legend>
					<fieldset>
						<div class="form-group">
							<label for="email">Email : </label> <input id="email" type="email"
								class="form-control">
						</div>
						<div class="form-group">
							<label for="password">Mot de passe : </label> <input id="password"
								type="password" class="form-control">
						</div>
						<button class="btn btn-warning" type="submit">Créer un compte</button>
						<button class="btn btn-primary pull-right" type="submit">Suivant</button>
					</fieldset>
				</form>
			</div>
		</section>
	</div>
	<script type="text/javascript" src="../script.js"></script>
</body>
</html>