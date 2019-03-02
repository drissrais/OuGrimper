<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Création de site</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<section class="row">
			<div class="col-lg-10">
				<form class="well form-horizontal" enctype="multipart/form-data" action="site_new" method="post">
					<div class="form-group">
						<legend>Nouveau Site</legend>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="nom" class="col-lg-3 control-label">Nom : </label>
							<div class="col-lg-9">
								<input id="nom" name="site.nom" type="text" class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="description" class="col-lg-3 control-label">Description
								: </label>
							<div class="col-lg-9">
								<textarea class="form-control" id="description" rows="4"
									name="site.description"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="region" class="col-lg-3 control-label">Région
								: </label>
							<div class="col-lg-9">
								<input id="region" name="site.region" type="text"
									class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="localite" class="col-lg-3 control-label">Localité
								: </label>
							<div class="col-lg-9">
								<textarea class="form-control" id="localite"
									name="site.localite" rows="4"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="pays" class="col-lg-3 control-label">Pays : </label>
							<div class="col-lg-9">
								<input id="pays" name="site.pays.nom" type="text"
									class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="ville" class="col-lg-3 control-label">Ville
								la plus proche : </label>
							<div class="col-lg-9">
								<input id="ville" name="site.ville.nom" type="text"
									class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="fileUpload" class="col-lg-3 control-label">Choisir
								photo (317 x 212) : </label>
							<div class="col-lg-9">
								<s:file id="fileUpload" name="fileUpload"
									label="Select a File to upload" size="40" requiredLabel="false"
									class="form-control-file" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="file2Upload" class="col-lg-3 control-label">Choisir
								photo (670 x 378) : </label>
							<div class="col-lg-9">
								<s:file id="file2Upload" name="file2Upload"
									label="Select a File to upload" size="40" requiredLabel="false"
									class="form-control-file" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<button class="btn btn-primary pull-right" type="submit">Soumettre</button>
					</div>
				</form>
			</div>
		</section>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jsp/script.js"></script>
</body>
</html>