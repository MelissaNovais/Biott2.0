<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
	</head>
	<body>
		<div class="panel cadastro-endereco panel-success border" >
			<div class="panel-heading titulo" id="cabecalho-panel-end">Endereço</div>
			<div class="panel-body ">

				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<input id="txtCep" name="txtCep" class="form-control" type="text" placeholder="CEP">	
						</div>
					</div>
					<div class="col-md-7">
						<div class="form-group">
							<input id="txtRua" name="txtRua" class="form-control" type="text" placeholder="Rua">
						</div>
					</div>
					<div class="col-md-2">
						<div class="form-group">
							<input id="txtNumero" name="txtNumero" class="form-control" type="text" placeholder="Numero">
						</div>
					</div>	
				</div>
				
				<div class="row">
				
					<div class="col-md-5">
						<div class="form-group">
							<input id="txtBairro" name="txtBairro" class="form-control" type="text" placeholder="Bairro">		
							
						</div>
					</div>
					
					<div class="col-md-5">
						<div class="form-group">
							<input id="txtCidade" name="txtCidade" class="form-control" type="text" placeholder="Cidade">		
						</div>
					</div>	
					<div class="col-md-2">
						<div class="form-group">
							<input id="txtEstado" name="txtEstado" class="form-control" type="text" placeholder="Estado">
						</div>
					</div>		
				</div>
				<div class="row">
				
					<div class="col-md-12">
						<div class="form-group">
							<input id="txtIdentificacaoEnd" name="txtIdentificacaoEnd" class="form-control" type="text" 
								placeholder="Identificação de Endereço (Exemplo: Casa da Mamãe)">
						</div>
					</div>
				</div>
				
				
			</div>	
		</div>
		<script src="./JS/apiCep.js"></script>
	</body>
	</html>