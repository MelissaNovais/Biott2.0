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
		<c:import url="CabecalhoAdmin.jsp"/>
		
		<form action="ConsultarCliente" method="post">
			<div class="panel panel-info ">
				<div class="panel-heading panel-info">Pesquisar Cliente</div>
				<div class="panel-body">
				<div class="row">
					<div class="col-md-2">
						<div class="form-group">
							<input  id = "txtIdCliente" class="form-control" type="text" placeholder="Id Cliente">
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<input  id = "txtNomeCliente" class="form-control" type="text" placeholder="Nome">
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<input  id = "txtNomeEmail" class="form-control" type="text" placeholder="E-mail">
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<input  id = "txtCpf" class="form-control" type="text" placeholder="CPF">
						</div>
					</div>
					
				</div>
				<div class="row">
					<div class="col-md-2">
						<div class="form-group">
							<input  id = "txtCep" class="form-control" type="text" placeholder="Cep">
						</div>
					</div>
					<div class="col-md-8">
						<div class="form-group">
							<input  id = "txtRua" class="form-control" type="text" placeholder="Rua">
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<input  id = "txtNumero" class="form-control" type="text" placeholder="Numero">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<input  id = "txtBairro" class="form-control" type="text" placeholder="Bairro">
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<input  id = "txtCidade" class="form-control" type="text" placeholder="Cidade">
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<input  id = "txtEstado" class="form-control" type="text" placeholder="Estado">
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="form-group">
							<input  id = "txtIdentificacaoEnd" class="form-control" type="text" placeholder="Identificacao do Endereço (Ex: Casa da Sogrinha)">
						</div>
					</div>
				</div>
					<button id= "operacao" type="submit"  name="operacao" value="SALVAR" 
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
                	<table class="table table-striped">
                    	<thead>
                        	<tr>
                          
                                <th scope="col">Id do cliente</th>
                                <th scope="col" > Confiança</th>
                                <th scope="col">Nome</th>
                                <th scope="col"  class="text-center" >Data de Cadastro</th>
                                <th scope="col"  class="text-center">Total já gasto no Site</th>
                               
                            </tr>
                     	</thead>
                        <tbody>
                                <!-- FOR DE Cleintes ENCONTRADOS AQUI -->
                               <tr>
                                    <td >6541</td>
                                    <td  ><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>		                
				                      	<i class="fa fa-star"  ></i>
				                   	</td>
		                             <td >Maria da Silva</td>
		                             <td  class="text-center" >25/03/2015</td>
		                             <td  class="text-center">R$ 320,00</td>
                                    
                                </tr>
                                <!-- ATÉ AQUI -->
                                
                      		</tbody>
                   		</table>
               		</div>
           		</div>
			</div>
		</div>
		
		<c:import url= "RodapeAdmin.jsp"/>
	
	
	</body>
</html>