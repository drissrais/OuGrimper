<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="_include/head.jsp"%>
<title>GRIMPO</title>
<link href="style.css" rel="stylesheet" media="screen" type="text/css" title="main_css">
</head>
<body>
	<div class="container">
		<%@ include file="_include/header.jsp"%>
		<header class="page-header">
			<h1>Le site de l'escalade</h1>
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
					pratiquant est couramment appelé « grimpeur ». <br>
					L'escalade développe de nombreuses qualités physiques, comme la
					force musculaire, la souplesse, l'endurance musculaire, l'équilibre
					et de bonnes capacités psychomotrices. Elle sollicite
					particulièrement la musculature des bras, du tronc et des jambes.<br>
					<small class="pull-right">Wikipedia</small><br>
				</blockquote>
			</div>
		</section>
		<section class="row">
			<div class="col-lg-4">
				<h4 class="">Une courte vidéo de présentation</h4>
				Admirez cette agréable pratique sportive...
			</div>
			<div class="col-lg-8">
				<div class="embed-responsive embed-responsive-16by9">
					<iframe class="embed-responsive-item"
						src="https://www.youtube.com/embed/A9d1OtIzOZw" frameborder="0" allowfullscreen></iframe>
				</div>
			</div>
		</section>
		<section class="row">
			<div class="col-lg-2 col-lg-offset-5">
				<button class="btn btn-warning btn-lg">VOIR LES SITES</button>
			</div>
		</section>
	</div>
	<script type="text/javascript" src="script.js"></script>
</body>
</html>