<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Réserver <s:property value="topo.nom" /></title>
</head>

<body>
	<%@ include file="../_include/header.jsp"%>
	<s:hidden id="topoId" value="%{topo.id}" />

	<div class="container">
		<div class="row">
			<section class="col-lg-8">
				<div class="well well-sm well-lg">
					<h4>
						<span class="label label-lg label-default">Si vous voulez
							réserver <span><s:property value="topo.nom" /></span>
						</span>
					</h4>
					<h4>Choisissez la période :</h4>
					<fieldset>
						<div class="form-group">
							<label for="depuis">Période de :</label> <input id="depuis"
								class="form-control" type="date"></input>
						</div>
						<div class="form-group">
							<label for="jusqua">Jusqu'à :</label> <input id="jusqua"
								class="form-control" type="date"></input>
						</div>
						<button class="btn btn-primary" onclick="addNewReservation()">
							<span class="glyphicon glyphicon-ok-sign"> Confirmer</span>
						</button>
					</fieldset>
				</div>
			</section>
		</div>
		<div class="row">
			<section class="col-sm-12 table-responsive">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed" id="listReservation">
						<div class="panel-heading">
							<h3 class="panel-title">
								Liste Réservations :
								<s:property value="topo.nom" />
							</h3>
						</div>
						<thead>
							<tr>
								<th>Période de</th>
								<th>Jusqu'à</th>
								<th>Réservé par</th>
							</tr>
						</thead>
						<tbody >
							<s:iterator value="listReservation">
								<tr>
									<td><s:property value="dateDebut" /></td>
									<td><s:property value="dateFin" /></td>
									<td><i class="fa fa-user"></i> <span
										class="label label-info"><s:property
												value="utilisateur.pseudo" /></span></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</section>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jsp/script.js"></script>
	<script type="text/javascript">
		function addNewReservation() {
			// URL de l'action AJAX
			var url = "<s:url action='ajax_addNewReservation'/>";

			var topoId = jQuery("#topoId").val();
			var dateDebut = jQuery("#depuis").val();
			var dateFin = jQuery("#jusqua").val();

			// Paramètres de la requête AJAX
			var params = {
				id : topoId,
				dateDebut : dateDebut,
				dateFin : dateFin,
			};

			// Action AJAX en POST
			jQuery.post(
					url,
					params,
					function(data) {
						alert(data);
						var $listReservation = jQuery("#listReservation");
						$listReservation.append($('<tr>')
							.append($('<td>').append(dateDebut))
							.append($('<td>').append(dateFin))
							.append($('<td>').append("<i class='fa fa-user'></i> <span class='label label-info'>" + data.utilisateur.pseudo + "</span>"))
						);
						//alert(val.message);	
						//alert(val.author.pseudo);
					}).fail(function() {
				alert("Une erreur s'est produite.");
			});
		}
	</script>
</body>
</html>