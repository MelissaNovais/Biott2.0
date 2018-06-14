<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Carrinho - XINGLING</title>
        <link rel="stylesheet" href="CSS/Reset.css">
        <link rel="stylesheet" href="CSS/GeralSite.css">
        <link rel="stylesheet" href="CSS/Cliente/Carrinho.css">
        <link rel="icon" href = "Img/livro-icone.png">
    </head>
    <body>
		<%	
			List<ItemCompra> carrinho = new ArrayList<ItemCompra>();
			carrinho = (ArrayList<ItemCompra>) request.getAttribute("carrinho");
		%>
		
        <c:import url= "CabecalhoCliente.jsp"/>
		
		
		<div class="container">
  			<div class="row">
        		<div class="col">
            		<nav aria-label="breadcrumb">
                		 <ol class="breadcrumb" style = "margin-top:40px; margin-bottom: 30px; ">
	                    	<li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
		                    <li class="breadcrumb-item active" aria-current="page" style="color:#FFF;" >Seu carrinho</li>
		                </ol>
           	 		</nav>
        		</div>
    		</div>
		</div>
		<c:if test="${empty carrinho }">
			<div class="container mb-4">
			    <div class="row">
			        <div class="col-12">
						<label>Seu Carrinho esta vazio</label>
					</div>
				</div>
			</div>
		</c:if>
		<c:if test="${not empty carrinho }">
			<div class="container mb-4">
			    <div class="row">
			        <div class="col-12">
			        
			            <div class="table-responsive">
			                <table class="table table-striped">
			                    <thead>
			                        <tr id= "primeira-linha-tab">
			                            <th scope="col"  > </th>
			                            <th scope="col " >Livro</th>
			                            <th scope="col" class="text-center " >Disponibilidade</th>
			                            <th scope="col" class="text-center " >Quantidade</th>
			                            <th scope="col" class="text-center"  >Preço  R$ </th>
			                            <th> </th>
			                        </tr>
			                    </thead>
			                    <tbody>
				                    <c:forEach var="item" items= "${carrinho}">
				                    	<tr>
					               			<td><img src="../../Img/mini-percy.jpg" /> </td>
					                   	 	<td>${item.livro.titulo }</td>
					                   	  	<td class="text-center ">${item.livro.qtdeEstoque }</td>
					                   	  	<td>
			                            		<div class="input-group mb-3 ">
						                        	<div class="input-group-prepend">
						                            	<button type="button"  onclick = "diminuirQtde()" class="quantity-left-minus btn btn-primary btn-number"  data-type="minus" data-field="">
						                                	<i class="fa fa-minus"></i>
						                                </button>
						                           	</div>
						                            <input type="text" class="form-control text-center"  id="quantity" name="quantity" min="1" max="100" value="1">
						                            <div class="input-group-append">
						                           		<button type="button"  onclick = "adicionarQtde()" class="quantity-right-plus btn btn-primary btn-number" data-type="plus" data-field="">
						                                	<i class="fa fa-plus"></i>
						                               	</button>
						                           	</div>
						                     	</div>
					                    	</td>
					                    	<td class="text-center"><fmt:formatNumber value = "${item.livro.preco }" type = "currency"/></td>
					                    	
			                            	<td class="text-right"><button class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> </button> </td>
			                        
					                    </tr>
				            		</c:forEach>   
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
			                        <tr id="primeira-linha" >
			                            <td class="text-right">SubTotal : 91,50 R$</td>
			                        </tr>
	
			                   	</tbody>
			                </table>
			         	</div>
			         </div>
			        <div class="col mb-2">
			            <div class="row">
			                <div class="col-sm-12  col-md-6">
			                   <a href="HomeCliente.jsp" class="btn btn-lg btn-block btn-info "> Continuar Comprando </a>
			                </div>
			                <div class="col-sm-12 col-md-6 text-right">
			                	<a href="FinalizandoCompra.jsp" class="btn btn-lg btn-block btn-success "> Finalizar Compra </a>
			                </div>
			            </div>
			        </div>
			    </div>
			</div>
		</c:if>
        <c:import url= "RodapeCliente.jsp"/>

    </body>
</html>
<script type="text/javascript">

       function adicionarQtde(){
    	   var qtdeAtual = parseInt ($("#quantity").val());
    	   qtdeAtual += 1;
    	   $("#quantity").val(qtdeAtual);	
       }
       function diminuirQtde(){
    	   var qtdeAtual = parseInt ($("#quantity").val());
    	   qtdeAtual -= 1;
    	   if ( qtdeAtual == 0)	
    		   qtdeAtual = 1;
    	   $("#quantity").val(qtdeAtual);	
       }

</script>