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
			<div class="col-xs-4">
				<select class="form-control" onchange="redirect(this.value)">
					<option value="" selected disabled hidden>Pays</option>
					<s:iterator value="listPays">
						<option value='<s:property value="id" />'><s:property value="nom" /></option>
					</s:iterator>
				</select>
			</div>
			<div class="col-xs-4">
				<select class="form-control" onchange="redirectVille(this.value)">
					<option value="" selected disabled hidden>Ville plus proche</option>
					<s:iterator value="listVille">
						<option value='<s:property value="id" />'><s:property value="nom" /></option>
					</s:iterator>
				</select>
			</div>
			<div class="col-xs-4">
				<select class="form-control" onchange="redirectSite(this.value)">
					<option value="" selected disabled hidden>Site</option>
					<s:iterator value="listSite">
						<option value='<s:property value="id" />'><s:property value="nom" /></option>
					</s:iterator>
				</select>
			</div>
		</section>
		<header class="page-header">
			<s:actionmessage class="label-success actionMessage"/>
			<h1 id="site-title">Tous les sites d'escalade</h1>
			<span class="listSite-span">Accédez à la liste des sites d'escalade que nous avons
				répertorié pour vous.</span>
		</header>
		<section class="row">
			<s:iterator value="listSite">
				<div class="col-xs-6 col-sm-6 col-md-4 site">
					<h3>
						<s:a action="site_detail" class="site_name">
							<s:param name="id" value="id" />
							<s:property value="nom"/>
						</s:a>
					</h3>
					<s:property value="pays.nom"/>  -  <s:property value="region"/>
					<div class="row">
						<div class="col-md-12">
							<s:a action="site_detail">
								<s:param name="id" value="id" />
								<img title="<s:property value="nom"/>" src="<s:property value="photo"/>">
							</s:a>
						</div>
					</div>
				</div>
			</s:iterator>
		</section>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jsp/script.js"></script>
	<script type="text/javascript">
		function redirect(selectedValue){
		     window.location="site_list_pays.action?paysId="+selectedValue;
		}
		
		function redirectVille(selectedValue){
		     window.location="site_list_ville.action?villeId="+selectedValue;
		}
		
		function redirectSite(selectedValue){
		     window.location="site_detail.action?id="+selectedValue;
		}
		
		$(document).ready(function () {
			$("div.nav > li").removeClass("active");
			$('#spots').addClass('active');
		});
	</script>
</body>
</html>