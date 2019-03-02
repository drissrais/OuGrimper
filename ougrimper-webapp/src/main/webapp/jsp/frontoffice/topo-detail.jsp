<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title></title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<header class="page-header">
			<h1 class="topo-detail-h1">
				<s:property value="topo.nom" />
			</h1>
			<h3 class="topo-detail-h3">
				<s:property value="topo.site.pays.nom" />
				-
				<s:property value="topo.site.region" />
			</h3>
			<img alt="Site d'escalade"
				title="<s:property value="topo.site.nom"/>"
				src="<s:property value="topo.site.plan"/>">
		</header>
		<section class="row">
			<div class="col-md-8">
				<h2 class="topo-detail-h2">
					<s:property value="topo.nom" />
				</h2>
				<p class="topo-detail-p">
					<s:property value="topo.description" />
				</p>
			</div>
		</section>
		<section class="row">
			<div class="col-md-8">
				<h3>Disponibilité & Propriétaire</h3>
				<s:set var="disponible">
					<s:property value="topo.disponible" />
				</s:set>
				<p class="topo-detail-p">
					<s:if test="%{#disponible=='true'}">
						<h3>
							<span class="label label-info">DISPONIBLE pour Prêt</span>
						</h3>
					</s:if>
					<s:else>
						<h3>
							<span class="label label-info">NON DISPONIBLE pour Prêt</span>
						</h3>
					</s:else>
				</p>
				<p class="topo-detail-p">
					<h3>
						<span class="label label-info">
							Contact Propriétaire Topo : <s:property value="topo.proprietaire.email" />
						</span>
					</h3>
				</p>
			</div>
		</section>
		<div class="row">
			<section class="col-lg-8">
				<form class="well well-lg well-sm" action="addNewReservation">
					<s:hidden name="id" value="%{topo.id}" />
					<h4>
						<span class="label label-lg label-default">Si vous voulez
							réserver le topo</span>
					</h4>
					<h4>Choisissez la période :</h4>
					<fieldset>
						<div class="form-group">
							<label for="depuis">Période de :</label> <input id="depuis"
								name="dateDebut" class="form-control" type="date"></input>
						</div>
						<div class="form-group">
							<label for="jusqu'a">Jusqu'à :</label> <input id="jusqu'a"
								name="dateFin" class="form-control" type="date"></input>
						</div>
						<s:if test="#session.user">
							<button class="btn btn-primary" type="submit">
								<span class="glyphicon glyphicon-ok-sign"> Confirmer</span>
							</button>
						</s:if>
						<s:else>
							<button class="btn btn-primary" type="submit" disabled>
								<span class="glyphicon glyphicon-ok-sign"> Confirmer</span>
							</button>
						</s:else>
					</fieldset>
				</form>
			</section>
			<section class="col-sm-4">
				<div class="row">
					<div class="col-lg-12">
						<address class="well well-lg well-sm">
							<p class="topo-detail-p">
								<s:a action="login">Connectez-vous</s:a>
								pour pouvoir réserver des topos... ou
								<s:a action="inscription">inscrivez-vous</s:a>
							</p>
						</address>
					</div>
					<s:if test="#session.user">
						<s:a class="btn btn-warning col-lg-offset-2 col-lg-8"
							action="reservation_list">
							LISTE DES RESERVATIONS
							<s:param name="id" value="topo.id" />
						</s:a>
					</s:if>
					<s:else>
						<button class="btn btn-warning col-lg-offset-2 col-lg-8" disabled>LISTE
							DES RESERVATIONS</button>
					</s:else>
				</div>
			</section>
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jsp/script.js"></script>
</body>
</html>