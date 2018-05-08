<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="CSS/Reset.css">
		<link rel="stylesheet" href="CSS/GeralSite.css">
		<link rel="stylesheet" href="CSS/Cliente/Cabecalho.css">
		
	</head>
	<body>
		<header>
			<nav class="navbar navbar-expand-md navbar-dark bg-dark" id="backCabecalho" >
			    <div class="container">
			        <a href="HomeCliente.jsp">
			  			<img src="Img/logo-cliente.jpg" alt="Logo Xingling" id="logo">
					</a>
			
			        <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
			           
			
			            <form class="form-inline my-2 my-lg-0">
			                <div class="input-group " id="barra-pesquisa">
			                    <input type="text" class="form-control " id="escrita-pesquisar" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Pesquisar...">
			                    <div class="input-group-append">
			                        <button type="button" class="btn btn-secondary btn-number btn-pesq">
			                            <i class="fa fa-search"></i>
			                        </button>
			                    </div>
			                </div>
			                
			                <a href="Perfil.jsp" >
			  					<img src="Img/icon-user.png" alt="Imagem Perfil" id="icone-perfil">
							</a>
			                 	
			                <a class="btn btn-success btn-sm ml-3" id="carrinho" href="Carrinho.jsp" >
			                    <i class="fa fa-shopping-cart"></i> Carrinho
			                    <span class="badge badge-light">2</span>
			                </a>
			                </form>
			        </div>
			    </div>
			</nav>
		</header>
	</body>
</html>


