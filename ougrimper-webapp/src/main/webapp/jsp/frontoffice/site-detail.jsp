<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<link href="../style.css" rel="stylesheet" media="screen"
	type="text/css" title="main_css">
<title></title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<section class="row" id="recherche">
			<div class="col-lg-4">
				<select class="form-control">
					<option value="" selected disabled hidden>Pays</option>
				</select>
			</div>
			<div class="col-lg-4">
				<select class="form-control">
					<option value="" selected disabled hidden>Région</option>
				</select>
			</div>
			<div class="col-lg-4">
				<select class="form-control">
					<option value="" selected disabled hidden>Site</option>
				</select>
			</div>
		</section>
		<header class="page-header">
			<h1>Nom du site</h1>
		</header>
		<section></section>
		<div class="row">
			<section class="col-lg-8">
				<form action="" class="well well-lg well-sm">
					<h4>
						<span class="label label-lg label-default">Votre avis sur
							le site</span>
					</h4>
					<h4>Comment l'avez-vous trouvé ?</h4>
					<fieldset>
						<label for="textarea">Commencer la discussion...</label>
						<textarea id="textarea" class="form-control" rows="4"></textarea>
						<p class="help-block">Vous pouvez agrandir la fenêtre</p>
						<button class="btn btn-primary" type="submit">
							<span class="glyphicon glyphicon-ok-sign"> Envoyer</span>
						</button>
					</fieldset>
				</form>
			</section>
			<section class="col-sm-4">
				<div class="row">
					<div class="col-lg-12">
						<address class="thumbnail">
							<p>
								<a>Identifiez-vous</a> pour pouvoir
								commencer des discussions... ou <a>inscrivez-vous</a>
							</p>
						</address>
					</div>
					<button class="btn btn-warning col-lg-offset-3 col-lg-6">VOIR LES DISCUSSIONS</button>
				</div>
			</section>
		</div>
	</div>
	<script type="text/javascript" src="../script.js"></script>
</body>
</html>