<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Contato - XINGLING</title>
        <link rel="stylesheet" href="CSS/Reset.css">
        <link rel="stylesheet" href="CSS/GeralSite.css">
        <link rel="stylesheet" href="CSS/Cliente/Contato.css">
        <link rel="icon" href = "Img/livro-icone.png">
    </head>
    <body>

        <c:import url= "CabecalhoCliente.jsp"/>
		
		<div>
		
		<div class="container">
		    <div class="row">
		        <div class="col">
		            <nav aria-label="breadcrumb" >
		                <ol class="breadcrumb" >
	                    <li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
		                    <li class="breadcrumb-item active" aria-current="page" style="color: #FFF;">Contato</li>
		                </ol>
		            </nav>
		        </div>
		    </div>
		</div>
		<div class="container">
		    <div class="row">
		        <div class="col">
		            <div class="card">
		                <div class="card-header bg-info text-white"><i class="fa fa-envelope"></i> Entre em contato.
		                </div>
		                <div class="card-body">
		                    <form>
		                        <div class="form-group">
		                            <label for="name">Nome</label>
		                            <input type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Nome" required>
		                        </div>
		                        <div class="form-group">
		                            <label for="email">Endereço de Email</label>
		                            <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Email" required>
		                            <small id="emailHelp" class="form-text text-muted">Não iremos compartilhar o seu email com ninguém.</small>
		                        </div>
		                        <div class="form-group">
		                            <label for="message">Mensagem</label>
		                            <textarea class="form-control" id="message" rows="6" required></textarea>
		                        </div>
		                        <div class="mx-auto">
		                        <button type="submit" class="btn btn-info text-right">Enviar</button></div>
		                    </form>
		                </div>
		            </div>
		        </div>
		        <div class="col-12 col-sm-4">
		            <div class="card bg-light mb-3">
		                <div class="card-header bg-success text-white text-uppercase"><i class="fa fa-home"></i> Endereço</div>
		                <div class="card-body">
		                    <p>Avenida Paulista, 3426</p>
		                    <p>São Paulo</p>
		                    <p>Brasil</p>
		                    <p>Email : contato@xingling.com</p>
		                    <p>Tel. (11) 5555-9999</p>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
	</div>

        <c:import url= "RodapeCliente.jsp"/>

    </body>
</html>