<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<nav class="navbar navbar-inverse" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">GRIMPO</a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">ACCUEIL</a></li>
				<li class="dropdown"><a id="site_dropdown"
					data-toggle="dropdown" href="#">SITES D'ESCALADE <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">LISTE SITES D'ESCALADE</a></li>
						<li class="divider"></li>
						<li><a href="#">SITES D'ESCALADE PAR PAYS</a></li>
						<li class="divider"></li>
						<li><a href="#">SITES D'ESCALADE PAR REGION</a></li>
					</ul></li>
				<li><a href="#">TOPOS</a></li>
				<li class="dropdown"><a id="admin_dropdown"
					data-toggle="dropdown" href="#">ADMINISTRATION <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">GESTION SITES D"ESCALADE</a></li>
						<li class="divider"></li>
						<li><a href="#">GESTION TOPOS D"ESCALADE</a></li>
						<li class="divider"></li>
						<li><a href="#">GESTION UTILISATEURS</a></li>
						<li class="divider"></li>
						<li><a href="#">GESTION COMMENTAIRES</a></li>
						<li class="divider"></li>
						<li><a href="#">GESTION RESERVATIONS</a></li>
					</ul></li>
			</ul>
			<div class="pull-right">
				<button type="submit" class="btn navbar-btn btn-primary btn-sm">Connexion</button>
				<button type="submit" class="btn navbar-btn btn-primary btn-sm">Inscription</button>
			</div>
		</div>
	</div>
</nav>

<s:actionerror />
<s:actionmessage />