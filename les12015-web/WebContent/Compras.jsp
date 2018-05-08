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
		<link rel="stylesheet" href="CSS/Admin/Compras.css">
		<link rel="icon" href = "Img/livro-icone.png">
		
		<title>Compras - XINGLING</title>
	</head>
	<body>
		<c:import url="CabecalhoAdmin.jsp"/>
		
		<div class="panel  compras panel-info border"  >
			<div class="panel-heading titulo" >Compras</div>
			<div class="panel-body">
				<div class="col-md-9" >
					<table class="table table-striped table-hover" id="div-compras">
						<thead>
					   		<tr>
						   		<th>Confiança</th>
						       	<th>Id da Compra</th>
						       	<th >Id do Usuário</th>
						       	<th>Valor Total</th>
						       	<th class="text-center">Data</th>
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
						       	<td>329879</td>
						       	<td>R$ 90,00</td>
						       	<td class="text-center">12/10/2016</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Aprovar</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar</button></td>
							</tr>
								<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" ></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >654789</td>
						       	<td>7548654</td>
						       	<td>R$ 75,00</td>
						       	<td class="text-center">12/08/2017</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Aprovar</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar</button></td>
							</tr>
							<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >87465</td>
						       	<td>321654</td>
						       	<td>R$ 150,00</td>
						       	<td class="text-center">12/10/2018</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Aprovar</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar	</button></td>
						     </tr>
						     <tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >321654</td>
						       	<td>329874</td>
						       	<td>R$ 100,00</td>
						       	<td class="text-center">12/10/2016</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Aprovar</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar</button></td>
							</tr>
								<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" ></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >654789</td>
						       	<td>147654</td>
						       	<td>R$ 80,00</td>
						       	<td class="text-center">12/08/2017</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Aprovar</button></td>
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
						       	<td class="text-center">12/10/2017</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Aprovar</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar	</button></td>
						     </tr>
						    
								<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" ></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >654789</td>
						       	<td>7548654</td>
						       	<td>R$ 50,00</td>
						       	<td class="text-center">12/08/2017</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Aprovar</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar</button></td>
							</tr>
							<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >87465</td>
						       	<td>321654</td>
						       	<td>R$ 120,00</td>
						       	<td class="text-center">12/10/2018</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Aprovar</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar	</button></td>
						     </tr>
						     <tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" ></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >321654</td>
						       	<td>329879</td>
						       	<td>R$ 75,00</td>
						       	<td class="text-center">12/10/2016</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Aprovar</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar</button></td>
							</tr>
								<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" ></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >654789</td>
						       	<td>7548654</td>
						       	<td>R$ 250,00</td>
						       	<td class="text-center">12/08/2017</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Aprovar</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar</button></td>
							</tr>
							<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >87465</td>
						       	<td>321654</td>
						       	<td>R$ 90,00</td>
						       	<td class="text-center">12/10/2018</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Aprovar</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar	</button></td>
						     </tr>
						     <tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >321654</td>
						       	<td>329874</td>
						       	<td>R$ 140,00</td>
						       	<td class="text-center">12/10/2016</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Aprovar</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar</button></td>
							</tr>
								<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" ></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >654789</td>
						       	<td>147654</td>
						       	<td>R$ 60,00</td>
						       	<td class="text-center">12/08/2017</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Aprovar</button></td>
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
						       	<td class="text-center">12/10/2017</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Aprovar</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar	</button></td>
						     </tr>
							<tr>
						       	<td><i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;" ></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>
				                        <i class="fa fa-star" style = "color: #FFEC0B;"></i>		                
				                      	<i class="fa fa-star"  ></i></td>
						       	<td >87465</td>
						       	<td>321654</td>
						       	<td>R$ 150,00</td>
						       	<td class="text-center">12/10/2018</td>
						       	<td class="text-center"> <button class="btn btn-success btn-sm ">Aprovar</button></td>
						       	<td class="text-center"> <button class="btn btn-danger btn-sm">Recusar	</button></td>
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