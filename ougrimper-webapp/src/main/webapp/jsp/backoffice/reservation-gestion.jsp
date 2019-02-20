<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Gestion des réservations</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<header class="page-header">
			<h1>Gestion Réservation</h1>
		</header>
		<div class="row">
			<div class="col-lg-9">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<div class="panel-heading">
							<h3 class="panel-title">Liste de tous les réservations</h3>
						</div>
						<thead>
							<tr>
								<th>Réservé par</th>
								<th>Topo</th>
								<th>De</th>
								<th>Jusqu'à</th>	
								<th>Annulation</th>															
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>driss</td>
								<td>Taghia topo</td>
								<td>16/02/2019</td>
								<td>16/03/2019</td>
								<td><button class="btn btn-danger">Annuler</button></td>
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