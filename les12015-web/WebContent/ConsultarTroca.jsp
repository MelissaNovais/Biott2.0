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
		<link rel="stylesheet" href="CSS/Admin/GeralLivro.css">
		<link rel="stylesheet" href="CSS/Admin/ConsultarTroca.css">
		<link rel="icon" href = "Img/livro-icone.png">
		
		<title>Consultar Trocas - XINGLING</title>
	</head>
	<body>
		<c:import url="CabecalhoAdmin.jsp"/>
		
		<div class="panel panel-info">
			<div class="panel-heading panel-info">Trocas</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<input  id = "txtIdTroca" class="form-control" type="text" placeholder="Id da Troca">
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
							<label class= "nome-campos">Id da Compra:</label>
							<input id="txtIdCompra"disabled class="form-control nome-campos" type="text" placeholder="89745">	
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<label class= "nome-campos">Data da Solicitação de Troca:</label>
							<input id="txtDataCompra"disabled class="form-control nome-campos" type="text" placeholder="25/10/2017">	
						</div>
					</div>	
				</div>	
				<div class="row">
					<div class="col-md-12">
						<label class= "nome-campos">Motivo da Troca:</label>
						<textarea id="txtIdCompra"disabled class="form-control nome-campos" type="text">Comprei como um presente para meu amado neto, mas descobri que ele não sabe ler. Gostaria de trocar por um outro Livro. Obrigada, Gosto muito do site de vocês porque tem muito livro de Culinária, Parabéns</textarea>
					</div>
				</div>
				<div class="row" id="livro-troca">
					<c:import url="TabelaComUmLivro.jsp"/>
				</div>
	    	</div>
		</div>
		
		<c:import url= "RodapeAdmin.jsp"/>
	
	
	</body>
</html>