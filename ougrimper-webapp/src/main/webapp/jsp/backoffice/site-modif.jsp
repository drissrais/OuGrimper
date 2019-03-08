<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Modifier <s:property value="site.nom" /></title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<section class="row">
			<div class="col-lg-12">
				<form id="spotEditForm" class="well form-horizontal" action="site_edit"
					enctype="multipart/form-data" method="post">

					<%
						String id = request.getParameter("id");
					%>
					<input type="hidden" name="site.id" value="<%=id%>">

					<div class="form-group">
						<legend>
							Modifier Site :
							<s:property value="site.nom" />
						</legend>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="nom" class="col-lg-2 control-label">Nom : <span class="required">*</span></label>
							<div class="col-lg-10">
								<input id="nom" type="text" class="form-control"
									value="<s:property value="site.nom" />" name="site.nom" required>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="description" class="col-lg-2 control-label">Description
								: <span class="required">*</span></label>
							<div class="col-lg-10">
								<textarea class="form-control" id="description"
									name="site.description" rows="4" required><s:property
										value="site.description" /></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="region" class="col-lg-2 control-label">Région
								: <span class="required">*</span></label>
							<div class="col-lg-10">
								<select id="region" class="form-control" name="site.region" required title="Veuillez choisir une région !">
									<s:iterator value="listSite">
										<s:if test="region == site.region">
											<option selected><s:property value="region" /></option>
										</s:if>
										<s:else>
											<option><s:property value="region" /></option>
										</s:else>
									</s:iterator>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="localite" class="col-lg-2 control-label">Localité
								: <span class="required">*</span></label>
							<div class="col-lg-10">
								<textarea class="form-control" id="localite"
									name="site.localite" rows="4" required><s:property
										value="site.localite" /></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="pays" class="col-lg-2 control-label">Pays : <span class="required">*</span></label>
							<div class="col-lg-10">
								<select id="pays" name="site.pays.id" class="form-control"
									onchange="onSelectPaysChange()" required title="Veuillez choisir un pays !">
									<s:iterator value="listPays">
										<s:if test="id == site.pays.id">
											<option value="<s:property value="id"/>" selected><s:property
												value="nom" /></option>
										</s:if>
										<s:else>
											<option value="<s:property value="id"/>"><s:property
												value="nom" /></option>
										</s:else>
									</s:iterator>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="ville" class="col-lg-2 control-label">Ville
								la plus proche : <span class="required">*</span></label>
							<div class="col-lg-10">
								<select id="ville" name="site.ville.id" class="form-control" required title="Veuillez choisir une ville !">
									<option value="<s:property value="site.ville.id"/>"><s:property
											value="site.ville.nom" /></option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="fileUpload" class="col-lg-2 control-label">Photo
							</label>
							<div class="col-lg-10">
								<s:file id="fileUpload" name="fileUpload"
									label="Select a File to upload" size="40" requiredLabel="false" />
								<!-- 								<input id="fileUpload" name="fileUpload" type="file" class="form-control-file"> -->
							</div>
						</div>
					</div>
					<div class="form-group">
						<button class="btn btn-primary pull-right" type="submit">Enregistrer
							les modifications</button>
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
		
		$( "#spotEditForm" ).validate({
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