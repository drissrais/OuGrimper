<%@page import="org.driss.ougrimper.model.bean.utilisateur.Utilisateur"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Modifier Utilisateur <s:property value="utilisateur.id" /></title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<section class="row">
			<div class="col-lg-10">
				<form id="userUpdateForm" class="well form-horizontal" action="utilisateur_edit"
					enctype="multipart/form-data" method="post">

					<%
						String id = request.getParameter("id");
					%>
					<input type="hidden" name="utilisateur.id" value="<%=id%>">

					<div class="form-group">
						<legend>
							Modifier Utilisateur :
							<s:property value="utilisateur.pseudo" />
						</legend>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="civilite" class="col-lg-4 control-label">Civilité
								: <span class="required">*</span></label>
							<div class="col-lg-8">
								<select id="civilite" name="utilisateur.civilite"
									class="form-control">
									<option selected disabled><s:property
											value='utilisateur.civilite' /></option>
									<option>Mlle.</option>
									<option>Mme.</option>
									<option>Mr.</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="nom" class="col-lg-4 control-label">Nom : <span class="required">*</span></label>
							<div class="col-lg-8">
								<input id="nom" name="utilisateur.nom"
									value="<s:property value='utilisateur.nom' />" type="text"
									class="form-control" required>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="prenom" class="col-lg-4 control-label">Prénom
								: <span class="required">*</span></label>
							<div class="col-lg-8">
								<input id="prenom" name="utilisateur.prenom"
									value="<s:property value='utilisateur.prenom' />" type="text"
									class="form-control" required>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="pseudo" class="col-lg-4 control-label">Pseudo
								: <span class="required">*</span></label>
							<div class="col-lg-8">
								<input id="pseudo" name="utilisateur.pseudo"
									value="<s:property value='utilisateur.pseudo' />" type="text"
									class="form-control" required>
							</div>
						</div>
					</div>
					<div class="row">
						<%
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							Date dateDeNaissance = ((Utilisateur)request.getAttribute("utilisateur")).getDateDeNaissance();
							String d = dateFormat.format(dateDeNaissance);
						%>
						<div class="form-group">
							<label for="date" class="col-lg-4 control-label">Date de
								naissance : <span class="required">*</span></label>
							<div class="col-lg-8">
								<input id="date" name="utilisateur.dateDeNaissance" value="<%=d%>" type="date" class="form-control" required>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="role" class="col-lg-4 control-label">Role : <span class="required">*</span></label>
							<div class="col-lg-8">
								<select id="role" name="utilisateur.role" class="form-control" required title="Veuillez déterminer le rôle !">
									<option selected disabled><s:property
											value='utilisateur.role' /></option>
									<option>topo_owner</option>
									<option>user</option>
									<option>admin</option>
								</select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="email" class="col-lg-4 control-label">Email :
							<span class="required">*</span></label>
							<div class="col-lg-8">
								<input id="email" name="utilisateur.email"
									value="<s:property value='utilisateur.email' />" type="email"
									class="form-control" required>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="password" class="col-lg-4 control-label">Mot
								de passe : <span class="required">*</span></label>
							<div class="col-lg-8">
								<div class="input-group">
									<input id="password" name="utilisateur.motDePasse"
										value="<s:property value='utilisateur.motDePasse' />"
										type="password" class="form-control"> <span
										class="fa fa-fw fa-eye input-group-addon toggle-password" required></span>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group">
							<label for="passConfirm" class="col-lg-4 control-label">Confirmer
								mot de passe : <span class="required">*</span></label>
							<div class="col-lg-8">
								<input type="password" id="passConfirm" name="passConfirm" class="form-control">
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
		$("body").on('click', '.toggle-password', function() {
			$(this).toggleClass("fa-eye fa-eye-slash");
			var input = $("#password");
			if (input.attr("type") === "password") {
				input.attr("type", "text");
			} else {
				input.attr("type", "password");
			}
		});
		
		$( "#userUpdateForm" ).validate({
			errorClass: 'errors',
			rules: {
				email: {
			    	required: true,
			    	email: true
			    },
				passConfirm: {
					required: true,
				  	equalTo: "#password"
				}
			}
		});
		
		$(document).ready(function () {
			$("div.nav > li").removeClass("active");
			$('#administration').addClass('active');
		});
	</script>
</body>
</html>