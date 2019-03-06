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
								<tr id='t<s:property value="id" />'>
									<td><s:property value="topo.nom" /></td>
									<td><s:property value="utilisateur.pseudo" /></td>
									<td><s:property value="dateDebut" /></td>
									<td><s:property value="dateFin" /></td>
									<td style="text-align: center;">
										<a data-toggle="confirmation" data-title="Supprimer cette réservation?" 
											data-placement="right" data-popup="true" 
											data-on-confirm='deleteReservation(<s:property value="id" />)'>
											<i class="fas fa-trash-alt" data-toggle="tooltip"
												title="Supprimer" style="color: #D60000;">
											</i>
										</a>
									</td>
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
	<script type="text/javascript">
		function deleteReservation(val) {
			// URL de l'action AJAX
			var url = "<s:url action='ajax_deleteReservation' />";

			//alert(val);

			// Paramètres de la requête AJAX
			var params = {
				reservationId : val
			};

			// Action AJAX en POST
			jQuery.post(url, params, function() {
				$('#t' + val).remove();
			});
		}
	</script>
</body>
</html>