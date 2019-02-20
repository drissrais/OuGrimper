<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<link href="../style.css" rel="stylesheet" media="screen"
	type="text/css" title="main_css">
<title>Gestion des commentaires</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<header class="page-header">
			<h1>Gestion Commentaire</h1>
		</header>
		<div class="row">
			<div class="col-lg-9">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<div class="panel-heading">
							<h3 class="panel-title">Liste de tous les commentaires</h3>
						</div>
						<thead>
							<tr>
								<th>Posté par</th>
								<th>Contenu</th>
								<th>Supprimer</th>								
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>driss</td>
								<td>Super site idéal pour apprendre le terrain vague</td>
								<td><button class="btn btn-danger">Supprimer</button></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="../script.js"></script>
</body>
</html>