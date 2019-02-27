<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Avis sur <s:property value="site.nom" /></title>
</head>

<body>
	<%@ include file="../_include/header.jsp"%>
	<div class="container">
		<div class="row">
			<section class="col-lg-8">
				<form class="well well-lg well-sm">
					<h4>
						<span class="label label-lg label-default">Votre avis sur <span id="nomSite"><s:property
								value="site.nom" /></span></span>
					</h4>
					<h4>Comment l'avez-vous trouvé ?</h4>
					<fieldset>
						<label for="textComment">Commencer la discussion...</label>
						<textarea id="textComment" class="form-control"
							rows="4"></textarea>
						<p class="help-block">Vous pouvez agrandir la fenêtre</p>
						<button class="btn btn-primary" onclick="addNewComment()">
							<span class="glyphicon glyphicon-ok-sign"> Envoyer</span>
						</button>
					</fieldset>
				</form>
			</section>
		</div>
		<div class="row">
			<section class="col-sm-12 table-responsive">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<div class="panel-heading">
							<h3 class="panel-title">
								Avis sur le site
								<s:property value="site.nom" />
							</h3>
						</div>
						<thead>
							<tr>
								<th>Membre</th>
								<th>Avis</th>
								<th>Date</th>
							</tr>
						</thead>
						<tbody  id="listCommentaire">
							<s:iterator value="listCommentaire">
								<tr>
									<td><i class="fa fa-user"></i> <s:property
											value="redacteur.pseudo" /> <s:text name=" : "></s:text></td>
									<td><s:property value="contenu" /></td>
									<td><s:property value="date" /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</section>
		</div>
	</div>
	<script type="text/javascript">
		function addNewComment() {
			// URL de l'action AJAX
			var url = "<s:url action='ajax_addNewComment'/>";

			var pseudo = jQuery("#pseudo").text().trim();
			var nomSite = jQuery("#nomSite").text().trim();
			var textComment = jQuery("#textComment").val().trim();

			// Paramètres de la requête AJAX
			var params = {
				pseudo : pseudo,
				nomSite : nomSite,
				textComment : textComment,
			};

			// Action AJAX en POST
			jQuery.post(
					url,
					params,
					function(data) {
						var $listCommentaire = jQuery("#listCommentaire");

						jQuery.each(data, function(key, val) {
							$listCommentaire.append(jQuery("<td>").append("<i class='fa fa-user'></i> " + pseudo + " :"));
							$listCommentaire.append(jQuery("<td>").append(textComment));
							$listCommentaire.append(jQuery("<td>").text(val.date).val(val.date));
							//alert(val.message);	
							//alert(val.author.pseudo);
						});
						//alert(data);
					}).fail(function() {
				alert("Une erreur s'est produite.");
			});
		}
	</script>
</body>
</html>