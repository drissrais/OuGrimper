<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Sites d'escalade : liste des meilleurs spots d'escalade</title>
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
			<h1 id="site-title">Tous les sites d'escalade</h1>
			<span>Accédez à la liste des sites d'escalade que nous avons
				répertorié pour vous.</span>
		</header>
		<section class="row">
			<s:iterator value="listSite">
				<div class="col-xs-6 col-sm-6 col-md-4" id="site">
					<h3><s:a action=""><s:property value="nom"/></s:a></h3>
					<s:property value="pays.nom"/>  -  <s:property value="region"/>
					<div class="row">
						<div class="col-md-12">
							<s:a action="">
								<img alt="<s:property value="nom"/>" src="<s:property value="photo"/>">
							</s:a>
						</div>
					</div>
				</div>
			</s:iterator>
		</section>
	</div>
	<script type="text/javascript" src="../script.js"></script>
</body>
</html>