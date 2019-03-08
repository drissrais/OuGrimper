<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Modification de topo</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<section class="row">
			<div class="col-lg-10">
				<form id="topoEditForm" class="well form-horizontal" action="topo_edit"
					enctype="multipart/form-data" method="post">

					<% String id = request.getParameter("id"); %>
					<input type="hidden" name="topo.id" value="<%=id%>">

					<div class="form-group">
						<legend>
							Modifier :
							<s:property value="topo.nom" />
						</legend>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="nom" class="col-lg-3 control-label">Nom : <span class="required">*</span></label>
							<div class="col-lg-9">
								<input id="nom" type="text"
									value="<s:property value="topo.nom" />" name="topo.nom"
									class="form-control" required>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="description" class="col-lg-3 control-label">Description
								: <span class="required">*</span></label>
							<div class="col-lg-9">
								<textarea class="form-control" id="description"
									name="topo.description" rows="4" required>
									<s:property value="topo.description" />
								</textarea>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="owner" class="col-lg-3 control-label">Propriétaire
								: <span class="required">*</span></label>
							<div class="col-lg-9">
								<select id="owner" name="topo.proprietaire.id" class="form-control" required title="Veuillez déterminer le propriétaire !">
									<s:iterator value="listProprietaireTopo">
										<s:if test="id == topo.proprietaire.id">
											<option value="<s:property value="id" />" selected><s:property
													value="nom" />
												<s:property value="prenom" /></option>
										</s:if>
										<s:else>
											<option value="<s:property value="id" />"><s:property
													value="nom" />
												<s:property value="prenom" /></option>
										</s:else>
									</s:iterator>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="disponible" class="col-lg-3 control-label">Prêtable : <span class="required">*</span></label>
							<div class="col-lg-9">
								<s:if test="topo.disponible == true">
									<label class="radio-inline"> <input type="radio"
										name="topo.disponible" id="disponible" value="true" checked> Oui
									</label> <label class="radio-inline"> <input type="radio"
										name="topo.disponible" id="disponible" value="false"> Non
									</label>
								</s:if>
								<s:else>
									<label for="disponible" class="radio-inline"> <input type="radio"
										name="topo.disponible" id="disponible" value="true"> Oui
									</label> <label class="radio-inline"> <input type="radio"
										name="topo.disponible" id="disponible" value="false" checked> Non
									</label>
								</s:else>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="site-topo" class="col-lg-3 control-label">Site : <span class="required">*</span></label>
							<div class="col-lg-9">
								<select id="site-topo" name="topo.site.id" class="form-control" required title="Veuillez déterminer le site correspondant !">
									<s:iterator value="listSite">
										<s:if test="id == topo.site.id">
											<option value="<s:property value="id" />" selected>
											<s:property value="nom" /></option>
										</s:if>
										<s:else>
											<option value="<s:property value="id" />">
												<s:property value="nom" /></option>
										</s:else>
									</s:iterator>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="fileUpload" class="col-lg-3 control-label">Choisir
								photo (300 x 250) : </label>
							<div class="col-lg-9">
								<s:file id="fileUpload" name="fileUpload"
									label="Select a File to upload" size="40" requiredLabel="false" />
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
		$( "#topoEditForm" ).validate({
			errorClass: 'errors',
	//			rules: {
	//			  nom: "required",
	//			  description: "required",
	//			  owner: "required",
	//			  site-topo: "required"
	//			}
		});
		
		$(document).ready(function () {
			$("div.nav > li").removeClass("active");
			$('#administration').addClass('active');
		});
	</script>
</body>
</html>