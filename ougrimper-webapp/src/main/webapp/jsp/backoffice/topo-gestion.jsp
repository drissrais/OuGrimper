<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Gestion de topos d'escalade</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<header class="page-header">
			<h1>Gestion de topos d'escalade</h1>
		</header>
		<section class="row">
			<div class="col-xs-1">
				<s:a title="Nouveau topo" class="btn btn-success btn-lg"
					id="topo-new" action="topo_new">
					<i class="fas fa-folder-plus fa-2x"></i>
				</s:a>
			</div>
		</section>
		<div class="row">
			<div class="col-lg-10">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<div class="panel-heading">
							<h3 class="panel-title">Liste de tous les topos d'escalade</h3>
						</div>
						<thead>
							<tr>
								<th>Nom Topo</th>
								<th>Propriétaire</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listTopo">
								<tr id="t<s:property value='id' />">
									<td><s:property value="nom" /></td>
									<td><s:property value="proprietaire.prenom" /> <s:property
											value="proprietaire.nom" /></td>
									<td style="text-align: center;"><s:a
											action="topo_dataToEdit">
											<i class="far fa-edit" data-toggle="tooltip" title="Editer"
												style="color: #698ABC;"></i>
											<s:param name="id" value="id" />
										</s:a></td>
									<td style="text-align: center;"><a
										data-toggle="confirmation" data-title="Supprimer le topo?"
										data-placement="right" data-popout="true"
										data-on-confirm='deleteTopo(<s:property value="id" />)'> <i
											class="fas fa-trash-alt" data-toggle="tooltip"
											title="Supprimer" style="color: #D60000;"></i>
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
		function deleteTopo(val) {
			// URL de l'action AJAX
			var url = "<s:url action='ajax_deleteTopo' />";

			//alert(val);

			// Paramètres de la requête AJAX
			var params = {
				id : val
			};

			// Action AJAX en POST
			jQuery.post(url, params, function() {
				$('#t' + val).remove();
			});
		}
	</script>
</body>
</html>