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
		
		<%	
			Cliente cliente = (Cliente) request.getAttribute("cliente");
			Resultado resultado = (Resultado) request.getAttribute("resultado");
			Cupom cupom = (Cupom) request.getAttribute("cupom");
		%>

        <c:import url= "CabecalhoCliente.jsp"/>
		
		<%-- Alert de terminar cadastro ou msg no caso de cadastros com dados respetidos e verificação de cupom --%>
		
		<c:if test="${empty cliente.enderecos }">
			<div class="alert alert-warning alert-dismissible" role="alert" id="alert-completar-cadastro">
			 	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				Quase lá! Complete seu Cadastro para Continuar
			</div>
		</c:if>
		
		<c:if test ="${not empty resultado.msg }">
			<div class="alert alert-warning alert-dismissible" role="alert" id="alert-completar-cadastro">
			 	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					${resultado.msg}
			</div>
		</c:if>
		
		<div class="espacamento"> </div>
	
		<%-- Se tiver endereços ja cadastrados aparece as opções 
				Se nao o dropdown nao aparece, soh os campos pra cadastro --%>
	
		<c:if test="${not empty cliente.enderecos }"> 
			<div class="btn-dropdown">
				<div class="btn-group">
					<button type="button" class="btn btn-success">Endereços</button>
					<button type="button"
						class="btn btn-success dropdown-toggle dropdown-toggle-split"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<span class="sr-only">Toggle Dropdown</span>
					</button>
					<div class="dropdown-menu">
						<c:forEach var="end" items ="${cliente.enderecos}">
							<a class="dropdown-item" href="#"> ${end.identificacao} </a>
						</c:forEach>
				
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Novo Endereco</a>
					</div>
				</div>
			</div>
		</c:if>
		
	
		<c:import url="Endereco.jsp" />
		
		<div class="espacamento"></div>
		
		<c:if test="${not empty cliente.cartoes}"> 
			<div class="btn-dropdown">
				<div class="btn-group">
					<button type="button" class="btn btn-success">Cartões</button>
					<button type="button"
						class="btn btn-success dropdown-toggle dropdown-toggle-split"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<span class="sr-only">Toggle Dropdown</span>
					</button>
					<div class="dropdown-menu">
						<c:forEach var="car" items = "${cliente.cartoes }">
							<a class="dropdown-item" href="#">$car.titular</a>
						</c:forEach>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="#">Novo Cartão</a>
					</div>
				</div>
			</div>
		</c:if>

	
		<c:import url="Cartao.jsp" />
		
		<div class="espacamento"> </div>
		
		<form action="ConsultarCupomCompra" method="post">	
			<div class="row">
				<div class="input-cupom col-md-2">
					<div class="form-group">
						<input id="txtIdCupom" name = "txtCodCupom" class="form-control" type="text"
							placeholder="Codigo do cupom promocional">
							
					</div>
				</div>	
			</div>
			<button 
				type="submit" class="form-control btn btn-success" 
					id="verificar-cumpom" name="operacao" value="CONSULTAR"> Aplicar Cupom
			</button>
		</form>
		
		<div class="form-group">
			<div >
				<a href="CompraFinalizada.jsp" id="btn-final-compra" class="form-control btn btn-success">Finalizar Compra </a> 
			</div>
		</div>

        <c:import url= "RodapeCliente.jsp"/>

    </body>
</html>