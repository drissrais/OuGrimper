<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Création de site</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<section class="row">
			<div class="col-lg-10">
				<form id="spotAddForm" class="well form-horizontal" enctype="multipart/form-data"
					action="site_new" method="post">
					<div class="form-group">
						<legend>Nouveau Site</legend>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="nom" class="col-lg-3 control-label">Nom : <span class="required">*</span></label>
							<div class="col-lg-9">
								<input id="nom" name="site.nom" type="text" class="form-control" required>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="description" class="col-lg-3 control-label">Description
								: <span class="required">*</span></label>
							<div class="col-lg-9">
								<textarea class="form-control" id="description" rows="4" required
									name="site.description"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="region" class="col-lg-3 control-label">Région
								: <span class="required">*</span></label>
							<div class="col-lg-9">
								<input id="region" name="site.region" type="text" required
									class="form-control">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="localite" class="col-lg-3 control-label">Localité
								: <span class="required">*</span></label>
							<div class="col-lg-9">
								<textarea class="form-control" id="localite" required
									name="site.localite" rows="4"></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="pays" class="col-lg-3 control-label">Pays : <span class="required">*</span></label>
							<div class="col-lg-9">
								<select id="pays" name="site.pays.id" class="form-control" title="Veuillez choisir un pays !"
									onchange="onSelectPaysChange()" required>
									<option selected></option>
									<s:iterator value="listPays">
										<option value="<s:property value="id"/>"><s:property value="nom" /></option>
									</s:iterator>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="ville" class="col-lg-3 control-label">Ville
								la plus proche : <span class="required">*</span></label>
							<div class="col-lg-9">
								<select id="ville" name="site.ville.id" class="form-control" title="Veuillez choisir une ville !" required>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="fileUpload" class="col-lg-3 control-label">Choisir
								photo (317 x 212) : </label>
							<div class="col-lg-9">
								<s:file id="fileUpload" name="fileUpload"
									label="Select a File to upload" size="40" requiredLabel="false"
									class="form-control-file" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="file2Upload" class="col-lg-3 control-label">Choisir
								photo (670 x 378) : </label>
							<div class="col-lg-9">
								<s:file id="file2Upload" name="file2Upload"
									label="Select a File to upload" size="40" requiredLabel="false"
									class="form-control-file" />
							</div>
						</div>
					</div>
					<div class="form-group">
						<button class="btn btn-primary pull-right" type="submit">Soumettre</button>
					</div>
				</form>
			</div>
		</section>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jsp/script.js"></script>
	<script type="text/javascript">
		function onSelectPaysChange() {
			// URL de l'action AJAX
			var url = "<s:url action='ajax_getListVille'/>";
	
			// Paramètres de la requête AJAX
			var params = {
				paysId : jQuery("#pays").val()
			};
			// alert(paysId);
			// Action AJAX en POST
			jQuery.post(
					url,
					params,
					function(data) {
						// alert(data);
						var $selectVille = jQuery("#ville");
						$selectVille.empty();
						jQuery.each(data, function(key, val) {
							$selectVille.append(jQuery("<option>")
									.text(val.nom).val(val.id));
						});
					}).fail(function(data) {
				if (typeof data.responseJSON === 'object') {
					console.log(data.responseJSON);
				} else {
					console.log(data);
				}
				alert("Une erreur s'est produite.");
			});
		}
		
		$( "#spotAddForm" ).validate({
			errorClass: 'errors',
			rules: {
// 			  nom: "required",
// 			  description: "required",
// 			  region: "required",
// 			  localite: "required",
// 			  pays: "required",
// 			  ville: "required"
			}
		});
		
		$(document).ready(function () {
			$("div.nav > li").removeClass("active");
			$('#administration').addClass('active');
		});
	</script>
</body>
</html>