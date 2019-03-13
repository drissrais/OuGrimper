<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../_include/head.jsp"%>
<title>Sites d'escalade <s:property value="ville.nom" /></title>
</head>
<body>
	<div class="container">
		<%@ include file="../_include/header.jsp"%>
		<section class="row recherche">
			<div class="col-xs-4">
				<select id="selectPays" class="form-control" onchange="redirect(this.value)">
					<option value="" selected disabled hidden>Pays</option>
					<s:iterator value="listPays">
						<option value='<s:property value="id" />'><s:property
								value="nom" /></option>
					</s:iterator>
				</select>
			</div>
			<div class="col-xs-4">
				<select id="selectVille" class="form-control" onchange="redirectVille(this.value)">
					<option value="" selected disabled hidden>Ville plus
						proche</option>
					<s:iterator value="listVille">
						<option value='<s:property value="id" />'><s:property
								value="nom" /></option>
					</s:iterator>
				</select>
			</div>
			<div class="col-xs-4">
				<select id="selectSite" class="form-control" onchange="redirectSite(this.value)">
					<option value="" selected disabled hidden>Site</option>
					<s:iterator value="listSite">
						<option value='<s:property value="id" />'><s:property
								value="nom" /></option>
					</s:iterator>
				</select>
			</div>
		</section>
		<div id="load" align="center">
			<img src="${pageContext.request.contextPath}/jsp/images/loading.gif"
				width="28" height="28" /> Loading...
		</div>
		<header id="header" class="page-header">
			<h1 id="site-title">
				Sites escalade
				<s:property value="ville.nom" />
			</h1>
			<span class="listSite-span">Retrouvez ici notre sélection des
				sites d'escalade à proximité de la ville : <s:property value="ville.nom" />
			</span>
		</header>
		<section id="sectionSite" class="row">
			<s:iterator value="listSiteVille">
				<div class="col-xs-6 col-sm-6 col-md-4 site">
					<h3>
						<s:a action="site_detail" class="site_name">
							<s:param name="id" value="id" />
							<s:property value="nom" />
						</s:a>
					</h3>
					<s:property value="pays.nom" />
					-
					<s:property value="region" />
					<div class="row">
						<div class="col-md-12">
							<s:a action="site_detail">
								<s:param name="id" value="id" />
								<img title="<s:property value="nom"/>"
									src="<s:property value="photo"/>">
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
		function redirect(selectedValue) {
			// URL de l'action AJAX
			var url = "<s:url action='ajax_site_list_pays'/>";
			// Paramètres de la requête AJAX
			var params = {
				paysId : selectedValue
			};
			// alert(selectedValue);
			// Action AJAX en POST
			jQuery
					.post(
							url,
							params,
							function(data) {
								// alert(data);
								var $selectVille = jQuery("#selectVille");
								var $selectSite = jQuery("#selectSite");
								var $header = jQuery("#header");
								var $sectionSite = jQuery("#sectionSite");
								$selectVille.empty();
								$selectSite.empty();
								$header.empty();
								$sectionSite.empty();
	
								$selectVille.append(jQuery("<option>").attr(
										'disabled', 'disabled').attr(
										'selected', 'selected').append(
										"Villes plus proches"));
								jQuery.each(data.listVille, function(key, val) {
									$selectVille.append(jQuery("<option>")
											.text(val.nom).val(val.id));
								});
	
								$selectSite
										.append(jQuery("<option>").attr(
												'disabled', 'disabled').attr(
												'selected', 'selected').append(
												"Sites"));
								jQuery.each(data.listSitePays, function(key,
										val) {
									$selectSite.append(jQuery("<option>").text(
											val.nom).val(val.id));
								});
	
								$header
										.append('<h1 id="site-title">Sites escalade '
												+ data.pays.nom + '</h1>');
								if (data.pays.nom == "Maroc") {
									$header.append(jQuery("<span>").attr(
											'class', 'listSite-span').append(
											'Retrouvez ici notre sélection des sites d&#39;escalade au '
													+ data.pays.nom + '.'));
								} else {
									$header.append(jQuery("<span>").attr(
											'class', 'listSite-span').append(
											'Retrouvez ici notre sélection des sites d&#39;escalade en '
													+ data.pays.nom + '.'));
								}
	
								jQuery
										.each(
												data.listSitePays,
												function(key, val) {
													$sectionSite
															.append("<div class='col-xs-6 col-sm-6 col-md-4 site'><h3><a href='site_detail?id="
																	+ val.id
																	+ "' class='site_name'>"
																	+ val.nom
																	+ "</a></h3>"
																	+ val.pays.nom
																	+ " - "
																	+ val.region
																	+ "<div class='row'><div class='col-md-12'><a href='site_detail?id="
																	+ val.id
																	+ "' class='site_name'><img title="+val.nom+" src="+val.photo+" />	</a></div></div></div>");
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
	
		function redirectVille(selectedValue) {
			// URL de l'action AJAX
			var url = "<s:url action='ajax_getPaysByVilleId'/>";
			
			// Paramètres de la requête AJAX
			var params = {
				villeId : selectedValue
			};
			
			// Action AJAX en POST
			jQuery.post(url, params, function(data) {
					$("#selectPays option:contains(" + data.nom + ")").attr("selected", "selected");
					getListSite();
			});
		}
		
		function getListSite() {
			// URL de l'action AJAX
			var url = "<s:url action='ajax_site_list_ville'/>";
						
			var paysId = jQuery("#selectPays").val();
			var villeId = jQuery("#selectVille").val();
	
			// Paramètres de la requête AJAX
			var params = {
				villeId : villeId,
				paysId : paysId
			};
						
			// Action AJAX en POST
			jQuery.post(url, params, function(data) {
				// alert(data);
				var $selectSite = jQuery("#selectSite");
				var $header = jQuery("#header");
				var $sectionSite = jQuery("#sectionSite");
				$selectSite.empty();
				$header.empty();
				$sectionSite.empty();
	
				$selectSite.append(jQuery("<option>").attr(
					'disabled', 'disabled').attr(
					'selected', 'selected').append("Sites"));
				jQuery.each(data.listSiteVille, function(key,
						val) {
					$selectSite.append(jQuery("<option>").text(
							val.nom).val(val.id));
				});
	
				$header
						.append('<h1 id="site-title">Sites escalade '
								+ data.ville.nom + '</h1>');
				$header.append(jQuery("<span>").attr('class',
						'listSite-span').append(
						'Retrouvez ici notre sélection des sites d&#39;escalade à proximité de la ville : '
								+ data.ville.nom + '.'));
	
				jQuery
						.each(
								data.listSiteVille,
								function(key, val) {
									$sectionSite
											.append("<div class='col-xs-6 col-sm-6 col-md-4 site'><h3><a href='site_detail?id="
													+ val.id
													+ "' class='site_name'>"
													+ val.nom
													+ "</a></h3>"
													+ val.pays.nom
													+ " - "
													+ val.region
													+ "<div class='row'><div class='col-md-12'><a href='site_detail?id="
													+ val.id
													+ "' class='site_name'><img title="+val.nom+" src="+val.photo+" />	</a></div></div></div>");
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