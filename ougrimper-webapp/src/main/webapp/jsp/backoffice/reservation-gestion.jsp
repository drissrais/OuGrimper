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
			<div class="col-lg-10">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<div class="panel-heading">
							<h3 class="panel-title">Liste de toutes les réservations</h3>
						</div>
						<thead>
							<tr>
								<th>Topo</th>
								<th>Réservé par</th>
								<th>De</th>
								<th>Jusqu'à</th>	
								<th></th>															
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listReservation">
								<tr>
									<td><s:property value="topo.nom" /></td>
									<td><s:property value="utilisateur.pseudo" /></td>
									<td><s:property value="dateDebut" /></td>
									<td><s:property value="dateFin" /></td>
									<td style="text-align: center;"><s:a action=""
											title="Supprimer">
											<i class="fas fa-trash-alt" style="color: #D60000;"></i>
										</s:a></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jsp/script.js"></script>
</body>
</html>