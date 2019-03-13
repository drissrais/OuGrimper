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
			<s:a class="navbar-brand" action="index">GRIMPO</s:a>
		</div>
		<div class="collapse navbar-collapse">
			<ul class="nav navbar-nav">
				<li id="home"><s:a action="index">ACCUEIL</s:a></li>
				<li id="spots" class="dropdown"><a id="site_dropdown"
					data-toggle="dropdown" href="#">SITES D'ESCALADE <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><s:a action="site_list">LISTE SITES D'ESCALADE</s:a></li>
						<li><s:a action="pays_list">SITES D'ESCALADE PAR PAYS</s:a></li>
						<li><s:a action="ville_list">SITES D'ESCALADE PAR VILLE PLUS PROCHE</s:a></li>
					</ul></li>
				<li id="topos"><s:a action="topo_list">TOPOS</s:a></li>
				<s:if test="%{#session.user.role=='admin'}">
					<li id="administration" class="dropdown"><a id="admin_dropdown"
						data-toggle="dropdown" href="#">ADMINISTRATION <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><s:a action="site_gestion">GESTION SITES D'ESCALADE</s:a></li>
							<li class="divider"></li>
							<li><s:a action="topo_gestion">GESTION TOPOS D'ESCALADE</s:a></li>
							<li class="divider"></li>
							<li><s:a action="utilisateur_gestion">GESTION UTILISATEURS</s:a></li>
							<li class="divider"></li>
							<li><s:a action="commentaire_gestion">GESTION COMMENTAIRES</s:a></li>
							<li class="divider"></li>
							<li><s:a action="reservation_gestion">GESTION RESERVATIONS</s:a></li>
						</ul>
					</li>
				</s:if>
			</ul>
			<div class="pull-right">
				<s:if test="#session.user">
					<span style="font-weight: bold; color: white; font-size: 1.1em; margin-right: 10px;">Bienvenue <span id="pseudo"><s:property value="#session.user.pseudo" /></span></span>
					<s:a type="submit" class="btn navbar-btn btn-primary btn-sm" action="logout">Déconnexion</s:a>
				</s:if>
				<s:else>
					<s:a type="submit" class="btn navbar-btn btn-primary btn-sm" action="login">Connexion</s:a>
					<s:a type="submit" class="btn navbar-btn btn-primary btn-sm" action="inscription">Inscription</s:a>
				</s:else>
			</div>
		</div>
	</div>
</nav>
