<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Liste des topos</title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<header class="page-header">
			<h1 id="topo-title">Tous les topos</h1>
			<span class="listTopo-span">Accédez à la liste des topos que nous avons répertorié pour vous.</span>
		</header>
		<section class="row">
			<s:iterator value="listTopo">
				<div class="col-xs-6 col-sm-6 col-md-4 topo">
					<h3>
						<s:a action="topo_detail" class="topo_name">
							<s:param name="id" value="id" />
							<s:property value="nom"/>
						</s:a>
					</h3>
					<s:property value="site.nom"/>  -  <s:property value="site.region"/>
					<div class="row">
						<div class="col-md-12">
							<s:a action="topo_detail">
								<s:param name="id" value="id" />
								<img title="<s:property value="nom"/>" src="<s:property value="plan"/>">
							</s:a>
						</div>
					</div>
				</div>
			</s:iterator>
		</section>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jsp/script.js"></script>
</body>
</html>