<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="CSS/Admin/CabecalhoAdmin.css">	
	</head>
	<body> 	
		<header>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark" id="backCabecalho">
    		<div class="container">
        		<a href="HomeAdmin.jsp">
  					<img src="Img/logo-admin.jpg" alt="Logo Xingling" id="logo">
				</a>
		        <div class="collapse navbar-collapse justify-content-end" id="cabecalho">
			         	<ul class="navbar-nav m-auto">
			                <li class="nav-item" >
			                    <div class="dropdown" id="drop-livro">
									<button class="btn btn-primary dropdown-toggle" type="button"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    	Livro
								  	</button>
								  	<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								    	<a class="dropdown-item" href="AlterarLivro.jsp">Alterar Livro</a>
								    	<a class="dropdown-item" href="AtivarLivro.jsp">Ativar </a>
								    	<a class="dropdown-item" href="DesativarLivro.jsp">Inativar </a>
								    	<a class="dropdown-item" href="CadastroLivro.jsp">Cadastrar</a>
								    	<a class="dropdown-item" href="ConsultarLivro.jsp">Consultar</a>
								  	</div>
								</div>
			                </li>
			                <li class="nav-item">
			                    <div class="dropdown">
									<button class="btn btn-primary dropdown-toggle" type="button" id="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    	Transações com Cliente
								  	</button>
								  	<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								    	<a class="dropdown-item" href="ConsultarCliente.jsp">Consultar Cliente</a>
								    	<a class="dropdown-item" href="Compras.jsp">Aprovar Compras </a>
								    	<a class="dropdown-item" href="ConsultarCompra.jsp">Consultar Compras </a>
								    	<a class="dropdown-item" href="Trocas.jsp">Aprovar Trocas </a>
								    	<a class="dropdown-item" href="ConsultarTroca.jsp">Consultar Trocas </a>
								    	<a class="dropdown-item" href="GerarCupomPromocional.jsp">Gerar Cumpom Promocional</a>
								  	</div>
								</div>
			                </li>
			                <li class="nav-item">
			                    <div class="dropdown">
									<button class="btn btn-primary dropdown-toggle" type="button" id="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    	Estoque
								  	</button>
								  	<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								    	<a class="dropdown-item" href="Estoque.jsp">Livro de Fornecedor</a>
								    	<a class="dropdown-item" href="RegistrarDevolucao.jsp">Livro de Troca (Devolução) </a>
								  	</div>
								</div>
			                </li>
			                <li class="nav-item">
			                    <div class="dropdown">
									<button class="btn btn-primary dropdown-toggle" type="button" id="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								    	Gráficos
								  	</button>
								  	<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
								    	<a class="dropdown-item" href="#">Devoluções</a>
								    	<a class="dropdown-item" href="#">Vendas </a>
								    	<a class="dropdown-item" href="#">Precificações</a>
								    	<a class="dropdown-item" href="#">Vendas </a>
								  	</div>
								</div>
			                </li>
			                <li>
			                	<a href="../Cliente/Login.jsp" data-target-id="">
			                		<i class="glyphicon glyphicon-log-out"></i>
			                	</a>
			                </li>
			            </ul>
		        	</div>
		   	 	</div>
			</nav>
	</header>
	</body>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="//code.jquery.com/jquery-2.2.4.min.js"></script>
</html>
<style>
    @import "//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css";
    @import "https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css";
</style>