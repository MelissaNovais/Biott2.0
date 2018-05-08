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
		<link rel="stylesheet" href="CSS/Admin/Trocas.css">
		<link rel="icon" href = "Img/livro-icone.png">
		
		<title>Trocas - XINGLING</title>
	</head>
	<body>
		<c:import url="CabecalhoAdmin.jsp"/>
		
		<div class="panel trocas panel-info border"  >
			<div class="panel-heading titulo" >Trocas</div>
			<div class="panel-body">
				<div class="col-md-9" >
					<table class="table table-striped table-hover" id="div-trocas">
						<thead>
						   	<tr>
						   		<th>Confiança</th>
						       	<th>Id da Solicitação</th>
						       	<th >Id do Usuário</th>
						       	<th>Valor Total</th>
						       	<th class="text-center">Data da Compra</th>
						       	<th class="text-center">Data da Solicitação</th>
						       	<th class="text-center">Aprovar</th>
						       	<th class="text-center">Recusar</th>
							</tr>
						</thead>
						<tbody>
						   	<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" ></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >321654</td>
						       	<td>329999</td>
						       	<td>R$ 100,00</td>
						       	<td class="text-center">12/10/2016</td>
						       	<td class="text-center">29/10/2016</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Gerar Cupom</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar</button></td>
							</tr>
								<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" ></i>
				                        <i class="fa fa-star" ></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >654789</td>
						       	<td>888654</td>
						       	<td>R$ 50,00</td>
						       	<td class="text-center">12/08/2017</td>
						       	<td class="text-center">12/10/2016</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Gerar Cupom</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar</button></td>
							</tr>
							<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
				                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i></td>
						       	<td >87465</td>
						       	<td>321654</td>
						       	<td>R$ 200,00</td>
						       	<td class="text-center">25/10/2017</td>
						       	<td class="text-center">09/11/2016</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Gerar Cupom</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar	</button></td>
						  	</tr>
						  		<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" ></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >9874564</td>
						       	<td>3887499</td>
						       	<td>R$ 200,00</td>
						       	<td class="text-center">05/08/2016</td>
						       	<td class="text-center">29/09/2016</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Gerar Cupom</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar</button></td>
							</tr>
								<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>		                
				                      	<i class="fa fa-star"  style = "color: #FFEC0B;" ></i></td>
						       	<td >2581454</td>
						       	<td>3298749</td>
						       	<td>R$ 250,00</td>
						       	<td class="text-center">05/10/2016</td>
						       	<td class="text-center">19/10/2016</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Gerar Cupom</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar</button></td>
							</tr>
								<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" ></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >9874654</td>
						       	<td>12349874</td>
						       	<td>R$ 60,00</td>
						       	<td class="text-center">12/10/2017</td>
						       	<td class="text-center">29/10/2017</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Gerar Cupom</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar</button></td>
							</tr>
								<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" ></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >321654</td>
						       	<td>329999</td>
						       	<td>R$ 100,00</td>
						       	<td class="text-center">12/10/2016</td>
						       	<td class="text-center">29/10/2016</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Gerar Cupom</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar</button></td>
							</tr>
								<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" ></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >654789</td>
						       	<td>888654</td>
						       	<td>R$ 50,00</td>
						       	<td class="text-center">12/08/2017</td>
						       	<td class="text-center">12/10/2016</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Gerar Cupom</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar</button></td>
							</tr>
							<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
				                      	<i class="fa fa-star" style = "color: #FFEC0B;" ></i></td>
						       	<td >87465</td>
						       	<td>321654</td>
						       	<td>R$ 200,00</td>
						       	<td class="text-center">25/10/2017</td>
						       	<td class="text-center">09/11/2016</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Gerar Cupom</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar	</button></td>
						  	</tr>
						  		<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >9874564</td>
						       	<td>3887499</td>
						       	<td>R$ 200,00</td>
						       	<td class="text-center">05/08/2016</td>
						       	<td class="text-center">29/09/2016</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Gerar Cupom</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar</button></td>
							</tr>
						</tbody>
					</table>
					
			</div>
			</div>	
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