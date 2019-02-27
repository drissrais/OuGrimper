<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Réserver <s:property value="topo.nom"/></title>
</head>

<body>
	<%@ include file="../_include/header.jsp"%>
	<div class="container">
		<div class="row">
			<section class="col-lg-8">
				<form class="well well-lg well-sm">
					<h4>
						<span class="label label-lg label-default">Si vous voulez réserver <span id="nomTopo"><s:property value="topo.nom"/></span></span>
					</h4>
					<h4>Choisissez la période :</h4>
					<fieldset>
						<div class="form-group">
							<label for="depuis">Période de :</label>
							<input id="depuis" name="dateDebut" class="form-control" type="date"></input>
						</div>
						<div class="form-group">
							<label for="jusqu'a">Jusqu'à :</label>
							<input id="jusqu'a" name="dateFin" class="form-control" type="date"></input>
						</div>
						<button class="btn btn-primary" onclick="addNewReservation()">
							<span class="glyphicon glyphicon-ok-sign"> Confirmer</span>
						</button>
					</fieldset>
				</form>
			</section>
		</div>
		<div class="row">
			<section class="col-sm-12 table-responsive">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<div class="panel-heading">
							<h3 class="panel-title">
								Liste des réservations de : 
								<s:property value="topo.nom" />
							</h3>
						</div>
						<thead>
							<tr>
								<th>Période de</th>
								<th>Jusqu'à</th>
								<th>Membre</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listReservation">
								<tr>
									<td><s:property value="dateDebut" /></td>
									<td><s:property value="dateFin" /></td>
									<td><s:property value="utilisateur.pseudo" /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</section>
		</div>
	</div>
	<script type="text/javascript">
		function addNewReservation() {
			// URL de l'action AJAX
			var url = "<s:url action='ajax_addNewReservation'/>";

			var pseudo = jQuery("#pseudo").text().trim();
			var nomTopo = jQuery("#nomTopo").text().trim();
			var dateDebut = jQuery("#depuis").val().trim();
			var dateFin = jQuery("#jusqu'a").val().trim();

			// Paramètres de la requête AJAX
			var params = {
				pseudo : pseudo,
				nomTopo : nomTopo,
				dateDebut : dateDebut,
				dateFin : dateFin,
			};

			// Action AJAX en POST
			jQuery.post(
					url,
					params,
					function(data) {
						var $listReservation = jQuery("#listReservation");

						jQuery.each(data, function(key, val) {
							$listReservation.append(jQuery("<td>").text(val.date).val(val.dateDebut));
							$listReservation.append(jQuery("<td>").text(val.date).val(val.dateFin));
							$listReservation.append(jQuery("<td>").append("<i class='fa fa-user'></i> " + pseudo));
							//alert(val.message);	
							//alert(val.author.pseudo);
						});
						//alert(data);
					}).fail(function() {
				alert("Une erreur s'est produite.");
			});
		}
	</script>
</body>
</html>