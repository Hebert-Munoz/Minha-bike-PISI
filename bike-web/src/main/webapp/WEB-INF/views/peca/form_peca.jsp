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

<form action="CadastraPeca" method="post">


	
Nome :<input type="text" class="form-control" name="nome" placeholder="Nome da peça">
<br/>


Marca: <input type="text" class="form-control" name="marca" placeholder="Marca da peça">


<br/>
Peça: 


  <select class="form-control" id="sel1" name="tipo">
    <option>Selecione o tipo da peça</option>
    <option value="Guidao">Guidão</option>
    <option>Quadro</option>
    <option>Banco</option>
    <option>Rodas</option>
    <option>Cambio</option>
  </select>





<br/>
Descrição: <textarea  name="descricao" class="form-control" rows="5"  placeholder="Descreva a peça aqui" ></textarea>

	




<br/>

<input type="submit" class="btn btn-default" value="Cadastrar"></input>

</form>

<br/>

<a href="home">Voltar</a>

<br/>

</div>
</body>
</html>