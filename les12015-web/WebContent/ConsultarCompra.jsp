<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	    <!-- Optional theme -->
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
		
		<link rel="stylesheet" href="CSS/Reset.css">
		<link rel="stylesheet" href="CSS/GeralSite.css">
		<link rel="stylesheet" href="CSS/Admin/ConsultarCompra.css">
		<link rel="icon" href = "Img/livro-icone.png">
		
		<title>Consultar Compra - XINGLING</title>
	</head>
	<body>
		<c:import url="CabecalhoAdmin.jsp"/>
		
		<form action="GerenciarEstoque" method="GET">
				
			<div class="panel  panel-info">
				<div class="panel-heading panel-info">Compra</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-3">
							<div class="form-group">
								<input  id = "txtIdCompra" class="form-control" type="text" placeholder="Id da Compra">
							</div>
						</div>
						<div class="col-md-3">
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-pesquisar">Pesquisar</button>
							</div>		
						</div>
					</div>
				</div>
			</div>
		</form>		
		
		
		<div class="panel panel-info " id="panel-resultado">
			<div class="panel-heading panel-info">Compra</div>
			<div class="panel-body">
                   	
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<label class= "nome-campos" >Id do Cliente:</label>
								<input id="txtIdCliente" disabled class="form-control nome-campos" type="text" placeholder="32146">
								
							</div>
						</div>
							
						<div class="col-md-4">
							<div class="form-group">
								<label class= "nome-campos">Valor Total R$</label>
								<input id="txtValorTotal"disabled class="form-control nome-campos" type="text" placeholder="150,00">	
							
							</div>
						</div>
							
						
						<div class="col-md-4">
							<div class="form-group">
								<label class= "nome-campos">Data da Compra:</label>
								<input id="txtDataCompra"disabled class="form-control nome-campos" type="text" placeholder="25/10/2017">	
							
							</div>
						</div>	
						
					</div>	
					<div class="row">
						<div class="col-md-8">
							<div class="form-group">
								<label class= "nome-campos" >Endereço de Entrega:</label>
								<input id="txtIdentificacaoEndereco" disabled class="form-control nome-campos" type="text" placeholder="Casa da Mamãe">
							
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<label class= "nome-campos">Forma de Pagamento:</label>
								<input id="txtPagamento"disabled class="form-control nome-campos" type="text" placeholder="********7899">	
							
							</div>
						</div>	
					</div>
					<div class="row">
						<div class="col-md-8">
						 	<label>Livros:</label>
						</div>
					</div>
					<div class="row">
						<c:import url="TabelaComUmLivro.jsp"/>
					</div>
					<div class="row">
						<c:import url="TabelaComUmLivro.jsp"/>
					</div>
					<div class="row">
						<c:import url="TabelaComUmLivro.jsp"/>
					</div>
					
              	</div>
		</div>
	
		<c:import url= "RodapeAdmin.jsp"/>
	
	
	</body>
</html>