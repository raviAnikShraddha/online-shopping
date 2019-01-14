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
	case 'Manage Products':
		$('#manageProduct').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		$("#a_" + menu).addClass('active');
	}

	// to tackle the csrf token

	var token = $('meta[name="_csrf"]').attr("content");
	var header = $('meta[name="_csrf_header"]').attr("content");

	if (token.length > 0 && header.length > 0) {

		$(document).ajaxSend(function(e, xhr, options) {

			xhr.setRequestHeader(header, token);

		});
	}

	// code for jquery datatables

	$table = $('#productListTable');
	if ($table.length) {
		console.log('inside the table !');

		var jsonURL = '';
		if (window.categoryId == '') {
			jsonURL = window.contextRoot + '/jason/data/all/products';
		} else {
			jsonURL = window.contextRoot + '/jason/data/category/'
					+ window.categoryId + '/products';
		}

		$table
				.DataTable({
					lengthMenu : [ [ 3, 5, 10, -1 ],
							[ '3 Records', '5 Records', '10 Records', 'ALL' ] ],
					pageLength : 5,

					ajax : {
						url : jsonURL,
						dataSrc : ''

					},
					columns : [
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="' + window.contextRoot
											+ '/resources/images/' + data
											+ '.jpg" class="dataTableImg" />';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of stock!</span>'
									}
									return data;
								}
							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<a href="'
											+ window.contextRoot
											+ '/show/'
											+ data
											+ '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></span></a> &#160;';

									if (row.quantity < 1) {

										str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

									} else {

										str += '<a href="'
												+ window.contextRoot
												+ '/cart/add/'
												+ data
												+ '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

									}

									return str;
								}
							} ]
				});
	}

	// / DISMISSING THE ALERT AFTER 3 SECONDS

	var $alert = $('.alert');
	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000);
	}

	// -------------------------

	$('.switch input[type="checkbox"]')
			.on(
					'change',
					function() {
						var checkbox = $(this);
						var checked = checkbox.prop('checked');
						var dMsg = (checked) ? 'You want to activate the product?'
								: 'You want to deactivate the product?';
						var value = checkbox.prop('value');
						bootbox
								.confirm({
									size : 'medium',
									message : dMsg,
									callback : function(confirmed) {
										if (confirmed) {
											console.log(value);
											bootbox
													.alert({
														size : 'medium',
														message : 'You are going to perform an operation '
																+ value
													});
										} else {
											checkbox.prop('checked', !checked);
										}
									}

								});
					});

	// --------------------------------------------
	// data table for Admin
	// ---------------------------------------------

	// code for jquery datatables

	$adminProductsTable = $('#adminProductsTable');
	if ($adminProductsTable.length) {
		console.log('inside the table !');

		var jsonURL = '';

		jsonURL = window.contextRoot + '/jason/data/admin/all/products';

		$adminProductsTable
				.DataTable({
					lengthMenu : [ [ 10, 30, 50, -1 ],
							[ '10 Records', '30 Records', '50 Records', 'ALL' ] ],
					pageLength : 30,

					ajax : {
						url : jsonURL,
						dataSrc : ''

					},
					columns : [
							{
								data : 'id'
							},
							{
								data : 'code',
								mRender : function(data, type, row) {
									return '<img src="'
											+ window.contextRoot
											+ '/resources/images/'
											+ data
											+ '.jpg" class="adminDataTableImg" />';
								}
							},
							{
								data : 'name'
							},
							{
								data : 'brand'
							},
							{
								data : 'unitPrice',
								mRender : function(data, type, row) {
									return '&#8377; ' + data
								}
							},
							{
								data : 'quantity',
								mRender : function(data, type, row) {
									if (data < 1) {
										return '<span style="color:red">Out of stock!</span>'
									}
									return data;
								}
							},
							{
								data : 'active',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';
									str += '<label class="switch"> ';
									if (data) {
										str += '<input type="checkbox" value="'
												+ row.id + '" checked>';
									} else {
										str += '<input type="checkbox" value="'
												+ row.id + '" >';
									}
									str += '<span class="slider round"></span> </label>';
									return str;
								}

							},
							{
								data : 'id',
								bSortable : false,
								mRender : function(data, type, row) {

									var str = '';

									str += '<a href="'
											+ window.contextRoot
											+ '/manage/'
											+ data
											+ '/product" class="btn btn-primary"> <span class="glyphicon glyphicon-pencil"></span></a>';

									return str;
								}
							} ],
					initComplete : function() {

						var api = this.api();
						api
								.$('.switch input[type="checkbox"]')
								.on(
										'change',
										function() {
											var checkbox = $(this);
											var checked = checkbox
													.prop('checked');
											var dMsg = (checked) ? 'You want to activate the product?'
													: 'You want to deactivate the product?';
											var value = checkbox.prop('value');
											bootbox
													.confirm({
														size : 'medium',
														message : dMsg,
														callback : function(
																confirmed) {
															if (confirmed) {
																var ativationURL = window.contextRoot
																		+ '/manage/product/'
																		+ value
																		+ '/activation';
																$
																		.post(
																				ativationURL,
																				function() {
																					bootbox
																							.alert({
																								size : 'medium',
																								message : 'You are going to perform an operation '
																									+ value
																							});
																				});
															} else {
																checkbox
																		.prop(
																				'checked',
																				!checked);
															}
														}

													});
										});

					}
				});
	}

	// ----------------------------------------------

	// validation for category

	var $categoryForm = $('#categoryForm');

	if ($categoryForm.length) {

		$categoryForm
				.validate({

					rules : {
						name : {
							required : true,
							minlength : 2
						},
						description : {
							required : true
						}
					},
					messages : {

						name : {
							required : 'Please add  the category !',
							minlength : 'The category name should not be less than two characters !'
						},

						description : {
							required : 'Please add the description for the category !'
						}
					},
					errorElement : 'em',
					errorPlacement : function(error, element) {
						// add the class of help-block
						error.addClass('help-block');
						// add the error element after the input element
						error.insertAfter(element);
					}
				});
	}

	// ----------------------------------------------
	// validation for Login Form

	var $loginForm = $('#loginForm');

	if ($loginForm.length) {

		$loginForm.validate({

			rules : {
				username : {
					required : true,
					email : true
				},
				password : {
					required : true
				}
			},
			messages : {

				username : {
					required : 'Please enter the username  !',
					email : 'Please enter the valid email address !'
				},

				password : {
					required : 'Please enter the password !'
				}
			},
			errorElement : 'em',
			errorPlacement : function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				// add the error element after the input element
				error.insertAfter(element);
			}
		});
	}

});
