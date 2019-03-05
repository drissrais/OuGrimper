<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Gestion de sites d'escalade</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<header class="page-header">
			<h1>Gestion de sites d'escalade</h1>
		</header>
		<section class="row">
			<div class="col-xs-1">
				<s:a title="Nouveau site" class="btn btn-success btn-lg"
					id="site-new" action="site_new">
					<i class="fas fa-folder-plus fa-2x"></i>
				</s:a>
			</div>
		</section>
		<div class="row">
			<div class="col-lg-10">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<div class="panel-heading">
							<h3 class="panel-title">Liste de tous les sites d'escalade</h3>
						</div>
						<thead>
							<tr>
								<th>Id site</th>
								<th>Nom</th>
								<th>Pays</th>
								<th style="text-align: center;"></th>
								<th style="text-align: center;"></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listSite">
								<tr>
									<td id="siteId"><s:property value="id" /></td>
									<td><s:property value="nom" /></td>
									<td><s:property value="pays.nom" /></td>
									<td style="text-align: center;"><s:a
											action="site_dataToEdit" title="Editer">
											<i class="far fa-edit" style="color: #698ABC;"></i>
											<s:param name="id" value="id" />
										</s:a></td>
									<td style="text-align: center;"><a class="linkDelete"
										href="deleteSite(this)" title="Supprimer Site"
										data-toggle="confirmation" data-title="Supprimer ce site?"
										data-placement="right" data-popout="true">
											<i class="fas fa-trash-alt" style="color: #D60000;"></i>
									</a></td>
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
		function deleteSite(val) {
			// URL de l'action AJAX
			var url = "<s:url action='ajax_deleteSite' />";

			// Paramètres de la requête AJAX
			var params = {
				siteId : jQuery(val).parent().prev().prev().prev().prev()
						.text()
			};

			// Action AJAX en POST
			jQuery.post(url, params, function(data) {
				// 						alert(data);
				$linkDelete = jQuery('.linkDelete');
				$linkDelete.closest('tr').remove();
			}).fail(function(data) {
				if (typeof data.responseJSON === 'object') {
					console.log(data.responseJSON);
				} else {
					console.log(data);
				}
				alert("Une erreur s'est produite.");
			});
		}
	</script>
</body>
</html>