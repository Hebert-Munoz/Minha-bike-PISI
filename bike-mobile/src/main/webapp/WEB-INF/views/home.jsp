<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bike Mobile</title>

<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/bootstrap/css/bootstrap.css.map"/>"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap-theme.min.css"/>"
	rel="stylesheet" />
<link
	href="<c:url value="/resources/bootstrap/css/bootstrap-theme.css.map"/>"
	rel="stylesheet" />

</head>
<body>
	<div class="container">

		<!-- <hr> -->


		<c:import url="/WEB-INF/views/menubar.jsp" />

		<div class="container bg-default">
			<div class="row">
				<h2 class="col-xs-12 text-center">Bem vindo!</h2>
			</div>
		</div>
	</div>
</body>
</html>