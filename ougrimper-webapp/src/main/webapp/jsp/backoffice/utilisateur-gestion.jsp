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
			<div class="col-lg-9">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<div class="panel-heading">
							<h3 class="panel-title">Liste de tous les utilisateurs</h3>
						</div>
						<thead>
							<tr>
								<th>Pseudo</th>
								<th>Email</th>
								<th></th>
								<th></th>								
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listUtilisateur">
								<tr>
									<td><s:property value="pseudo" /></td>
									<td><s:property value="email" /></td>
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