<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Avis sur <s:property value="site.nom"/></title>
</head>

<body>
	<%@ include file="../_include/header.jsp"%>
	<div class="container">
		<div class="row">
			<section class="col-sm-12 table-responsive">
				<div class="panel panel-primary">
					<table class="table table-striped table-condensed">
						<div class="panel-heading">
							<h3 class="panel-title">
								Avis sur le site
								<s:property value="site.nom" />
							</h3>
						</div>
						<thead>
							<tr>
								<th>Membre</th>
								<th>Avis</th>
								<th>Date</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="listCommentaire">
								<tr>
									<td><i class="fa fa-user"></i> <s:property
											value="redacteur.pseudo" /> <s:text name=" : "></s:text></td>
									<td><s:property value="contenu" /></td>
									<td><s:property value="date" /></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
			</section>
		</div>
	</div>
</body>
</html>