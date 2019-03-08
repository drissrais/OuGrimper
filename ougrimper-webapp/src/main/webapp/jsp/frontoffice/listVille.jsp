<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Sites escalade par ville plus proche</title>
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
			<h1 id="site-title">Sites d'escalade par ville plus proche</h1>
			<span class="listSite-span">
				Retrouvez la présentation du site d'escalade dans la ville à proximité de votre choix.
			</span>
		</header>
		<section class="row">
			<div class="col-sm-4">
				<ul class="list-group list-inline">
					<s:iterator value="listVille">
						<s:a action="site_list_ville" class="list-group-item">
      						<s:property value="nom" />
      						<s:param name="villeId" value="id" />
  						</s:a>
					</s:iterator>
				</ul>
			</div>
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
	</script>
</body>
</html>