<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Gestion des commentaires</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<header class="page-header">
			<h1>Gestion des commentaires</h1>
		</header>
		<div class="row">
			<div class="col-md-10 col-sm-12 col-xs-12">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<div class="panel-heading">
							<h3 class="panel-title">Liste de tous les commentaires</h3>
						</div>
						<thead>
							<tr>
								<th>Posté par</th>
								<th>Contenu</th>
								<th></th>								
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listCommentaire">
								<tr id="t<s:property value='id' />">
									<td><s:property value="redacteur.pseudo" /></td>
									<td><s:property value="contenu" /></td>
									<td style="text-align: center;">
										<a data-toggle="confirmation" data-title="Supprimer ce commentaire?" 
											data-placement="right" data-popup="true" 
											data-on-confirm='deleteCommentaire(<s:property value="id" />)'>
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
		function deleteCommentaire(val) {
			// URL de l'action AJAX
			var url = "<s:url action='ajax_deleteCommentaire' />";

			//alert(val);

			// Paramètres de la requête AJAX
			var params = {
				commentaireId : val
			};

			// Action AJAX en POST
			jQuery.post(url, params, function() {
				$('#t' + val).remove();
			});
		}
		
		$(document).ready(function () {
			$("div.nav > li").removeClass("active");
			$('#administration').addClass('active');
		});
	</script>
</body>
</html>