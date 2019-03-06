<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Gestion des utilisateurs</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<header class="page-header">
			<h1>Gestion des utilisateurs</h1>
		</header>
		<div class="row">
			<div class="col-lg-10">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<div class="panel-heading">
							<h3 class="panel-title">Liste de tous les utilisateurs</h3>
						</div>
						<thead>
							<tr>
								<th>Pseudo</th>
								<th>Email</th>
								<th>Role</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listUtilisateur">
								<tr id="t<s:property value='id' />">
									<td><s:property value="pseudo" /></td>
									<td><s:property value="email" /></td>
									<td><s:property value="role" /></td>
									<td style="text-align: center;"><s:a
											action="utilisateur_dataToEdit">
											<i class="far fa-edit" data-toggle="tooltip" title="Editer"
												style="color: #698ABC;"></i>
											<s:param name="id" value="id" />
										</s:a></td>
									<td style="text-align: center;"><a
										data-toggle="confirmation"
										data-title="Supprimer l'utilisateur?" data-placement="right"
										data-popup="true"
										data-on-confirm='deleteUtilisateur(<s:property value="id" />)'>
											<i class="fas fa-trash-alt" data-toggle="tooltip"
											title="Supprimer" style="color: #D60000;"> </i>
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
		function deleteUtilisateur(val) {
			// URL de l'action AJAX
			var url = "<s:url action='ajax_deleteUtilisateur' />";

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