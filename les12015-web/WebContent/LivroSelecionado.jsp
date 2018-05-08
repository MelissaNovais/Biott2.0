<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Detalhes Livro - XINGLING</title>
        <link rel="stylesheet" href="CSS/Reset.css">
        <link rel="stylesheet" href="CSS/GeralSite.css">
        <link rel="stylesheet" href="CSS/Cliente/LivroDetalhes.css">
        <link rel="icon" href = "Img/livro-icone.png">
    </head>
    <body>

        <c:import url= "CabecalhoCliente.jsp"/>
		<div class="container" id="barra">
		    <div class="row">
		        <div class="col">
		            <nav aria-label="breadcrumb">
		                <ol class="breadcrumb">
		                    <li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
		                    <li class="breadcrumb-item"><a href="">Aventura</a></li>
		                    <li class="breadcrumb-item active" aria-current="page" style="color: #FFF;">A Batalha do labirinto</li>
		                </ol>
		            </nav>
		        </div>
		    </div>
		</div>
		<div class="container">
		    <div class="row">
		        <!-- Image -->
		        <div class="col-12 col-lg-6">
		            <div class=" text-center card bg-light mb-3">
		                <div class="card-body">
		                        <img  src="../../Img/livro-percy.jpg" />

		                </div>
		            </div>
		        </div>
		
		        <!-- Add to cart -->
		        <div class="col-12 col-lg-6 add_to_cart_block">
		            <div class="card bg-light mb-3">
		                <div class="card-body">
		                    <p class="price" ">30.00 R$</p>
  
		                    <form method="get" action="Carrinho.jsp">
		                        <div class="form-group">
		                            <label >Quantidade :</label>
		                            <div class="input-group mb-3">
		                                <div class="input-group-prepend">
		                                    <button type="button" class="quantity-left-minus btn btn-danger btn-number"  data-type="minus" data-field="">
		                                        <i class="fa fa-minus"></i>
		                                    </button>
		                                </div>
		                                <input type="text" class="form-control"  id="quantity" name="quantity" min="1" max="100" value="1">
		                                <div class="input-group-append">
		                                    <button type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus" data-field="">
		                                        <i class="fa fa-plus"></i>
		                                    </button>
		                                </div>
		                            </div>
		                        </div>

		                        <a href="Carrinho.jsp" class="btn btn-success btn-lg btn-block text-uppercase">
		                            <i class="fa fa-shopping-cart"></i> Adicionar ao Carrinho
		                        </a>
		                    </form>
		                    <br/>
		                    <br/>
		                    <div class="panel  cadastro-dados-cliente">							
								<div class="panel-body">
									<div class="row">
										<div class="col-md-4">
												
										</div>
										<div class="col-md-8">
											<div class="form-group">
												<i class="fa fa-truck fa-2x text-center"></i>&nbsp; Calcular Frete</li>
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-8">
											<div class="form-group">
												<input id = "txtCep" class="form-control list-inline-item" type="text" placeholder="CEP:">
											</div>
										</div>
										<div class="col-md-4">
											<div class="form-group">
												 <button  class="btn btn-success text-uppercase " id="btn-frete">Calcular</button>
											</div>
										</div>
									</div>
								</div>
							</div>

		                    
		                    <div class="reviews_product p-3 mb-2 ">
		                        <label >Recomenda��o: </label>
		                        <i class="fa fa-star"></i>
		                        <i class="fa fa-star"></i>
		                        <i class="fa fa-star"></i>
		                        <i class="fa fa-star"></i>		                
		                      	<i class="fa fa-star" id="black-star"  ></i>
		                        (4/5)
		                    
		                    </div>
		                    
		                </div>
		            </div>
		        </div>

		    </div>
		
		   <div class="row" id="cards">
        	<!-- Description -->
		        <div class="col-12">
		            <div class="card border-light mb-3">
		                <div class="card-header  text-white text-uppercase"><i class="fa fa-comment"></i>  Descri��o</div>
		                <div class="card-body">
		                    <p class="card-text">
		                        O Monte Olimpo est� em perigo. Cronos, o perverso tit� que foi destronado e feito em peda�os pelos doze deuses olimpianos, prepara um retorno triunfal. O primeiro passo de suas tropas ser� atacar e destruir o campo de treinamento dos her�is, filhos de deuses com mortais, que desde a Gr�cia Antiga combatem na linha de frente em defesa dos olimpianos. Para assegurar que esse ref�gio de semideuses - o Acampamento Meio-Sangue - n�o seja invadido, Percy Jackson e um jovem ciclope, ambos filhos de Poseidon, Annabeth Chase, filha de Atena, e Grover, um s�tiro, s�o destacados para uma importante miss�o - deter as for�as de Cronos antes que se aproximem do acampamento. Para isso, ser� preciso sobreviver ao emaranhado de corredores do temido Labirinto de D�dalo - um intermin�vel universo subterr�neo que, a cada curva, revela as mais aterrorizantes surpresas.
		                    </p>
		                </div>
		            </div>
		        </div>
		
		        <!-- Reviews -->
		        <div class="col-12" >
		            <div class="card border-light mb-3">
		                <div class="card-header  text-white text-uppercase"><i class="fa fa-align-justify"></i> Especifica��es</div>
		                <div class="card-body">
		            		<label  class="text-right">Titulo: Percy Jackson e os Olimpianos - A batalha do Labirinto </label>
		            		<br/>
		            		<label  class="text-right">Autor: Rick Riordan</label>
		            		<br/>
		            		<label  class="text-right">Categoria: Aventura </label>
		            		<br/>
		            		<label  class="text-right">Editora: Abril </label>
		            		<br/>
		            		<label  class="text-right">Edi��o: 1</label>
		            		<br/>
		            		<label  class="text-right">Ano de Lan�amento: 2009</label>
		            		<br/>
		            		<label  class="text-right">ISBN: 1236547899874 </label>
		            		<br/>
		            		<label  class="text-right">N� de P�ginas: 430 </label>
		            		<br/>
		            		<label  class="text-right">Alt x Lar x Prof em Cm: 10 x 5 x 3</label>
		            		<br/>
		            		<label  class="text-right">Peso: 430 Gramas </label>
		            	</div>
		            </div>
		        </div>
			</div>
		</div>
	

        <c:import url= "RodapeCliente.jsp"/>

    </body>
</html>