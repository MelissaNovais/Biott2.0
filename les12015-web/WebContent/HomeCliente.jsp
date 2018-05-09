<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>XINGLING LIVRARIAS</title>
        <link rel="stylesheet" href="CSS/Reset.css">
        <link rel="stylesheet" href="CSS/GeralSite.css">
        <link rel="stylesheet" href="CSS/Cliente/HomeCliente.css">
        <link rel="icon" href = "Img/livro-icone.png">
    </head>
    <body>

        <c:import url= "CabecalhoCliente.jsp"/>
		
		<%	
			Cliente cliente = (Cliente) request.getAttribute("cliente");
			List<Livro> livros = new ArrayList<Livro>();
			livros = (ArrayList<Livro>) request.getAttribute("livros");
		%>
		
			
		<c:if test="${not empty cliente}">
			<div class="alert alert-success text-center alert-dismissible" role="alert" id="alert-sucesso">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					Bem Vindo ao Xingling ${cliente.nome} !! 
					Aproveite nossas Ofertas
 		  		<br/>
			</div>
		</c:if>
		
		
		<div>
			<div class="container">
	  			<div class="row">
	        		<div class="col">
	            		<nav aria-label="breadcrumb">
	                		<ol class="breadcrumb">
	                   			<li class="breadcrumb-item"><a href="">Home</a></li>
	                    		<!-- <li class="breadcrumb-item"><a href="category.html">Category</a></li>
	                    		<li class="breadcrumb-item active" aria-current="page">Sub-category</li> -->
	               	 		</ol>
	           	 		</nav>
	        		</div>
	    		</div>
			</div>
			<div class="container">
		    	<div class="row">
	        		<div class="col-12 col-sm-3">
	            		<div class="card bg-light mb-3">
	                		<div class="card-header text-white text-uppercase" id="cat-header"><i class="fa fa-list"></i> Categoria</div>
	                		<ul class="list-group category_block" id="cat-list">
	                    		<li class="list-group-item" id="teste"><a href="category.html">Aventura</a></li>
	                    		<li class="list-group-item"><a href="category.html">Romance</a></li>
	                    		<li class="list-group-item"><a href="category.html">Suspense</a></li>
	                    		<li class="list-group-item"><a href="category.html">Mistério</a></li>
	                    		<li class="list-group-item"><a href="category.html">Investigação</a></li>
	                		</ul>
	           			</div>
	           			<form action="PesquisarLivro" method="POST">
		            		<div class="card bg-light mb-3" id="card">
		                		<div class="card-header text-white text-uppercase" id="pesq-header"><i class="fa fa-list"></i> Pesq Especifica</div>
		                		
		                		<div class="form-group">
									<input id = "txtTitulo" class="form-control" type="text" placeholder="Título">
								</div>
							
								<div class="form-group">
									<input id = "txtAutor" class="form-control" type="text" placeholder="Autor">
								</div>
		
						
								<div class="form-group">
									<textarea id = "txtSinopse" class="form-control"  rows="3" placeholder="Sinopse"></textarea>
								</div>
							
							
								<div class="form-group">
									<input id = "txtEditora" class="form-control" type="text" placeholder="Editora">
								</div>
							
								<div class="form-group">
									<input id = "txtEdicao" class="form-control" type="text" placeholder="Edição">
								</div>
								
		                		<div class="form-group">
									<input id = "txtAno" class="form-control" type="text" placeholder="Ano de Publicação">
								</div>
								<div class="form-group">
									<input  id = "txtIsbn" class="form-control" type="text" placeholder="ISBN">
								</div>
							
								<div class="form-group">
									<input id = "txtNumPag" class="form-control" type="text" placeholder="Número de Páginas">
								</div>
							
								<div class="form-group">
									<select class="form-control">
										<option value="" disabled selected>Precificação</option>
										<!-- Implementar JSP que inclui autores -->
									</select>
								</div>
							
								<div class="form-group">
									<input id = "txtPreco" class="form-control" type="text" placeholder="Preço R$">
								</div>
							
								<div class="form-group">
									<input id = "txtCodBarras" class="form-control" type="text" placeholder="Código de Barras">
								</div>
		
								<div class="form-group">
									<input id = "txtProfundidade" class="form-control" type="text" placeholder="Profundidade (cm)">
								</div>
		
								<div class="form-group">
									<input id = "txtPesoo" class="form-control" type="text" placeholder="Peso (g)">
								</div>
							
								<div class="form-group">
									<input id = "txtAltura" class="form-control" type="text" placeholder="Altura (cm)">
								</div>
							
								<div class="form-group">
									<input id = "txtLargura" class="form-control" type="text" placeholder="Largura (cm)">
								</div>
			
								<div class="form-group">
									<input id = "txtCusto" class="form-control" type="text" placeholder="Custo R$">
								</div>
							
								<div class="form-group">
									<input  id = "txtQtdeVenda" class="form-control" type="text" placeholder="Qtde Obg Venda">
								</div>
								<button type="submit" class="btn btn-success">Pesquisar</button>
	           				</div>
	           				
	           			</form>
	        		</div>
	        		<div class="col">
	            		<div class="row">
	                		<div class="col-12 col-md-6 col-lg-4">
	                    		<div class="card">
	                        		<img class="card-img-top" src="../../Img/livro-percy.jpg" alt="Card image cap">
	                        		<div class="card-body">
	                            		<h4 class="card-title"><a href="LivroSelecionado.jsp" title="View Product">Percy Jackson</a></h4>
	                            		<p class="card-text">Autor: Rick Riordan </p>
	                            		<div class="row">
	                                		<div class="col">
	                                    		<p class="btn btn-info btn-block">30,00 R$</p>
			                                </div>
	        		                        <div class="col">
	                		                    <a href="Carrinho.jsp" class="btn btn-success btn-block">Adicionar ao carrinho</a>
	                        		        </div>
	                            		</div>
	                        		</div>
	                    		</div>
	                		</div>
	                		
	                		<div class="col-12 col-md-6 col-lg-4">
	                    		<div class="card">
	                        		<img class="card-img-top" src="../../Img/livro12.jpg">
	                        		<div class="card-body">
	                            		<h4 class="card-title"><a href="LivroSelecionado.jsp" title="View Product">Two by Two</a></h4>
	                            		<p class="card-text">Autor: Nicholas Sparkles</p>
	                            		<div class="row">
	                                		<div class="col">
	                                   			<p class="btn btn-info btn-block">50,00 R$</p>
				                            </div>
	            			               	<div class="col">
	                                    		<a href="Carrinho.jsp" class="btn btn-success btn-block">Adicionar ao carrinho</a>
				                           </div>
	            			         	</div>
	                        		</div>
	                    		</div>
	                		</div>
	              			<div class="col-12 col-md-6 col-lg-4">
	                    		<div class="card">
	                        		<img class="card-img-top" src="../../Img/livro11.jpg" alt="Card image cap">
	                        		<div class="card-body">
	                            		<h4 class="card-title"><a href="LivroSelecionado.jsp" title="View Product">Sherlock Holmes</a></h4>
	                            		<p class="card-text">Autor: Sir Arthur Doyle</p>
	                            		<div class="row">
	                                		<div class="col">
	                                    		<p class="btn btn-info btn-block">50,00 R$</p>
	                                		</div>
	                                		<div class="col">
	                                    		<a href="Carrinho.jsp" class="btn btn-success btn-block">Adicionar ao carrinho</a>
	                                		</div>
	                            		</div>
	                        		</div>
	                    		</div>
	                		</div>
	                		
	                		
	                		<div class="col-12 col-md-6 col-lg-4">
	                    		<div class="card">
	                        		<img class="card-img-top" src="../../Img/livro10.png" alt="Card image cap">
	                        		<div class="card-body">
	                            		<h4 class="card-title"><a href="LivroSelecionado.jsp" title="View Product">O livro das Copas</a></h4>
	                            		<p class="card-text">Autor: Pelé</p>
	                            		<div class="row">
	                                		<div class="col">
	                                    		<p class="btn btn-info btn-block">19,90 R$</p>
	                                		</div>
	                                		<div class="col">
	                                    		<a href="Carrinho.jsp" class="btn btn-success btn-block">Adicionar ao carrinho</a>
	                                		</div>
	                            		</div>
	                        		</div>
	                    		</div>
	                		</div>
	                		<div class="col-12 col-md-6 col-lg-4">
	                    		<div class="card">
	                        		<img class="card-img-top" src="../../Img/livro1.png" alt="Card image cap">
	                        		<div class="card-body">
	                            		<h4 class="card-title"><a href="LivroSelecionado.jsp" title="View Product">Game Of Thrones</a></h4>
	                            		<p class="card-text">Autor: Martin Luther King</p>
	                            		<div class="row">
	                                		<div class="col">
	                                    		<p class="btn btn-info btn-block">80,00 R$</p>
	                                		</div>
	                                		<div class="col">
	                                    		<a href="Carrinho.jsp" class="btn btn-success btn-block">Adicionar ao carrinho</a>
	                                		</div>
	                            		</div>
	                        		</div>
	                    		</div>
	                		</div>
	                		<div class="col-12 col-md-6 col-lg-4">
	                    		<div class="card">
	                        		<img class="card-img-top" src="../../Img/livro12.png" alt="Card image cap">
	                        		<div class="card-body">
	                            		<h4 class="card-title"><a href="LivroSelecionado.jsp" title="View Product">My Hero Academia</a></h4>
	                            		<p class="card-text">Autor: Monteiro Lobato	</p>
	                            		<div class="row">
	                                		<div class="col">
	                                    		<p class="btn btn-info btn-block">20,00 R$</p>
	                                		</div>
			                                <div class="col">
	        		                            <a href="Carrinho.jsp" class="btn btn-success btn-block">Adicionar ao carrinho</a>
	                		                </div>
	                        		    </div>
	                        		</div>
	                    		</div>
	                		</div>
	                		
	                		
	                		<div class="col-12 col-md-6 col-lg-4">
	                    		<div class="card">
	                        		<img class="card-img-top" src="../../Img/livro4.png" alt="Card image cap">
	                        		<div class="card-body">
	                            		<h4 class="card-title"><a href="LivroSelecionado.jsp" title="View Product">Uma dobra no Tempo</a></h4>
	                            		<p class="card-text">Autor: Madeleine</p>
	                            		<div class="row">
	                                		<div class="col">
	                                    		<p class="btn btn-info btn-block">40,00 R$</p>
			                                </div>
	        		                        <div class="col">
	                		                    <a href="Carrinho.jsp" class="btn btn-success btn-block">Adicionar ao carrinho</a>
	                        		        </div>
	                            		</div>
	                        		</div>
	                    		</div>
	                		</div>
	                		
	                		<div class="col-12 col-md-6 col-lg-4">
	                    		<div class="card">
	                        		<img class="card-img-top" src="../../Img/livro15.jpg" alt="Card image cap">
	                        		<div class="card-body">
	                            		<h4 class="card-title"><a href="LivroSelecionado.jsp" title="View Product">O Extraordinário</a></h4>
	                            		<p class="card-text">Autor: Carinha lá</p>
	                            		<div class="row">
	                                		<div class="col">
	                                   			<p class="btn btn-info btn-block">30,00 R$</p>
				                            </div>
	            			               	<div class="col">
	                                    		<a href="Carrinho.jsp" class="btn btn-success btn-block">Adicionar ao carrinho</a>
				                           </div>
	            			         	</div>
	                        		</div>
	                    		</div>
	                		</div>
	              			<div class="col-12 col-md-6 col-lg-4">
	                    		<div class="card">
	                        		<img class="card-img-top" src="../../Img/livro3.jpg" alt="Card image cap">
	                        		<div class="card-body">
	                            		<h4 class="card-title"><a href="LivroSelecionado.jsp" title="View Product">Sherlock Holmes</a></h4>
	                            		<p class="card-text">Autor: Sir Arthur Doyle </p>
	                            		<div class="row">
	                                		<div class="col">
	                                    		<p class="btn btn-info btn-block">60,00 R$</p>
			                                </div>
	        	                        	<div class="col">
	                                    		<a href="Carrinho.jsp" class="btn btn-success btn-block">Adicionar ao carrinho</a>
	                                		</div>
		                           		</div>
	                        		</div>
	                    		</div>
	                		</div>
	                		
	                		
	                		<div class="col-12 col-md-6 col-lg-4">
	                    		<div class="card">
	                        		<img class="card-img-top" src="../../Img/livro7.jpg"alt="Card image cap">
	                        		<div class="card-body">
	                            		<h4 class="card-title"><a href="LivroSelecionado.jsp" title="View Product">Porque Fazemos ?</a></h4>
	                            		<p class="card-text">Autor: Alguém da Silva</p>
	                            		<div class="row">
	                                		<div class="col">
	                                    		<p class="btn btn-info btn-block">20,00 R$</p>
			                                </div>
	        		                        <div class="col">
	                		                    <a href="Carrinho.jsp" class="btn btn-success btn-block">Adicionar ao carrinho</a>
	                        		        </div>
	                            		</div>
	                        		</div>
	                    		</div>
	                		</div>
	                		
	                		<div class="col-12 col-md-6 col-lg-4">
	                    		<div class="card">
	                        		<img class="card-img-top" src="../../Img/livro9.jpg" alt="Card image cap">
	                        		<div class="card-body">
	                            		<h4 class="card-title"><a href="LivroSelecionado.jsp" title="View Product">A Culpa é das Estrelas</a></h4>
	                            		<p class="card-text">Autor: John Green</p>
	                            		<div class="row">
	                                		<div class="col">
	                                   			<p class="btn btn-info btn-block">30,00 R$</p>
				                            </div>
	            			               	<div class="col">
	                                    		<a href="Carrinho.jsp" class="btn btn-success btn-block">Adicionar ao carrinho</a>
				                           </div>
	            			         	</div>
	                        		</div>
	                    		</div>
	                		</div>
	                		
	              			<div class="col-12 col-md-6 col-lg-4">
	                    		<div class="card">
	                        		<img class="card-img-top" src="../../Img/livro6.jpg" alt="Card image cap">
	                        		<div class="card-body">
	                            		<h4 class="card-title"><a href="LivroSelecionado.jsp" title="View Product">Ginástica Cerebral</a></h4>
	                            		<p class="card-text">Autor: Paulo José Coelho</p>
	                            		<div class="row">
	                                		<div class="col">
	                                    		<p class="btn btn-info btn-block">20,00 R$</p>
			                                </div>
	        	                        	<div class="col">
	                                    		<a href="Carrinho.jsp" class="btn btn-success btn-block">Adicionar ao carrinho</a>
	                                		</div>
		                           		</div>
	                        		</div>
	                    		</div>
	                		</div>
	                		
	                		
	                		<div class="col-12">
	    		                <nav aria-label="...">
	                		        <ul class="pagination justify-content-center">
	                            		<li class="page-item ">
	                                		<a class="page-link" href="#" tabindex="-1">Anterior</a>
	                            		</li>
	                            		<li class="page-item"><a class="page-link" href="#">1</a></li>
	                            		<li class="page-item active">
	                                		<a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
	                            		</li>
	                            		<li class="page-item"><a class="page-link" href="#">3</a></li>
	                            		<li class="page-item">
	                                		<a class="page-link" href="#">Proximo</a>
			                            </li>
	        		                </ul>
	                		    </nav>
	                		</div>
	            		</div>
	       			 </div>
	   			</div>
			</div>
		</div>

        <c:import url= "RodapeCliente.jsp"/>

    </body>
</html>