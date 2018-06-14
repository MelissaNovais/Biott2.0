<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Finalizar Compra - XINGLING</title>
        <link rel="stylesheet" href="CSS/Reset.css">
        <link rel="stylesheet" href="CSS/GeralSite.css">
        <link rel="icon" href = "Img/livro-icone.png">
    </head>
    <body>
		
		<%	
			Cliente cliente = (Cliente) request.getAttribute("cliente");
			Cartao cartao = (Cartao) request.getAttribute("cartao");
			Cupom cupom = (Cupom) request.getAttribute("cupom");
			Endereco end = (Endereco) request.getAttribute("endereco");
			List<ItemCompra> itens = new ArrayList<ItemCompra>();
			itens = (ArrayList<ItemCompra>)request.getAttribute("itens");
			
		%>
		
        <c:import url= "CabecalhoCliente.jsp"/>
        
		
		
		<div class="container mb-4">
		    <div class="row">
		        <div class="col-12">
		            <div class="table-responsive">
		                <table class="table table-striped">
		                    <thead>
		                        <tr id= "primeira-linha-tab">
		                            <th scope="col"  > </th>
		                            <th scope="col " >Livros</th>
		                           	<th scope="col" class="text-center " >Quantidade</th>
		                            <th scope="col" class="text-center"  >Preço  R$ </th>
		                        </tr>
		                    </thead>
		                    <tbody>
		                        <tr>
		                            <td><img src="../../Img/mini-percy.jpg" /> </td>
		                            <td>Percy Jackson: A batalha do Labirinto</td>
		                            <td>
		                            	<div class="input-group mb-3 ">
				                        	<input type="text" class="form-control text-center"  id="quantidade" name="quantidade" min="1" max="100" value="1">
				                        </div>
				                    </td>
		                            <td class="text-center">30,90</td>
		                        </tr>
		                        <tr>
		                            <td><img src="../../Img/mini-gamee.png" /> </td>
		                            <td>As Crônicas de Gelo e Fogo</td>
		                            <td>
				                    	<div class="input-group mb-3">
				                        	<input type="text" class="form-control text-center"  id="quantidade" name="quantitdade" min="1" max="100" value="1">
				                        </div>
		                            </td>
		                            <td class="text-center">60,90 </td>
		                      	</tr>
		                    </tbody>
		                </table>
		            </div>
		        </div>
		        
		        <div class="col-12">
		         	<div class="table-responsive">
		         		<table class="table ">
		                    <thead>
		                    </thead>
		                    <tbody >
		                     	<tr>
		                            <td class="text-left">Endereço de Entrega: </td>
		                        </tr>
		                        <tr>
		                            <td class="text-left">Forma de Pagamento: </td>
		                        </tr>
		                        <tr>
		                            <td class="text-left">SubTotal : 91,50 R$</td>
		                        </tr>
		                        	<td class="text-left">Frete : 20,00 R$</td>
		                        </tr>
		                        <tr>
		                            <td class="text-left">Total : 111,50 R$</td>
		                        </tr>
		                   	</tbody>
		                </table>
		         		
		         	</div>
		         </div>
		    </div>
		</div>
			<form action = "SalvarCompra" method = "post">
		   		<button class = "btn btn-success" id= "operacao" type="submit" name="operacao" value="SALVAR"  > Finalizar Compra </button> 
		   	</form>
		<c:import url= "RodapeCliente.jsp"/>

    </body>
</html>