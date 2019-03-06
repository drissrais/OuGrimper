<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Inscription</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<section class="row">
			<div class="col-lg-9">
				<s:form class="well form-horizontal" action="inscription">
					<input type="hidden" id="role" name="utilisateur.role" value="user">
					<div class="form-group">
						<legend>Créer votre compte</legend>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="civilite" class="col-lg-4 control-label">Civilité : </label>
							<div class="col-lg-8">
								<select id="civilite" name="utilisateur.civilite" class="form-control">
									<option>M.</option>
									<option>Mme.</option>
									<option>Mlle.</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="nom" class="col-lg-4 control-label">Nom : </label>
							<div class="col-lg-8">
								<input id="nom" type="text" class="form-control" name="utilisateur.nom">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="prenom" class="col-lg-4 control-label">Prénom : </label>
							<div class="col-lg-8">
								<input id="prenom" type="text" class="form-control" name="utilisateur.prenom">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="date" class="col-lg-4 control-label">Date de naissance : </label>
							<div class="col-lg-8">
								<input id="date" type="date" class="form-control" name="utilisateur.dateDeNaissance">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="pseudo" class="col-lg-4 control-label">Pseudo : </label>
							<div class="col-lg-8">
								<input id="pseudo" type="text" class="form-control" name="utilisateur.pseudo">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="email" class="col-lg-4 control-label">Email : </label>
							<div class="col-lg-8">
								<input id="email" type="email" class="form-control" name="utilisateur.email">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="password" class="col-lg-4 control-label">Mot de passe : </label>
							<div class="col-lg-8">
								<div class="input-group">
									<input id="password" type="password" name="utilisateur.motDePasse" class="form-control">
									<span class="fa fa-fw fa-eye input-group-addon toggle-password"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="passConfirm" class="col-lg-4 control-label">Confirmer mot de passe : </label>
							<div class="col-lg-8">
								<input id="passConfirm" type="password" class="form-control">
							</div>
						</div>
					</div>
					<div class="form-group">
						<button class="btn btn-primary pull-right" type="submit">Créer</button>
					</div>
				</s:form>
			</div>
		</section>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jsp/script.js"></script>
	<script type="text/javascript">
		$("body").on('click', '.toggle-password', function() {
			$(this).toggleClass("fa-eye fa-eye-slash");
			var input = $("#password");
			if (input.attr("type") === "password") {
				input.attr("type", "text");
			} else {
				input.attr("type", "password");
			}

		});
	</script>
</body>
</html>