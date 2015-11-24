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


<c:import url="buscabicicletapartial.jsp"/>


<div class="container"  style="margin-top: 5%;width: 60%;">


<table class="table" >
	<tr>
		<th>Id</th>
		<th>Nome</th>
		<th>Descrição</th>
		<th>Nota</th>
		
			<th>Pecas</th>
		
			
	</tr>
		 <c:if test="${empty bicicletas}">
	     	<h3> Não há resultados </h3>
	      </c:if>
	


<c:forEach items="${bicicletas}" var="bicicleta">

				<tr id="tarefaDiv_${bicicleta.id}">
					<td>${bicicleta.id}</td>
					<td><a href="showbicicleta?id=${bicicleta.id}&cn=false">${bicicleta.nome}</a></td>


					<td>${bicicleta.descricao}</td>


					<td>${bicicleta.nota}</td>


					<td>



						<ul class="list-group">
							<li class="list-group-item list-group-item">Banco :
								${bicicleta.banco.nome}</li>
							<li class="list-group-item list-group-item">Guidão :
								${bicicleta.guidao.nome}</li>
							<li class="list-group-item list-group-item">Cambio:
								${bicicleta.cambio.nome}</li>
							<li class="list-group-item list-group-item">Quadro :
								${bicicleta.quadro.nome}</li>
							<li class="list-group-item list-group-item">Rodas :
								${bicicleta.rodas.nome}</li>
						</ul>

					</td>
				</tr>



			</c:forEach>

</table>

<a href="formbicicleta"><button >Monte sua bicicleta</button></a>

<br/>

<br/>

<a href="home">Voltar</a>

<br/>

</div>	

<br/>


<br/>
</body>
</html>