$(function() {
	// solving Active menu problem

	
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'Show All Products':
		$('#products').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		$("#a_" + menu).addClass('active');
	}

	// code for jquery datatables

	var products = [

	[ '1', 'ABC' ], [ '2', 'XYZ' ], [ '3', 'DER' ], [ '4', 'NJK' ],
			[ '5', 'JKH' ], [ '6', 'NMK' ], [ '7', 'RRE' ], [ '8', 'HGF' ],
			[ '9', 'SDD' ]];

	$table = $('#productListTable');
	if ($table.length) {
		console.log('inside the table !');
		$table.DataTable({
			lengthMenu : [ [ 3, 5, 10, -1 ],
					[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
			data : products
		});
	}
});
