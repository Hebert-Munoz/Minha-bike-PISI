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

<%-- <link href="<c:url value="/resources//bootstrap/css/bootstrap.min.css"/>" rel="stylesheet"/> --%>
<%-- <link href="<c:url value="/resources/gridiculous/gridiculous.css"/>" rel="stylesheet" /> --%>

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
		<c:import url="/WEB-INF/views/menubar.jsp" />
		<%-- 	<c:import url="buscapecapartial.jsp" /> --%>
		<table class="table">
			<tr class="row">
				<th class="col-xs-1"></th>
				<th class="col-xs-2">Id</th>
				<th class="col-xs-2">Nome</th>
				<th class="col-xs-2">Marca</th>
				<th class="col-xs-2">Peça</th>
				<th class="col-xs-2">Descrição</th>
				<th class="col-xs-1"></th>
			</tr>

			<c:if test="${empty pecas}">
				<div class="row">
					<h3 class="c12">Não há resultados</h3>
				</div>
			</c:if>
			<c:forEach items="${pecas}" var="peca">
				<tr class="row" id="tarefaDiv_${peca.id}">
					<td class="col-xs-1"></td>
					<td class="col-xs-2">${peca.id}</td>
					<td class="col-xs-2">${peca.nome}</td>
					<td class="col-xs-2">${peca.marca}</td>
					<td class="col-xs-2">${peca.tipo}</td>
					<td class="col-xs-2">${peca.descricao}</td>
					<td class="col-xs-1"></td>
				</tr>
			</c:forEach>
		</table>
		<!-- 		<a href="formpeca"><button>Cadastrar Mais Peças</button></a> <br /> <br /> -->
		<a href="home"><button class="pull-right btn btn-default">Voltar</button></a>
	</div>
	<br />
	<br />
</body>
</html>