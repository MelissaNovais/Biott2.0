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
		<link rel="stylesheet" href="CSS/Admin/AtivarInativarLivro.css">
		<link rel="icon" href = "Img/livro-icone.png">
		
		<title>Reativar Livro - XINGLING</title>
	</head>
	<body>
		<c:import url="CabecalhoAdmin.jsp"/>
		
		<div class="panel panel-primary campos-cadastro-livro" >
			<div class="panel-heading panel-primary">Ativar Livro</div>
			
			<div class="panel-body">
				<form action="AtivarInativarLivro" method="GET">
					<div class="row">
						<div class="col-md-3">
							<div class="form-group">
								<input id="txtId" class="form-control" type="text" placeholder="Id Livro">
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary">Pesquisar</button>
				</form>
			</div>
		</div>
		<!-- Depois de Pesquisar  **********************-->	
		<form>
			<div class="panel-body">
				<c:import url="TabelaComUmLivro.jsp"/>
				<button type="submit" class="btn btn-primary btn-md btn-confirmar"  > 
					Confirmar Ativação</button>
			</div>
		</form>
		<!-- Depois de Confirmar que é esse msm  **********************-->	
		<form>
		<div class="panel panel-primary campos-cadastro-livro panel-ati-inativacao">
			<div class="panel-heading panel-primary">Ativar Livro</div>
			<div class="panel-body">
		 		<div class="row">
					<div class="col-md-4">
						<div class="form-group">
							<select class="form-control">
								<option value="" disabled selected>Motivo</option>
								<!-- Implementar JSP que inclui Categorias -->
							</select>
						</div>
					</div>
					<div class="col-md-8">
						<div class="form-group">
							<input id="txtDescricaoStatus" class="form-control" type="text" placeholder="Descrição">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="form-group">
								<button type="submit" class="btn btn-primary btn-md" > Confirmar Ativação</button>
						</div>
					</div>
				</div>
			</div>
		</div>
		</form>
	
		<c:import url= "RodapeAdmin.jsp"/>
	
	
	</body>
</html>