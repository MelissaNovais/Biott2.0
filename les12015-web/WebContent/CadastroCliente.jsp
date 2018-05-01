<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login - XINGLING</title>
	<link rel="stylesheet" href="css/Reset.css">
	<link rel="stylesheet" href="css/GeralSite.css">
	<link rel="stylesheet" href="css/Login.css">
	<link rel="icon" href = "Img/livro-icone.png">
</head>
<body>
	
	<%	
		Resultado resultado = (Resultado) request.getAttribute("resultado");
	%>
	
	<c:import url= "CabecalhoCliente.jsp"/>
	
	<c:if test="${not empty resultado}">
	
		<div class="alert alert-danger text-center" role="alert" id="alert-sucesso">
			${resultado.msg}
	  		<br/>
		</div>
	</c:if>
	<div>
		<div class="container container-login">
	    	<div class="info">
	      		<h1>Cadastrar</h1>
	    	</div>
	  	</div>
	  	<div class="form">
	    	<div class="thumbnail">
	      		<img src="Img/livro-icone.png">
	    	</div>
	    	<form action="SalvarCliente" method="post">
		    	<input type="text" class="form-control" name="txtNome" id="txtNome" placeholder="Nome Completo" />
		    	<input type="text" class="form-control" name="txtCpf" id="txtCpf" placeholder="CPF" />
		    	<input type="text" class="form-control" name="txtEmail" id="txtEmail" placeholder="Email" />
		    	<input type="password" class="form-control" name="txtSenha" id="txtSenha" placeholder="Senha"  />
		    	<input type="password" class="form-control" name="txtConfSenha" id="txtConfSenha" placeholder="Confirmar Senha" />

		   		<button class = "btn " id= "operacao" type="submit" name="operacao" value="SALVAR"  style="color: #FFF;" >Cadastrar </button> 
		   	</form>
		   		<p class="message">J� tem uma conta? <a href="Login.jsp">Fa�a login</a></p>
	  	</div>
  	</div>
	<c:import url= "RodapeCliente.jsp"/>
	
</body>
</html>
