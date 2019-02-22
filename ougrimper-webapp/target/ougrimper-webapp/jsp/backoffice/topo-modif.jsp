<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Modification de topo</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<section class="row">
			<div class="col-lg-9">
				<form class="well form-horizontal">
					<div class="form-group">
						<legend>Modifier Topo</legend>
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
							<label for="owner" class="col-lg-4 control-label">Propriétaire
								: </label>
							<div class="col-lg-8">
								<select id="owner" class="form-control">
									<option>Propriétaire 1</option>
									<option>Propriétaire 2</option>
									<option>Propriétaire 3</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label class="col-lg-4 control-label">Disponible : </label>
							<div class="col-lg-8">
								<label class="radio-inline"> <input type="radio" name="disponible" id=""
									value="" checked> Oui
								</label> <label class="radio-inline"> <input type="radio" name="disponible" id=""
									value=""> Non
								</label>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="site-topo" class="col-lg-4 control-label">Site
								: </label>
							<div class="col-lg-8">
								<select id="site-topo" class="form-control">
									<option>Site 1</option>
									<option>Site 2</option>
									<option>Site 3</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="photo-topo" class="col-lg-4 control-label">Choisir
								photo (300 x 250) : </label>
							<div class="col-lg-8">
								<input id="photo-topo" type="file" class="form-control-file">
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