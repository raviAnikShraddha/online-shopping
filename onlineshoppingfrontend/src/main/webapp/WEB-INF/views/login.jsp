<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Datatable Bootstrap CSS -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">

<!-- Bootstrap theme CSS -->
<link href="${css}/bootstrap-pulse-theme.css" rel="stylesheet">
<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

<!-- glyphicon css -->
<link href="${css}/glyphicon.css" rel="stylesheet">

<!-- thumbnail css -->
<link href="${css}/thumbnail.css" rel="stylesheet">

<!-- panel css -->
<link href="${css}/panel.css" rel="stylesheet">




<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>
</head>
<body>
	<div class="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
			<div class="container" style="height: 50px;">
				<a class="navbar-brand" href="${contextRoot}/home">Online
					Shopping</a>
			</div>
		</nav>

		<!-- Page Content -->
		<div class="content" style="margin-top: 3%;">
			<c:if test="${not empty message}">
				<div class="row">
					<div class="offset-md-3 col-md-6">
						<div class="alert alert-danger">${message}</div>
					</div>
				</div>
			</c:if>
			<div class="offset-md-4 col-md-4">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4>Login</h4>
					</div>
					<div class="panel-body">
						<form action="${contextRoot}/login" method="POST"
							class="form-horizontal" id="loginForm">
							<div class="form-group">
								<div class="row">
									<label class="col-md-3" for="name">UserName:</label>
									<div class="col-md-9">
										<input type="text" placeholder="UserName" name="username"
											id="username" class="form-control" />
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="row">
									<label class="col-md-3" for="name">Password:</label>
									<div class="col-md-9">
										<input type="text" placeholder="Password" name="password"
											id="password" class="form-control" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="offset-md-3 col-md-10">
									<input type="submit" value="Login" id="submit"
										class="btn btn-primary" />
								</div>
								<input type="hidden" name="${_csrf.parameterName}"
									value="${_csrf.token}" />
							</div>

						</form>
					</div>
					<div class="panel-footer">
						<div class="text-right">
							NEW USER - <a href="${contextRoot}/register">Register Here</a>

						</div>

					</div>
				</div>
			</div>

		</div>

		<!-- /.container -->
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<script src="${js}/myapp.js"></script>

		<script src="${js}/jquery.validate.js"></script>
		<script src="${js}/jquery.validate.min.js"></script>
	</div>
</body>

</html>
