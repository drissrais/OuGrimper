/**
 * 
 */

// $('#site_dropdown').mouseover(function() {
// $(this).dropdown('toggle');
// });
//
// $('#admin_dropdown').mouseover(function() {
// $(this).dropdown('toggle');
// });
$('[data-toggle="confirmation"]').confirmation();

$(function() {
	$('i[class="far fa-edit"]').tooltip({
		placement : 'left'
	});
});

$(function() {
	$('i[class="fas fa-trash-alt"]').tooltip({
		placement : 'left'
	});
});
