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
				<form class="well form-horizontal" action="site_edit"
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
							<label for="nom" class="col-lg-2 control-label">Nom : </label>
							<div class="col-lg-10">
								<input id="nom" type="text" class="form-control"
									value="<s:property value="site.nom" />" name="site.nom">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="description" class="col-lg-2 control-label">Description
								: </label>
							<div class="col-lg-10">
								<textarea class="form-control" id="description"
									name="site.description" rows="4"><s:property
										value="site.description" /></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="region" class="col-lg-2 control-label">Région
								: </label>
							<div class="col-lg-10">
								<select id="region" class="form-control" name="site.region">
									<option value="<s:property value="site.region"/>"><s:property
											value="site.region" /></option>
									<s:iterator value="listSite">
										<option><s:property value="region" /></option>
									</s:iterator>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="localite" class="col-lg-2 control-label">Localité
								: </label>
							<div class="col-lg-10">
								<textarea class="form-control" id="localite"
									name="site.localite" rows="4"><s:property
										value="site.localite" /></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="pays" class="col-lg-2 control-label">Pays : </label>
							<div class="col-lg-10">
								<select id="pays" name="site.pays.nom" class="form-control"
									onchange="onSelectPaysChange()">
									<s:iterator value="listPays">
										<s:if test="nom == site.pays.nom">
											<option value="<s:property value="nom"/>" selected><s:property
												value="nom" /></option>
										</s:if>
										<s:else>
											<option value="<s:property value="nom"/>"><s:property
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
								la plus proche : </label>
							<div class="col-lg-10">
								<select id="ville" name="site.ville.id" class="form-control">
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
				paysNom : jQuery("#pays").val()
			};
			// 			alert(paysNom);
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
	</script>
</body>
</html>