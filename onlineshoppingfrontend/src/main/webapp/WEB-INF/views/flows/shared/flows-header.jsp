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
		<%@include file="flows-navbar.jsp"%>

		<!-- Page Content -->
		<div class="content" style="margin-top: 2%;">