<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Gestion des sites d'escalade</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<header class="page-header">
			<h1>Gestion Site</h1>
		</header>
		<div class="row">
			<div class="col-lg-9">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<div class="panel-heading">
							<h3 class="panel-title">Liste de tous les sites d'escalade</h3>
						</div>
						<thead>
							<tr>
								<th>Nom de site</th>
								<th>Pays</th>
								<th>Modifier</th>
								<th>Supprimer</th>								
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>Taghia</td>
								<td>Maroc</td>
								<td><button class="btn btn-warning">Modifier</button></td>
								<td><button class="btn btn-danger">Supprimer</button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-lg-2 col-lg-offset-1">
				<button class="btn btn-success" id="site-new">Nouveau site</button>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../script.js"></script>
</body>
</html>