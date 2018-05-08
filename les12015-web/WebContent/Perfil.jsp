<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
   		<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Perfil - XINGLING</title>
        <link rel="stylesheet" href="CSS/Reset.css">
        <link rel="stylesheet" href="CSS/GeralSite.css">
        <link rel="stylesheet" href="CSS/Cliente/Perfil.css">
        <link rel="icon" href = "Img/livro-icone.png">
    </head>
    <body>

        <c:import url= "CabecalhoCliente.jsp"/>
		
		<div class="container">
  
	        <div class="row" id="cont">
	
	            <div class=" col-md-3 menu-perfil">
	                <ul class="nav nav-pills nav-stacked admin-menu" >
	                    <li class="active"><a href="" data-target-id="perfil"><i class="glyphicon glyphicon-user"></i>�Perfil &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
						<li><a href="" data-target-id="cupons"><i class="glyphicon glyphicon-tag"></i>�Cupons &nbsp; &nbsp;</a></li>                   
	                    <li><a href="" data-target-id="historico"><i class="glyphicon glyphicon-list"></i>�Hist�rico &nbsp;  </a></li>
	                    <li><a href="" data-target-id="mudar-senha"><i class="glyphicon glyphicon-lock"></i>�Mudar Senha &nbsp; &nbsp; &nbsp; &nbsp; </a></li>
	                    <li><a href="" data-target-id="cadastrar-cartao"><i class="glyphicon glyphicon-credit-card"></i>�Cadastrar Cart�o &nbsp;  </a></li>
	                    <li><a href="" data-target-id="cadastrar-end"><i class="glyphicon glyphicon-home"></i> Cadastrar Endere�o</a></li>
	                    <li><a href="" data-target-id="configuracoes"><i class="glyphicon glyphicon-cog"></i>�Configura��es  &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
	                    <li><a href="" data-target-id="logout"><i class="glyphicon glyphicon-log-out"></i>�Logout &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; </a></li>
	                </ul>
	            </div>
	            
	             <div class="col-md-9  admin-content" id="perfil">
	                <div class="panel panel-success"  style="margin: 1em;">
	                    <div class="panel-heading" >
	                        <h3 class="panel-title">Dados Pessoais</h3>
	                    </div>
	                    <div class="panel-body">
	                   		
							<div class="row">
								<div class="col-md-1">
									<div class="form-group">
										<label>Email: </label>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<input id="txtEmail" disabled class="form-control" type="text" placeholder="Maria da Silva">	
									</div>
								</div>
								<div class="col-md-1">
									<div class="form-group">
										<label>CPF: </label>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<input id="txtCpf"disabled class="form-control" type="text" placeholder="456.654.489-78">	
									</div>
								</div>							
							</div>					
	                    </div>
	                </div>
	                <div class="panel panel-success border" style="margin: 1em;">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">Endere�o Preferencial</h3>
	                    </div>
	                    <div class="panel-body">
	                    	<div class="row">
								<div class="col-md-2">
									<div class="form-group">
										<label>Identifica��o: </label>
									</div>
								</div>
								<div class="col-md-8">
									<div class="form-group">
										<input id="txtIdentificacoEnd" disabled class="form-control" type="text" placeholder="Casa da Mam�e">	
									</div>
								</div>
							</div>	
	                        
	                    </div>
	                </div>
	                <div class="panel panel-success border" style="margin: 1em;">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">Cart�o Preferencial</h3>
	
	                    </div>
	                    <div class="panel-body">
	                        <div class="row">
								<div class="col-md-3">
									<div class="form-group">
										<label>N�mero do Cart�o: </label>
									</div>
								</div>
								<div class="col-md-7">
									<div class="form-group">
										<input id="txtIdentificacoEnd" disabled class="form-control disable" type="text" placeholder="********7899">	
									</div>
								</div>
							</div>	
	                    </div>
	                </div>
	            </div>
				
				<div class="col-md-9  admin-content" id="cupons">
	             	<div class="panel panel-success border" style="margin: 1em;">
	                	<div class="panel-heading" style="background-color: #36C90F;">
	                        <h3 class="panel-title">Cupons</h3>
	                    </div>
	                    <div class="panel-body" >                     
	                       	<table class="table table-striped table-hover">
						   		<thead>
							    	<tr>
							          	<th>Numero do Cupom</th>
							          	<th > &nbsp;Validade</th>
							          	<th>&nbsp;&nbsp;Valor</th>						        
					        		</tr>
							 	</thead>
							    <tbody>
							    	<tr>
							          	<th>789987465</th>
							          	<td >12/12/2018</td>
							          	<td>R$150,00</td>
							       </tr>
							       <tr>
							     		<th>654987321</th>
							          	<td>10/07/2018</td>
							       		<td>R$60,00</td>
							       </tr>
							    </tbody>
							</table>
						</div>
					</div>
				</div>
	
				
	            <div class="col-md-9  admin-content" id="historico">            
	            	<div class="panel panel-success border" style="margin: 1em;">         
	                    <div class="panel-heading">
	                        <div class="row">
	                        	<div class="col-md-10">
	                        		<h3 class="panel-title">Suas Compras</h3>
	                        	</div>
	                        	<div class="col-md-2">
									<div class="form-group">
										<!-- Split button -->
										<div class="btn-group" id="btn-filtrar">
										  	<button type="button" class="btn btn-default">Filtrar</button>
										  	<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										    
										    	<span class="sr-only">Toggle Dropdown</span>
										  	</button>
											 <ul class="dropdown-menu">
												   <li><a href="#">Compra Aprovada</a></li>
												   <li><a href="#">Compra Cancelada</a></li>
												   <li><a href="#">Compra Pendente</a></li>
												   <li><a href="#">Em caminho</a></li>
												   <li><a href="#">Recebido</a></li>
												   <li><a href="#">Pedido de Troca Pendente</a></li>
												   <li><a href="#">Troca Aprovada</a></li>
												   <li><a href="#">Troca Cancelada</a></li>
												   <li role="separator" class="divider"></li>
												   <li><a href="#">Todos</a></li>
											 </ul>
										</div>
									</div>
								</div>
	               			</div>
	               		</div>
	               		<div class="panel-body" >
							<table class="table table-striped table-hover">
						   		<thead>
							    	<tr> 
							    		<th >Id da Compra </th>
							          	<th class="text-center ">Livro </th>
							          	<th class="text-center ">Quantidade</th>
							          	<th class="text-center ">Pre�o</th>
							          	<th class="text-center ">Status</th>
							          	<th >Solicitar Troca</th>						          	
					        		</tr>
							 	</thead>
							    <tbody>
							    	<tr>
							          	<th>789987465</th>
							          	<td>A Pequena Sereia</td>
							          	<td class="text-center ">1</td>
							          	<td class="text-center ">R$150,00</td>
							          	<td>Recebido</td>
							          	<td class="text-center "><button class="btn btn-danger btn-sm ">Trocar</button></td>					          	
							       </tr>
							       <tr>
							          	<th>321654789</th>
							          	<td>A C�mera Perdida</td>
							          	<td class="text-center ">1</td>
							          	<td class="text-center ">R$150,00</td>
							          	<td>Em Caminho</td>
							          	<td> </td>
							       </tr>
							    </tbody>
							</table>
	                	</div>
	               	</div>
	          	</div>
	
	
	            <div class="col-md-9  admin-content" id="mudar-senha">
	                <form action="AlterarCliente" method="post">
	                    <div class="panel panel-success border" style="margin: 1em;">
	                        <div class="panel-heading">
	                            <h3 class="panel-title" ><label for="new_password" class="control-label panel-title">Nova Senha</label></h3>
	                        </div>
	                        <div class="panel-body">
	                            <div class="form-group">
	                                <div class="col-sm-10">
	                                    <input type="password" class="form-control" name="password" id="new_password" >
	                                </div>
	                            </div>
	
	                        </div>
	                    </div>
	
	             
	                    <div class="panel panel-success border" style="margin: 1em;">
	                        <div class="panel-heading">
	                            <h3 class="panel-title"  ><label for="confirm_password" class="control-label panel-title">Confirmar Senha</label></h3>
	                        </div>
	                        <div class="panel-body">
	                            <div class="form-group">
	                                <div class="col-sm-10">
	                                    <input type="password" class="form-control" name="password_confirmation" id="confirm_password" >
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	
	           
	                    <div class="panel panel-success border" style="margin: 1em;">
	                        <div class="panel-body">
	                            <div class="form-group">
	                                <div class="pull-left">
	                                    <input type="submit" class="form-control btn btn-success" id= "operacao" name="operacao"  value="ALTERAR">
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </form>
	            </div>       
	            
	            
	            <form action = "SalvarCartao" method= "post">
	            <div class="col-md-9  admin-content" id="cadastrar-cartao">
					<c:import url= "Cartao.jsp"/>
					<div class="panel-body">
	                   	<div class="form-group">
	                       	<div class="pull-left">
	                          	<button type="submit" class="form-control btn btn-success" name="operacao" id="operacao" value="SALVAR">Cadastrar</button>
	                      	</div>
	                    </div>
	               	</div>
				</div>
	            </form>
	            
	            <form action = "SalvarEndereco" method= "post">
		            <div class="col-md-9  admin-content" id="cadastrar-end">
						<c:import url= "Endereco.jsp"/>
						<div class="panel-body">
		                   	<div class="form-group">
		                      	<div class="pull-left">
		                           	<button type="submit" class="form-control btn btn-success" name="operacao" id="operacao" value="SALVAR">Cadastrar</button>
		                        </div>
		                  	</div>
		                 </div>
					</div>
				</form>
				
				
				<div class="col-md-9  admin-content" id="configuracoes">
	                <div class="panel panel-success border" style="margin: 1em;">
	                    <div class="panel-heading" >
	                        <h3 class="panel-title">Endere�os</h3>
	                    </div>
	                    <div class="panel-body">
	                        <table class="table  table-hover" >
						   		<thead >
							    	<tr >
							          	<th>Identifica��o do End</th>
							          	<th class="text-center ">Selecionar como:</th>
							          	<th class="text-center ">Selecionar como:</th>
							          	<th></th>
							          	
					        		</tr>
							 	</thead>
							    <tbody>
							    	<tr>
							          	<th><input id="txtIdentificacaoEnd" disabled class="form-control" type="text" placeholder="Casa da Mmam�e"></th>
							          	<td class="text-center "><label class="checkbox-inline"><input type="checkbox" value="">Preferencial</label></td>
							          	<td class="text-center "><label class="checkbox-inline"><input type="checkbox" value="">Cobran�a</label></td>
							          	<form action = "ExcluirEndereco" method= "post">
							          		<td><button class="btn btn-sm btn-danger" id="operacao" name="operacao" value="EXCLUIR">
							          				<i class="fa fa-trash" style="padding: 4px;" ></i> </button></td>
							          	</form>
							       </tr>
							       
							    </tbody>
							    
							</table>
							<form action = "AlterarEndereco" method= "post">    		
								<button class="btn btn-sm btn-success" id="operacao" name="operacao" value="ALTERAR">Alterar</button>
	                        </form>
						</div>	
					</div>
							
	                <div class="panel panel-success border" style="margin: 1em;">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">Cart�es</h3>
	                    </div>
	                    <div class="panel-body">
	                    	<table class="table  table-hover">
						   		<thead>
							    	<tr>
							          	<th>Numero do Cart�o</th>
							          	<th>Nome do Titular</th>
							          	<th class="text-center ">Selecionar como:</th>
							          	<th></th>
							          	
					        		</tr>
							 	</thead>
							    <tbody>
							    	<tr>
							          	<th><input id="txtNumCartao" disabled class="form-control" type="text" placeholder="*********7899"></th>
							          	<td><input id="txtTitularCartao" disabled class="form-control" type="text" placeholder="Maria da Silva"></td>
							          	<td class="text-center "><label class="checkbox-inline"><input type="checkbox" value="">Preferencial</label></td>
							          	<form action = "ExcluirCartao" method= "post">
							          		<td><button class="btn btn-sm btn-danger" id="operacao" name="operacao" value="EXCLUIR">
							          				<i class="fa fa-trash" style="padding: 4px;" ></i> </button></td>
							          	</form>
							       </tr>
							       
							    </tbody>
							    
							</table>
							<form action = "AlterarCartao" method= "post">    		
								<button class="btn btn-sm btn-success" id="operacao" name="operacao" value="ALTERAR">Alterar</button>
	                        </form>
						</div>	
	            	</div>
	            	
	            	<div class="panel panel-success border" style="margin: 1em;">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">Excluir Conta</h3>
	                    </div>
	                    <form action ="ExcluirCliente" method="post">
		                    <div class="panel-body">
		                    	<div class  ="row">
			                    	<div class = "col-md-10">
			                    		<label>Desejo Excluir Minha Conta Permanentemente</label>
			                    	</div>
			                    </div>
			                    <div class  ="row">
			                    	<div class = "col-md-10">
			                    		<button class="btn btn-sm btn-danger" style = "margin-top: 20px;"
			                    		id= "operacao" type="submit" name="operacao" value="EXCLUIR">Excluir Conta</button>
			                    	</div>
			                    </div>
							</div>	
						</form>
	            	</div>
	            </div>
	            
	             
	            
	           
	
	            <div class="col-md-9  admin-content" id="logout">
	                <div class="panel panel-success border" style="margin: 1em;">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">Confirmar Logout</h3>
	                    </div>
	                    <div class="panel-body" >
	                        Voc� deseja mesmo sair ?��
	                        <a  href="#" class="label label-success"
	                            onclick="event.preventDefault();
	                                                     document.getElementById('logout-form').submit();">
	                            <span >���N�o���</span>
	                        </a>����
	                        <a href="Login.jsp" class="label label-danger">�<span >��Sim���</span></a>
	                    </div>
	                    <form id="logout-form" action="#" method="POST" style="display: none;">
	                    </form>
	
	           		</div>
	            </div>
	        </div>
		</div>

        <c:import url= "RodapeCliente.jsp"/>

    </body>
    
</html>

<script type="text/javascript">
<!--

//-->

        $(document).ready(function()
      {
        var navItems = $('.admin-menu li > a');
        var navListItems = $('.admin-menu li');
        var allWells = $('.admin-content');
        var allWellsExceptFirst = $('.admin-content:not(:first)');
        allWellsExceptFirst.hide();
        navItems.click(function(e)
        {
            e.preventDefault();
            navListItems.removeClass('active');
            $(this).closest('li').addClass('active');
            allWells.hide();
            var target = $(this).attr('data-target-id');
            $('#' + target).show();
        });
        });

</script>

