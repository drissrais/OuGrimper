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
				<button title="Nouveau topo" class="btn btn-success btn-lg" id="topo-new">
					<i class="fas fa-folder-plus fa-2x"></i>
				</button>
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
								<th>Nom de topo</th>
								<th>Propriétaire</th>
								<th></th>
								<th></th>								
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listTopo">
								<tr>
									<td><s:property value="nom" /></td>
									<td><s:property value="proprietaire.prenom" /> <s:property value="proprietaire.nom" /></td>
									<td style="text-align: center;"><s:a action=""
											title="Editer">
											<i class="far fa-edit" style="color: #698ABC;"></i>
										</s:a></td>
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