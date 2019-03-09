<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="_include/head.jsp"%>
<title>GRIMPO</title>
</head>
<body>
	<div class="container">
		<%@ include file="_include/header.jsp"%>
		<section class="row">
			<div class="col-md-12 hidden-xs hidden-sm">
				<div class="carousel slide" id="carousel" data-ride="carousel">
					<ol class="carousel-indicators">
						<li class="active" data-target="#carousel" data-slide-to="0"></li>
						<li data-target="#carousel" data-slide-to="1"></li>
						<li data-target="#carousel" data-slide-to="2"></li>
					</ol>
					<div class="carousel-inner thumbnail">
						<div class="item active">
							<img alt="Escalade" style="width: 100%" title="ESCALADE" src="${pageContext.request.contextPath}/jsp/images/home.jpg" class="img-rounded">
						</div>
						<div class="item">
							<img alt="Escalade" style="width: 100%" title="ESCALADE" src="${pageContext.request.contextPath}/jsp/images/home3.jpg" class="img-rounded">
						</div>
						<div class="item">
							<img alt="Escalade" style="width: 100%" title="ESCALADE" src="${pageContext.request.contextPath}/jsp/images/home4.jpg" class="img-rounded">
						</div>
					</div>
				</div>
			</div>
		</section>
		<header class="page-header">
			<s:actionmessage class="label-success actionMessage"/>
			<h1 id="site-title-police">G R I M P O.. le site de l'escalade</h1>
		</header>
		<section class="row">
			<div class="col-lg-12">
				<p>
					Je suis passionné par l'<strong>escalade</strong> depuis très
					longtemps. Ce site a été construit en <em>hommage à ce
						merveilleux sport.</em><br> Je fais partie de la <abbr
						title="Société des Passionnés de l'Escalade">SPE</abbr> qui a pour
					but de promouvoir et de développer cette splendide discipline
					sportive.
				</p>
				<p>Voici ce qu'en dit le wikipedia :</p>
				<blockquote>
					L’escalade, ou grimpe, parfois appelée varappe, est une pratique et
					un sport consistant à progresser le long d'une paroi pour atteindre
					le haut d'un relief ou d'une structure artificielle par un
					cheminement appelé voie, avec ou sans aide de matériel. Le terrain
					de pratique va des blocs de faible hauteur aux parois de plusieurs
					centaines de mètres, en passant par les murs d'escalade. Le
					pratiquant est couramment appelé « grimpeur ». <br> L'escalade
					développe de nombreuses qualités physiques, comme la force
					musculaire, la souplesse, l'endurance musculaire, l'équilibre et de
					bonnes capacités psychomotrices. Elle sollicite particulièrement la
					musculature des bras, du tronc et des jambes.<br> <small
						class="pull-right">Wikipedia</small><br>
				</blockquote>
			</div>
		</section>
		<section class="row">
			<div class="col-sm-4">
				<h4 class="">Une courte vidéo de présentation</h4>
				Admirez cette agréable pratique sportive...
			</div>
			<div class="col-sm-8">
				<div class="embed-responsive embed-responsive-16by9">
					<iframe class="embed-responsive-item"
						src="https://www.youtube.com/embed/2TE7v1FH-qo" frameborder="0"
						allowfullscreen></iframe>
				</div>
			</div>
		</section>
		<section class="row">
			<div class="col-xs-4 col-xs-offset-4">
				<s:a class="btn btn-warning btn-block" id="btn-voir-site" action="site_list">voir les sites d'escalade</s:a>
			</div>
		</section>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jsp/script.js"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			$("div.nav > li").removeClass("active");
			$('#home').addClass('active');
		});
	</script>
</body>
</html>