<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Client Profile</title>

<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css"
	var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Client Profile</a>
		</div>
	</div>
</nav>

<div class="jumbotron">
	<div class="container">
		<h1>${title}</h1>
		<a href="/Spring/hello/Style">Profile</a>
		<br><br> 
		<a href="/Spring/measurementForm">Measurements</a>
	</div>
</div>

<div class="container">

	<div class="row">
			<form:form method="POST" action="/Spring/measurementDetails" modelAttribute="measurement" >
			Neck : <input type="text" name="neck" value="11"> 
			<br><br> 
			Sleeve : <input type="text" name="sleeve" value="12">
			<br><br>
			Chest : <input type="text" name="chest" value="13"> 
			<br><br>
			Waist : <input type="text" name="waist" value="32">
			<br><br> 
			<input type="submit" value="Submit">
			</form:form>
	</div>


	<hr>
	<footer>
		<p>&copy; MyStyle.com 2015</p>
	</footer>
</div>

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js"
	var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>