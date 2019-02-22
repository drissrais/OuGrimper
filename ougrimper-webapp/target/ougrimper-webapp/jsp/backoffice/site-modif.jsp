<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Modification de site</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<section class="row">
			<div class="col-lg-9">
				<form class="well form-horizontal">
					<div class="form-group">
						<legend>Modifier Site</legend>
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
							<label for="description" class="col-lg-4 control-label">Description : </label>
							<div class="col-lg-8">
								<textarea class="form-control" id="description" rows="4"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="civilite" class="col-lg-4 control-label">Région
								: </label>
							<div class="col-lg-8">
								<select id="civilite" class="form-control">
									<option>Région 1</option>
									<option>Région 2</option>
									<option>Région 3</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="localite" class="col-lg-4 control-label">Localité : </label>
							<div class="col-lg-8">
								<textarea class="form-control" id="localite" rows="4"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="civilite" class="col-lg-4 control-label">Pays
								: </label>
							<div class="col-lg-8">
								<select id="civilite" class="form-control">
									<option>Pays 1</option>
									<option>Pays 2</option>
									<option>Pays 3</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="civilite" class="col-lg-4 control-label">Ville
								la plus proche : </label>
							<div class="col-lg-8">
								<select id="civilite" class="form-control">
									<option>Ville 1</option>
									<option>Ville 2</option>
									<option>Ville 3</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="photo" class="col-lg-4 control-label">Choisir photo (317 x 212) : </label>
							<div class="col-lg-8">
								<input id="photo" type="file" class="form-control-file">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="plan" class="col-lg-4 control-label">Choisir photo (670 x 378) : </label>
							<div class="col-lg-8">
								<input id="plan" type="file" class="form-control-file">
							</div>
						</div>
					</div>
					<div class="form-group">
						<button class="btn btn-primary pull-right" type="submit">Enregistrer
							les modifications</button>
					</div>
				</form>
			</div>
		</section>
	</div>
	<script type="text/javascript" src="../script.js"></script>
</body>
</html>