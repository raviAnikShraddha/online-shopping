<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container" style="height: 50px;">
		<a class="navbar-brand" href="${contextRoot}/home">Online Shopping</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item" id="home"><a class="nav-link"
					href="${contextRoot}/home">Home <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item" id="about"><a class="nav-link"
					href="${contextRoot}/about">About</a></li>
				<li class="nav-item" id="products"><a class="nav-link"
					href="${contextRoot}/show/all/products">View Products</a></li>
				<li class="nav-item" id="contact"><a class="nav-link"
					href="${contextRoot}/contact">Contact</a></li>
				<security:authorize access="hasAuthority('ADMIN')">
					<li class="nav-item" id="manageProduct"><a class="nav-link"
						href="${contextRoot}/manage/products">Manage Products</a></li>
				</security:authorize>
			</ul>

			<ul class="navbar-nav ml-auto" align="right">
				<security:authorize access="isAnonymous()">
					<li class="nav-item" id="register"><a class="nav-link"
						href="${contextRoot}/register">Sign up</a></li>
					<li class="nav-item" id="login"><a class="nav-link"
						href="${contextRoot}/login"><span
							class="glyphicon glyphicon-user"></span></a></li>
				</security:authorize>

				<security:authorize access="isAuthenticated()">
					<li class="dropdown"><a
						class="btn btn-default dropdown-toggle" id="dropdownMenu1"
						data-toggle="dropdown"> ${userModel.fullName}<span
							class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<security:authorize access="hasAuthority('USER')">
								<li style="margin-left: 20px"><a href="${contextRoot}/cart">
										<span class="glyphicon glyphicon-shopping-cart"></span> <span
										class="badge">${userModel.cart.cartLines}</span> - &#8377;
										${userModel.cart.grandTotal}
								</a></li>
								<li class="dropdown-divider" role="separator"></li>
							</security:authorize>
							<li style="margin-left: 20px"><a
								href="${contextRoot}/perform-login">Logout</a></li>
						</ul></li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>
<script>
	window.userRole = '${userModel.role}';
</script>