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
		
		<link rel="icon" href = "Img/livro-icone.png">
		
		<title>Cadastrar Livro - XINGLING</title>
	</head>
	<body>
		<c:import url="CabecalhoAdmin.jsp"/>
		
		<div class="panel panel-primary campos-cadastro-livro">
			<div class="panel-heading panel-primary">Cadastrar Livro</div>
			<div class="panel-body">
	
				<form action="SalvarLivro" method="post">
	
					<c:import url="CamposLivro.jsp" />
					
					<button id= "operacao" type="submit"  name="operacao" value="SALVAR" 
						class="btn btn-primary">Salvar</button>
					
				</form>
				
			</div>
		</div>
	
		<c:import url= "RodapeAdmin.jsp"/>
	
	
	</body>
</html>