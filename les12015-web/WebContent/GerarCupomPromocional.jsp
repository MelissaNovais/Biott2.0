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
		<link rel="stylesheet" href="CSS/Admin/GerarCupom.css">
		<link rel="icon" href = "Img/livro-icone.png">
		
		<title>Gerar Cupom - XINGLING</title>
	</head>
	<body>
		<c:import url="CabecalhoAdmin.jsp"/>
		<div class="panel panel-info panel-cupom">
		<div class="panel-heading panel-primary" id="panel-titulo">Cupons Promocionais</div>
		<div class="panel-body">

			<form action="" method="POST">
				
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<input id="txtIdCliente" class="form-control" type="text" placeholder="Id Cliente">
						</div>
					</div>
					<div class="col-md-4">
						<div class="form-group">
							<input id="txtMotivo Cupom" class="form-control" type="text" placeholder="Motivo (Ex: Cliente Fiel)">
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<input id="txtValorCupom" class="form-control" type="text" placeholder="Valor R$ ">
						</div>
					</div>		
					<div class="col-md-2">
						<div class="form-group">
							<button type="submit" class="btn btn-success btn-md ">Gerar Cupom</button>
						</div>
					</div>
				</div>
			</form>
			
		</div>
	</div>
	
			<h2 id="titulo-tabela">Clientes</h2>
		
			<div class="dropdown" id="btn-filtrar">
							<button class="btn btn-primary dropdown-toggle" type="button"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    	Filtrar Por
						  	</button>
						  	<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
						    	<a class="dropdown-item" href="#">Clientes mais Antigos</a>
						    	<a class="dropdown-item" href="#">Clientes que mais Compram </a>
						    	<a class="dropdown-item" href="#">Clientes de Confiança (Menos Trocas) </a>
						    	<a class="dropdown-item" href="#">Sorteio de Clientes</a>
						  	</div>
						</div>
			<div class="sublinhado"></div>
		
			<table class="table table-striped table-hover" id="div-compras">
				<thead>
				   	<tr>
				   		<th>Confiança</th>
				       	<th>Id do Usuario</th>
				       	<th class="text-center" >Data de Cadastro</th>
				       	<th class="text-center">Valor Total de Compras no Site</th>
					</tr>
				</thead>
				<tbody>
				   	<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >321654</td>
				       	<td class="text-center">12/10/2016</td>
				       	<td class="text-center" >R$ 1000,00</td>				      
					</tr>
						<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >654789</td>
				       	<td class="text-center">12/08/2017</td>
				       	<td class="text-center" >R$ 500,00</td>				       	
					</tr>
					<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >87465</td>
				       	<td class="text-center">12/10/2017</td>
				       	<td class="text-center">R$ 800,00</td>
				       	<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >321654</td>
				       	<td class="text-center">12/10/2016</td>
				       	<td class="text-center" >R$ 750,00</td>				      
					</tr>
						<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >654789</td>
				       	<td class="text-center">12/08/2017</td>
				       	<td class="text-center">R$ 600,00</td>				       	
					</tr>
					<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >87465</td>
				       	<td class="text-center">12/10/2017</td>
				       	<td class="text-center">R$ 450,00</td>
				  	</tr>
				  	<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >87465</td>
				       	<td class="text-center">12/10/2017</td>
				       	<td class="text-center" >R$ 200,00</td>
				       	<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >321654</td>
				       	<td class="text-center">12/10/2016</td>
				       	<td class="text-center" >R$ 800,00</td>				      
					</tr>
						<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >654789</td>
				       	<td class="text-center">12/08/2017</td>
				       	<td class="text-center" >R$ 640,00</td>				       	
					</tr>
						<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >321654</td>
				       	<td class="text-center">12/10/2016</td>
				       	<td class="text-center">R$ 4200,00</td>				      
					</tr>
						<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >654789</td>
				       	<td class="text-center">12/08/2017</td>
				       	<td class="text-center">R$ 650,00</td>				       	
					</tr>
					<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >87465</td>
				       	<td class="text-center">12/10/2017</td>
				       	<td class="text-center">R$ 420,00</td>
				       	<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >321654</td>
				       	<td class="text-center">12/10/2016</td>
				       	<td class="text-center">R$ 320,00</td>				      
					</tr>
						<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >654789</td>
				       	<td class="text-center">12/08/2017</td>
				       	<td class="text-center">R$ 190,00</td>				       	
					</tr>
					<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >87465</td>
				       	<td class="text-center">12/10/2017</td>
				       	<td class="text-center">R$ 198,00</td>
				  	</tr>
				  	<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >87465</td>
				       	<td class="text-center">12/10/2017</td>
				       	<td class="text-center">R$ 150,00</td>
				       	<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >321654</td>
				       	<td class="text-center">12/10/2016</td>
				       	<td class="text-center">R$ 100,00</td>				      
					</tr>
						<tr>
				       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
		                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
		                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i>
		                </td>
				       	<td >654789</td>
				       	<td class="text-center">12/08/2017</td>
				       	<td class="text-center">R$ 90,00</td>				       	
					</tr>
				</tbody>
			</table>
			<div class="paginancao">
				<nav aria-label="Page navigation ">
				  	<ul class="pagination justify-content-center">
				    	<li class="page-item"><a class="page-link" href="#">Anterior</a></li>
				    	<li class="page-item"><a class="page-link" href="#">1</a></li>
				    	<li class="page-item"><a class="page-link" href="#">2</a></li>
				    	<li class="page-item"><a class="page-link" href="#">3</a></li>
				    	<li class="page-item"><a class="page-link" href="#">4</a></li>
				    	<li class="page-item"><a class="page-link" href="#">5</a></li>
				    	<li class="page-item"><a class="page-link" href="#">Próximo</a></li>
				  	</ul>
				</nav>
		</div>
	
		<c:import url= "RodapeAdmin.jsp"/>
	
	
	</body>
</html>