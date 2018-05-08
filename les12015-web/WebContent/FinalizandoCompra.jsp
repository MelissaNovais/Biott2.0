<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Finalizando Compra - XINGLING</title>
        <link rel="stylesheet" href="CSS/Reset.css">
        <link rel="stylesheet" href="CSS/GeralSite.css">
        <link rel="stylesheet" href="CSS/Cliente/FinalizandoCompra.css">
        <link rel="stylesheet" href="CSS/Cliente/Endereco.css">
        <link rel="stylesheet" href="CSS/Cliente/Cartao.css">
        <link rel="icon" href = "Img/livro-icone.png">
    </head>
    <body>

        <c:import url= "CabecalhoCliente.jsp"/>
		
		<div class="espacamento">
		</div>
	
		<%-- Digitar cupom --%>
	
		<div class="btn-dropdown">
			<div class="btn-group">
				<button type="button" class="btn btn-success">Endereco</button>
				<button type="button"
					class="btn btn-success dropdown-toggle dropdown-toggle-split"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<span class="sr-only">Toggle Dropdown</span>
				</button>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Endereco da Mamae</a>
	
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Novo Endereco</a>
				</div>
			</div>
		</div>
		<%-- Escolher CartÃ£o (PadrÃ£o no padrÃ£o) --%>
		<c:import url="Endereco.jsp" />
		
		<div class="espacamento">
		</div>
		
		<div class="btn-dropdown">
			<div class="btn-group">
				<button type="button" class="btn btn-success">Cartao</button>
				<button type="button"
					class="btn btn-success dropdown-toggle dropdown-toggle-split"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					<span class="sr-only">Toggle Dropdown</span>
				</button>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">Nome do Titular</a>
	
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Novo Cartão</a>
				</div>
			</div>
		</div>

		<%-- Escolher Endereçoo (Padrão no padrão) --%>
	
		<c:import url="Cartao.jsp" />
		
		<div class="espacamento">
		</div>
		
		<div class="row">
			<div class="input-cupom col-md-2">
				<div class="form-group">
					<input id="txtCupom" class="form-control" type="text"
						placeholder="Codigo do cupom promocional">
						
				</div>
			</div>	
		</div>
		<button 
			type="submit" class="form-control btn btn-success"name="submit" id="verificar-cumpom">Verificar Cupom
		</button>
	
		<div class="form-group">
			<div >
				<a href="CompraFinalizada.jsp" id="btn-final-compra" class="form-control btn btn-success">Finalizar Compra </a> 
			</div>
		</div>

        <c:import url= "RodapeCliente.jsp"/>

    </body>
</html>