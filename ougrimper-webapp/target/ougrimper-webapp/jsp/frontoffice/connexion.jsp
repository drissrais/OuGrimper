<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Connexion</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<section class="row">
			<div class="col-sm-offset-3 col-sm-6" id="connexion">
				<form class="well" id="loginForm" action="login">
					<legend>Accéder à votre compte</legend>
					<fieldset>
						<div class="form-group">
							<label for="email" class="control-label">Email <span class="required">*</span></label>
							<input id="email" type="email" name="email" class="form-control">
						</div>
						<div class="form-group has-feedback">
							<label for="password" class="control-label">Mot de passe <span class="required">*</span></label>
							<input id="password" name="password" type="password" class="form-control">
							<i class="glyphicon glyphicon-eye-open form-control-feedback"></i>
						</div>
						<s:actionerror/>
						<s:a class="btn btn-warning" type="submit" action="inscription">Créer un compte</s:a>
						<button class="btn btn-primary pull-right" type="submit">Suivant</button>
					</fieldset>
				</form>
			</div>
		</section>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jsp/script.js"></script>
	<script type="text/javascript">
		$('#password + .glyphicon').on('click', function() {
			// toggle our classes for the eye icon
			$(this).toggleClass('glyphicon-eye-close').toggleClass('glyphicon-eye-open');
			var input = $("#password");
			if (input.attr("type") === "password") {
				input.attr("type", "text");
			} else {
				input.attr("type", "password");
			}
		});
		
		$( "#loginForm" ).validate({
		  debug: false,
		  errorElement: "span",
		  errorClass: "help-block",
		  rules: {
		    email: {
		    	required: true,
		    	email: true
		    },
		    password: {
		    	required: true
		    }
		  }
		});
	</script>
</body>
</html>