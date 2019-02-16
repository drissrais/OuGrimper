<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<link href="../style.css" rel="stylesheet" media="screen" type="text/css" title="main_css">
<title>Inscription</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<section class="row">
			<div class="col-lg-8">
				<form class="well form-horizontal">
					<div class="form-group">
						<legend>Créer votre compte</legend>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="civilite" class="col-lg-4 control-label">Civilité : </label>
							<div class="col-lg-8">
								<select id="civilite" class="form-control">
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
								<input id="nom" type="text" class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="prenom" class="col-lg-4 control-label">Prénom : </label>
							<div class="col-lg-8">
								<input id="prenom" type="text" class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="date" class="col-lg-4 control-label">Date de naissance : </label>
							<div class="col-lg-8">
								<input id="date" type="date" class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="pseudo" class="col-lg-4 control-label">Pseudo : </label>
							<div class="col-lg-8">
								<input id="pseudo" type="text" class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="email" class="col-lg-4 control-label">Email : </label>
							<div class="col-lg-8">
								<input id="email" type="email" class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="password" class="col-lg-4 control-label">Mot de passe : </label>
							<div class="col-lg-8">
								<input id="password" type="password" class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="password" class="col-lg-4 control-label">Confirmer mot de passe : </label>
							<div class="col-lg-8">
								<input id="password" type="password" class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="cotation" class="col-lg-4 control-label">Niveau actuel (Si vous êtes grimpeur) : </label>
							<div class="col-lg-8">
								<select id="cotation" class="form-control">
									<option value="" selected disabled hidden></option>
									<option>3a</option>
									<option>3b</option>
									<option>3c</option>
								</select>
							</div>
						</div>
					</div>
					<div class="form-group">
						<button class="btn btn-primary pull-right" type="submit">Créer</button>
					</div>
				</form>
			</div>
		</section>
	</div>
	<script type="text/javascript" src="../script.js"></script>
</body>
</html>