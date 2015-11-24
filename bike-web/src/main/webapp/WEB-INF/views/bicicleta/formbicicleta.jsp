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


<div class="container"  style="margin-top: 5%;width: 40%;">


<form action="cadastrabicicleta" method="post">


	
Nome :<input type="text" class="form-control" name="nome" placeholder="Nome da Bicicleta">
<br/>
<br/>
Descrição: <textarea  name="descricao" class="form-control" rows="5"  placeholder="Descreva sua bicicleta aqui" ></textarea>





<br/>
Nota: 


  <select class="form-control" id="sel1" name="nota">
    <option>De uma nota</option>
    <option>1</option>
    <option>2</option>
    <option>3</option>
    <option>4</option>
    <option>5</option>
  </select>


<br/>

<div>


<c:forEach items="${bancos}" var="banco">

<div class="radio">


  Banco: <label><input type="radio"  value="${banco.id}"  name="bancoId">${banco.nome}</label><a  style="margin-left: 5%"  href="detalhepeca?id=${banco.id}"> Visualizar</a>


</c:forEach>

</div>	

<hr>

<div>
<c:forEach items="${rodas}" var="roda">

<div class="radio">


  Roda: <label><input type="radio"  value="${roda.id}"  name="rodasId">${roda.nome}</label><a style="margin-left: 5%"  href="detalhepeca?id=${roda.id}"> Visualizar </a>
</div>


</c:forEach>

</div>	

<hr>

<div>
<c:forEach items="${guidaos}" var="guidao">

<div class="radio">


  Guidão: <label><input type="radio"  value="${guidao.id}"  name="guidaoId">${guidao.nome}</label><a style="margin-left: 5%"  href="detalhepeca?id=${guidao.id}"> Visualizar </a>
</div>


</c:forEach>

</div>	

<hr>

<div>
<c:forEach items="${quadros}" var="quadro">

<div class="radio">


  Quadro: <label><input type="radio"  value="${quadro.id}"  name="quadroId">${quadro.nome}</label><a  style="margin-left: 5%"  href="detalhepeca?id=${quadro.id}">Visualizar</a>
</div>


</c:forEach>

</div>	

<hr>

<div>
<c:forEach items="${cambios}" var="cambio">

<div class="radio">


  Cambio: <label><input type="radio"  value="${cambio.id}"  name="cambioId">${cambio.nome}</label><a style="margin-left: 5%"  href="detalhepeca?id=${cambio.id}">Visualizar</a>
</div>


</c:forEach>

</div>	

<hr>



<br/>

<input type="submit" class="btn btn-default" value="Cadastrar"></input>

</form>

<br/>

<br/>


<a href="home">Voltar</a>

</div>


<br/>


</body>
</html>