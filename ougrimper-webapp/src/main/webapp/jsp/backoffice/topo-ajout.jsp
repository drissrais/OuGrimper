<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Création de topo</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<section class="row">
			<div class="col-lg-10">
				<form id="topoAddForm" class="well form-horizontal" enctype="multipart/form-data"
					action="topo_new" method="post">
					<div class="form-group">
						<legend>Nouveau Topo</legend>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="nom" class="col-lg-4 control-label">Nom : <span class="required">*</span></label>
							<div class="col-lg-8">
								<input id="nom" name="topo.nom" type="text" class="form-control" required>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="description" class="col-lg-4 control-label">Description
								: <span class="required">*</span></label>
							<div class="col-lg-8">
								<textarea class="form-control" id="description"
									name="topo.description" rows="4" required></textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="owner" class="col-lg-4 control-label">Propriétaire
								: <span class="required">*</span></label>
							<div class="col-lg-8">
								<select id="owner" name="topo.proprietaire.id" title="Veuillez déterminer le propriétaire !"
									class="form-control" required>
									<option selected></option>
									<s:iterator value="listProprietaireTopo">
										<option value="<s:property value="id"/>">
											<s:property value="nom" /> <s:property value="prenom" />
										</option>
									</s:iterator>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="disponible" class="col-lg-4 control-label">Prêtable : <span class="required">*</span></label>
							<div class="col-lg-8">
								<label class="radio-inline"> <input type="radio"
									name="topo.disponible" id="disponible" value="true" checked> Oui
								</label> <label class="radio-inline"> <input type="radio"
									name="topo.disponible" id="disponible" value="false"> Non
								</label>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="site-topo" class="col-lg-4 control-label">Site
								: <span class="required">*</span></label>
							<div class="col-lg-8">
								<select id="site-topo" name="topo.site.id" class="form-control" title="Veuillez déterminer le spot correspondant !" required>
									<option selected></option>
									<s:iterator value="listSite">
										<option value="<s:property value="id"/>">
											<s:property value="nom" />
										</option>
									</s:iterator>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="fileUpload" class="col-lg-4 control-label">Choisir
								photo (300 x 250) : </label>
							<div class="col-lg-8">
<!-- 								<input id="photo-topo" type="file" class="form-control-file"> -->
								<s:file id="fileUpload" name="fileUpload"
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
		$( "#topoAddForm" ).validate({
			debug: false,
		    errorElement: "span",
		    errorClass: "help-block",
// 			rules: {
// 			  nom: "required",
// 			  description: "required",
// 			  owner: "required",
// 			  site-topo: "required"
// 			}
		});
		
		$(document).ready(function () {
			$("div.nav > li").removeClass("active");
			$('#administration').addClass('active');
		});
	</script>
</body>
</html>