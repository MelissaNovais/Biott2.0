<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
	</head>
	<body>
		<div class="panel cadastro-dados-cliente-cartao panel-success border" id="panel-cartao" >
				<div class="panel-heading titulo" id="cabecalho-panel-cartao">Cartão
					<img class="img-responsive pull-right img-cartao" src="http://i76.imgup.net/accepted_c22e0.png">
				</div>
				<div class="panel-body ">
					<div class="row">
						<div class="col-md-9">
			                <div class="form-group">
			                    <div class="input-group">
			                    	<input type="tel" class="form-control" name="txtNumero" id="txtNumero"
			                        	placeholder="Número de Cartão Válido"
			             				autocomplete="cc-number" required autofocus />
			                     	<span class="input-group-addon"><i class="fa fa-credit-card" id="mini-cartao"></i></span>
			                  	</div>
							</div> 
						</div>
					
						<div class="col-md-3">
			                <div class="form-group">
			                    <input type="tel" class="form-control" name="txtExpiracao" id="txtExpiracao"
			                     	placeholder="Expiração: MM/AA"  autocomplete="cc-exp" required />
							</div> 
						</div>		
					</div>
					<div class="row">
						<div class="col-md-9">
			                <div class="form-group">
			                    <input type="text" id="txtTitular" class="form-control" name="txtTitular" placeholder = "Nome do Titular"/>
							</div> 
						</div>		
						<div class="col-md-3">
			                <div class="form-group">
			                    <input type="tel" class="form-control" name="txtCodSeguranca" id="txtCodSeguranca"
			                    	placeholder="Cód de Segurança" autocomplete="cc-csc" required/>
							</div> 
						</div>			
					</div>
					
					<div class="row">
						<div class="col-md-9">
							<div class="form-check">
					            <label class="checkbox-inline"><input type="checkbox" name= "carPreferencialCB" value="">Marcar como Preferencial</label>
							</div> 
						</div>
					</div>	
			</div>
		</div>
	</body>
</html>