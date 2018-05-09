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
		<link rel="stylesheet" href="CSS/Admin/ConsultarCliente.css">
		<link rel="icon" href = "Img/livro-icone.png">
		
		<title>Consultar Cliente - XINGLING</title>
	</head>
	<body>
	
		<%	
			List<Cliente> clientes = new ArrayList<Cliente>();
			clientes = (ArrayList<Cliente>) request.getAttribute("clientes");
		%>
		
		
		<c:import url="CabecalhoAdmin.jsp"/>
		
		<form action="ConsultarCliente" method="post">
			<div class="panel panel-info ">
				<div class="panel-heading panel-info">Pesquisar Cliente</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-2">
							<div class="form-group">
								<input  id = "txtId" name = "txtId" class="form-control" type="text" placeholder="Id Cliente">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<input  id = "txtNome" name = "txtNome" class="form-control" type="text" placeholder="Nome">
							</div>
						</div>
						<div class="col-md-4">
							<div class="form-group">
								<input  id = "txtEmail" name = "txtEmail" class="form-control" type="text" placeholder="E-mail">
							</div>
						</div>
						<div class="col-md-2">
							<div class="form-group">
								<input  id = "txtCpf"  name = "txtCpf" class="form-control" type="text" placeholder="CPF">
							</div>
						</div>
					</div>

					<button id= "operacao" type="submit"  name="operacao" value="CONSULTAR" 
						class="btn btn-primary">Pesquisar</button>
				</div>
			</div>
		</form>
		
		<div class= "titulo-tipo-tabela">
			<h2>Resultados</h2>
			<div class="sublinhado"></div>
		</div>
		
		<div class="container mb-4 " >
			<div class="row">
				<div class="col-12">
					<div class="table-responsive tabela-resultados">
	                	<table class="table table-striped table-hover">
	                    	<thead>
	                        	<tr>
	                          		<th scope="col">Id do cliente</th>
	                                <th scope="col" > Nome</th>
	                                <th scope="col">E-mail</th>
	                                <th scope="col">CPF</th>
	                                <th scope="col"  class="text-center" >Data de Cadastro</th>
	                         	</tr>
	                     	</thead>
	                        <tbody>
		                        <c:forEach var="c" items="${clientes}">
		                        	<tr>
		                                    <td> ${c.id} </td>
		                                    <td> ${c.nome} </td>
		                                    <td> ${c.email} </td>
		                                    <td> ${c.cpf} </td>
				                             <td  class="text-center" >25/03/2015</td>
		                                </tr>
		                        </c:forEach>
	                                
	                      	</tbody>
	                   	</table>
	               	</div>
	           	</div>
			</div>
		</div>
		
		<c:import url= "RodapeAdmin.jsp"/>
	
	
	</body>
</html>