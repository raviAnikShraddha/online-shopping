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
});

