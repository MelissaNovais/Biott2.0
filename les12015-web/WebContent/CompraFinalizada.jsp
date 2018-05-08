<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Compra Finalizada - XINGLING</title>
        <link rel="stylesheet" href="CSS/Reset.css">
        <link rel="stylesheet" href="CSS/GeralSite.css">
        <link rel="stylesheet" href="CSS/Cliente/CompraFinalizada.css">
        <link rel="icon" href = "Img/livro-icone.png">
    </head>
    <body>

        <c:import url= "CabecalhoCliente.jsp"/>

		<div class="alert alert-success text-center" role="alert" id="alert-sucesso">
			Parabéns! Você Acaba de Realizar seu Pedido com Sucesso! 
			<br/>
			Você pode Acompanhar sua Compra pelo <a href="Perfil.jsp" class="alert-link">Perfil </a>
			<br/>
	  		<a href="Home.jsp" class="alert-link">Voltar </a>
  		
		</div>
	
        <c:import url= "RodapeCliente.jsp"/>

    </body>
</html>