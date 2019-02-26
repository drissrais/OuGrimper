<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Réservations <s:property value="topo.nom"/></title>
</head>

<body>
	<%@ include file="../_include/header.jsp"%>
	<div class="container">
		<div class="row">
			<section class="col-sm-12 table-responsive">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<div class="panel-heading">
							<h3 class="panel-title">
								Réserver
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
</body>
</html>