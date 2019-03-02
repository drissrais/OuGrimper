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
				<form class="well" action="login">
					<legend>Accéder à votre compte</legend>
					<fieldset>
						<div class="form-group">
							<label for="email">Email : </label> <input id="email" type="email" name="email"
								class="form-control">
						</div>
						<div class="form-group">
							<label for="password">Mot de passe : </label> <input id="password"
								type="password" name="password" class="form-control">
						</div>
						<s:a class="btn btn-warning" type="submit" action="inscription">Créer un compte</s:a>
						<button class="btn btn-primary pull-right" type="submit">Suivant</button>
					</fieldset>
				</form>
			</div>
		</section>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jsp/script.js"></script>
</body>
</html>