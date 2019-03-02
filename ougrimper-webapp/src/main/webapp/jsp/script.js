/**
 * 
 */

$('#site_dropdown').mouseover(function() {
	$(this).dropdown('toggle');
});

$('#admin_dropdown').mouseover(function() {
	$(this).dropdown('toggle');
});

$('[data-toggle="confirmation"]').confirmation();