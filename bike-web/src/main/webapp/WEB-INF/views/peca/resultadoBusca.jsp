<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bike Web</title>

<link href="<c:url value="/resources//bootstrap/css/bootstrap.min.css"/>" rel="stylesheet"/>

</head>
<body>

<c:import url="/WEB-INF/views/menubar.jsp"/>

<c:import url="buscapecapartial.jsp"/>

<div class="container"  style="margin-top: 5%;width: 60%;">


<table class="table" >
	<tr>
		<th>Id</th>
		<th>Nome</th>
		<th>Marca</th>
		<th>Peça</th>
		<th>Descrição</th>
		
		
			
	</tr>
		 <c:if test="${empty pecas}">
	     	<h3> Não há resultados </h3>
	      </c:if>
	


<c:forEach items="${pecas}" var="peca">

	<tr id="tarefaDiv_${peca.id}">
		<td>${peca.id}</td>
		<td><a href="detalhepeca?id=${peca.id}">${peca.nome}</a></td>
		
		
		
		<td>${peca.marca}</td>
		
		
		<td>${peca.tipo}</td>
		
		
		<td>${peca.descricao}</td>
	
      	
      	
   
	</tr>



</c:forEach>

</table>

<a href="formpeca"><button >Cadastrar Mais Peças</button></a>

<br/>

<br/>

<a href="home">Voltar</a>

</div>	

</body>
</html>