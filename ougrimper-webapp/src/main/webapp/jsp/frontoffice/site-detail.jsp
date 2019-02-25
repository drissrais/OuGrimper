<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title><s:property value="site.nom" /></title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<section class="row recherche">
			<div class="col-lg-4">
				<select class="form-control">
					<option value="" selected disabled hidden>Pays</option>
				</select>
			</div>
			<div class="col-lg-4">
				<select class="form-control">
					<option value="" selected disabled hidden>Région</option>
				</select>
			</div>
			<div class="col-lg-4">
				<select class="form-control">
					<option value="" selected disabled hidden>Site</option>
				</select>
			</div>
		</section>
		<header class="page-header">
			<h1 class="site-detail-h1">
				<s:property value="site.nom" />
			</h1>
			<h3 class="site-detail-h3">
				<s:property value="site.pays.nom" />
				-
				<s:property value="site.ville.nom" />
				(ville plus proche) -
				<s:property value="site.region" />
			</h3>
			<img alt="Site d'escalade" title="<s:property value="site.nom"/>"
				src="<s:property value="site.plan"/>">
		</header>
		<section class="row">
			<div class="col-md-8">
				<h2 class="site-detail-h2">
					<s:property value="site.nom" />
				</h2>
				<p class="site-detail-p">
					<s:property value="site.description" />
				</p>
			</div>
		</section>
		<section class="row">
			<div class="col-md-8">
				<h3>Accès & Approche</h3>
				<p class="site-detail-p">
					<s:property value="site.localite" />
				</p>
			</div>
		</section>
		<section class="row">
			<div class="col-sm-8 table-responsive">
				<h3>Secteurs & Voies</h3>
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<div class="panel-heading">
							<h3 class="panel-title">
								<s:property value="site.nom" />
							</h3>
						</div>
						<thead>
							<tr>
								<th>Secteurs</th>
								<th>Voies</th>
								<th>Cotation</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<select id="selectSecteur" name="secteur">
										<option disabled selected></option>
										<s:iterator value="listSecteur">
										<option><s:property value="nom"/></option>
										</s:iterator>
									</select>
								</td>
								<td>
									
								</td>
								<td>
									
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</section>
		<div class="row">
			<section class="col-lg-8">
				<form action="addNewComment" class="well well-lg well-sm">
					<s:hidden name="id" value="%{site.id}" />
					<h4>
						<span class="label label-lg label-default">Votre avis sur
							le site</span>
					</h4>
					<h4>Comment l'avez-vous trouvé ?</h4>
					<fieldset>
						<label for="textarea">Commencer la discussion...</label>
						<textarea id="textarea" name="textComment" class="form-control"
							rows="4"></textarea>
						<p class="help-block">Vous pouvez agrandir la fenêtre</p>
						<s:if test="#session.user">
							<button class="btn btn-primary" type="submit">
								<span class="glyphicon glyphicon-ok-sign"> Envoyer</span>
							</button>
						</s:if>
						<s:else>
							<button class="btn btn-primary" type="submit" disabled>
								<span class="glyphicon glyphicon-ok-sign"> Envoyer</span>
							</button>
						</s:else>
					</fieldset>
				</form>
			</section>
			<section class="col-sm-4">
				<div class="row">
					<div class="col-lg-12">
						<address class="well well-lg well-sm">
							<p class="site-detail-p">
								<s:a action="login">Identifiez-vous</s:a>
								pour pouvoir commencer une discussion... ou
								<s:a action="inscription">inscrivez-vous</s:a>
							</p>
						</address>
					</div>
					<s:if test="#session.user">
						<s:a class="btn btn-warning col-lg-offset-3 col-lg-6"
							action="comment_list">
							VOIR LES DISCUSSIONS
							<s:param name="id" value="site.id" />
						</s:a>
					</s:if>
					<s:else>
						<button class="btn btn-warning col-lg-offset-3 col-lg-6" disabled>VOIR
							LES DISCUSSIONS</button>
					</s:else>
				</div>
			</section>
		</div>
	</div>
	<script type="text/javascript" src="../script.js"></script>
</body>
</html>