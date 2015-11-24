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

<h1>Peca ${peca.nome} Cadastrada com sucesso</h1>


<h2>Detalhes</h2>

<div>



<h3 style="display: inline;">Nome</h3><h3 style="display: inline;" >${peca.nome}</h3>

</div>



<div>

<h3>Tipo</h3><h3 style="display: inline;" >${peca.tipo}</h3>

</div>


<div>




<h3>Marca</h3><h3 style="display: inline;" >${peca.marca}</h3>

</div>


<div>

<h3>Descricao</h3><h3 style="display: inline;" >${peca.descricao}</h3>


</div>






</body>
</html>