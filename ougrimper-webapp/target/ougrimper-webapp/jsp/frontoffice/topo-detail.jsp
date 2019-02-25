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
			<h1 class="topo-detail-h1"><s:property value="topo.nom"/></h1>
			<h3 class="topo-detail-h3"><s:property value="topo.site.pays.nom"/>   -  <s:property value="topo.site.region"/></h3>
			<img alt="Site d'escalade" title="<s:property value="topo.site.nom"/>" src="<s:property value="topo.site.plan"/>">
		</header>
		<section class="row">
			<div class="col-md-8">
				<h2 class="topo-detail-h2"><s:property value="topo.nom"/></h2>
				<p class="topo-detail-p"><s:property value="topo.description"/></p>
			</div>
		</section>
		<section class="row">
			<div class="col-md-8">
				<h3>Disponibilité & Propriétaire</h3>
				<s:set var="disponible"><s:property value="topo.disponible"/></s:set>
				<p class="topo-detail-p">
					<s:if test="%{#disponible=='true'}">- Disponible pour prêt.</s:if>
					<s:else>- Non disponible pour prêt.</s:else>
				</p>
				<p class="topo-detail-p">- Email du propriétaire de topo : <s:property value="topo.proprietaire.email"/></p>
			</div>
		</section>
		<div class="row">
			<section class="col-lg-8">
				<form action="" class="well well-lg well-sm">
					<h4>
						<span class="label label-lg label-default">Si vous voulez réserver le topo</span>
					</h4>
					<h4>Choisissez la période :</h4>
					<fieldset>
						<div class="form-group">
							<label for="depuis">De :</label>
							<input id="depuis" class="form-control" type="date"></input>
						</div>
						<div class="form-group">
							<label for="jusqu'a">Jusqu'à :</label>
							<input id="jusqu'a" class="form-control" type="date"></input>
						</div>
						<button class="btn btn-primary" type="submit">
							<span class="glyphicon glyphicon-ok-sign"> Confirmer</span>
						</button>
					</fieldset>
				</form>
			</section>
			<section class="col-sm-4">
				<div class="row">
					<div class="col-lg-12">
						<address class="thumbnail">
							<p>
								<a>Identifiez-vous</a> pour pouvoir
								réserver des topos... ou <a>inscrivez-vous</a>
							</p>
						</address>
					</div>
					<button class="btn btn-warning col-lg-offset-2 col-lg-8">LISTE DES RESERVATIONS</button>
				</div>
			</section>
		</div>
	</div>
	<script type="text/javascript" src="../script.js"></script>
</body>
</html>