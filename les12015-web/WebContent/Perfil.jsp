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
		
		<%	
			Cliente cliente = (Cliente) request.getAttribute("cliente");
			Resultado resultado = (Resultado) request.getAttribute("resultado");
			List<Cupom> cupons = new ArrayList<Cupom>();
			List<Endereco> enderecos = new ArrayList<Endereco>();
			List<ItemCompra> historico = new ArrayList<ItemCompra>();
			List<Cartao> cartoes = new ArrayList<Cartao>();
			String msg = request.getParameter("msgSucesso");
			cartoes = (ArrayList<Cartao>) request.getAttribute("cartoes");
			cupons = (ArrayList<Cupom>) request.getAttribute("cupons");
			enderecos = (ArrayList<Endereco>) request.getAttribute("enderecos");
			historico = (ArrayList<ItemCompra>) request.getAttribute("historico");
			
		%>
		
        <c:import url= "CabecalhoCliente.jsp"/>
		
		<c:if test="${not empty resultado.msg}">
					<div class="alert alert-info text-center alert-dismissible" role="alert" >
					<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						${resultado.msg}
					  	<br/>
					</div>
				</c:if>
				
		<div class="container">
  
	        <div class="row" id="cont">
	
	            <div class=" col-md-3 menu-perfil">
	                <ul class="nav nav-pills nav-stacked admin-menu" >
	                    <li class="active"><a href="" data-target-id="perfil"><i class="glyphicon glyphicon-user"></i> Perfil &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
						<li><a href="" data-target-id="cupons"><i class="glyphicon glyphicon-tag"></i> Cupons &nbsp; &nbsp;</a></li>                   
	                    <li><a href="" data-target-id="historico"><i class="glyphicon glyphicon-list"></i> Histórico &nbsp;  </a></li>
	                    <li><a href="" data-target-id="mudar-senha"><i class="glyphicon glyphicon-lock"></i> Mudar Senha &nbsp; &nbsp; &nbsp; &nbsp; </a></li>
	                    <li><a href="" data-target-id="cadastrar-cartao"><i class="glyphicon glyphicon-credit-card"></i> Cadastrar Cartão &nbsp;  </a></li>
	                    <li><a href="" data-target-id="cadastrar-end"><i class="glyphicon glyphicon-home"></i> Cadastrar Endereço</a></li>
	                    <li><a href="" data-target-id="configuracoes"><i class="glyphicon glyphicon-cog"></i> Configurações  &nbsp; &nbsp; &nbsp; &nbsp;</a></li>
	                    <li><a href="" data-target-id="logout"><i class="glyphicon glyphicon-log-out"></i> Logout &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; </a></li>
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
										<input id="txtEmail" disabled class="form-control" type="text" value ="${cliente.email}">	
									</div>
								</div>
								<div class="col-md-1">
									<div class="form-group">
										<label>CPF: </label>
									</div>
								</div>
								<div class="col-md-4">
									<div class="form-group">
										<input id="txtCpf"disabled class="form-control" type="text" value = "${cliente.cpf}">	
									</div>
								</div>							
							</div>					
	                    </div>
	                </div>
	                <div class="panel panel-success border" style="margin: 1em;">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">Endereço Preferencial</h3>
	                    </div>
	                    <c:set var="preferencial" value="false"/>
	                    <c:if test = "${not empty enderecos}">
	                    	<c:forEach var="end" items= "${enderecos }">
			               		<c:if test= "${end.pereferencial }">
			               			<c:set var="preferencial" value="true"/>
			                   		<div class="panel-body">
		                    			<div class="row">
											<div class="col-md-2">
												<div class="form-group">
													<label>Identificação: </label>
												</div>
											</div>
			                    			<div class="col-md-8">
												<div class="form-group">
													<input id="txtIdentificacaoEnd" disabled class="form-control" type="text" value = "${end.identificacao}">	
												</div>
											</div>
										</div>			                        
		                   			 </div>											
			                   	</c:if>
			            	</c:forEach>
		               	</c:if>
		               	<c:if test="${not preferencial}">
		               		<div class="panel-body">
		                    	<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Você Não Possui um Endereço Cadastrado como Preferencial </label>
										</div>
									</div>
		                    	</div>			                        
		                    </div>
		               	</c:if>
	                </div>
	                <c:set var="preferencial" value="false"/>
	                <div class="panel panel-success border" style="margin: 1em;">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">Cartão Preferencial</h3>
	                    </div>
	                    
	                    <c:if test = "${not empty cartoes }">
		                   <c:forEach var="car" items= "${cartoes }">
			                   	<c:if test= "${car.preferencial }">
			                   		<c:set var="preferencial" value="true"/>
			                    	<div class="panel-body">
		                        		<div class="row">
											<div class="col-md-3">
												<div class="form-group">
													<label>Titular do Cartão: </label>
												</div>
											</div>
			                    			<div class="col-md-7">
												<div class="form-group">
													<input name = "txtTitular" disabled class="form-control" type="text" value = "${car.titular}">	
												</div>
											</div>
										</div>
									</div>
			                    </c:if>
			               	</c:forEach>
		               	</c:if>
		               	
		               	<c:if test="${not preferencial}">
		               		<div class="panel-body">
		                        <div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label>Você Não Possui um Cartão Cadastrado como Preferencial</label>
										</div>
									</div>
								</div>	
		                    </div>
		               	</c:if>
	                </div>
	            </div>
				
				<div class="col-md-9  admin-content" id="cupons">
	             	<div class="panel panel-success border" style="margin: 1em;">
	                	<div class="panel-heading" style="background-color: #36C90F;">
	                        <h3 class="panel-title">Cupons</h3>
	                    </div>
	                    
	                    <c:if test="${not empty cupons}">
	                    	<div class="panel-body" >                     
		                       	<table class="table table-striped table-hover">
							   		<thead>
								    	<tr>
								          	<th>Código do Cupom</th>
								          	<th>&nbsp;&nbsp;Teste R$</th>	
								          	<th>&nbsp;&nbsp;Valor R$</th>						        
						        		</tr>
								 	</thead>
								    <tbody>
								    	<c:forEach var = "cup" items = "${cupons}">
								    		<tr>
								    			<th>${cup.codigo}</th>
									          	<td><fmt:formatNumber value = "${cup.valor}" type = "currency"/></td>
									          	<td>${cup.valor}</td>
								          	</tr>
								      	 </c:forEach>
								    </tbody>
								</table>
							</div>
	                    </c:if>
	                    <c:if test="${empty cupons }">
	                    	<div class="panel-body" > 
	                    		<div class="row">									
									<div class="col-md-12">
										<label>Você Não Possui Cupons Disponíveis </label>
									</div>										
								</div>
	                    	</div>
	                    </c:if>
	                    
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
												    <li><a href="#">Trocado</a></li>
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
						   		<c:if test="${not empty historico }">
						   			<thead>
								    	<tr> 
								    		<th >Id da Compra </th>
								          	<th class="text-center ">Livro </th>
								          	<th class="text-center ">Qtde</th>
								          	<th class="text-center ">Preço</th>
								          	<th class="text-center ">Status</th>
								          	<th >Solicitar Troca</th>						          	
						        		</tr>
								 	</thead>
								    <tbody>
								    <%-- Não eh id da tabela Compra eh o id da tabela Item-compra --%> 
								    	<c:forEach var="compra" items="${historico }">
								    		<tr>
									          	<th>${compra.id}</th>
									          	<td>${compra.livro.titulo }</td>
									          	<td class="text-center ">${compra.qtde}</td>
									          	<td class="text-center ">${compra.livro.preco}</td>
									          	<td>${compra.statusDaCompra }</td>
									          	<c:if test="${compra.statusDaCompra  == 'Recebido' }">
									          		<td class="text-center "><button class="btn btn-danger btn-sm ">Trocar</button></td>
									          	</c:if>
									     	</tr>
								    	</c:forEach>
								    </tbody>
						   		</c:if>
						   		<c:if test="${empty historico }">
						   			<div class="row">									
										<div class="col-md-12">
											<label>Você nao Comprou nada Ainda. Mude isso  ; )</label>
										</div>
									</div>
								</c:if>
						   	</table>
	                	</div>
	               	</div>
	          	</div>
	
	
	            <div class="col-md-9  admin-content" id="mudar-senha">
	                <form action="AlterarLogin" method="post">
	                    <div class="panel panel-success border" style="margin: 1em;">
	                        <div class="panel-heading">
	                            <h3 class="panel-title" ><label for="new_password" class="control-label panel-title">Nova Senha</label></h3>
	                        </div>
	                        <div class="panel-body">
	                            <div class="form-group">
	                                <div class="col-sm-10">
	                                    <input type="password" class="form-control" name="txtSenha" id="new_password" >
	                                </div>
	                            </div>
	
	                        </div>
	                    </div>
	
	             
	                    <div class="panel panel-success border" style="margin: 1em;">
	                        <div class="panel-heading">
	                            <h3 class="panel-title"  ><label for="txtConfSenha" class="control-label panel-title">Confirmar Senha</label></h3>
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
	                        <h3 class="panel-title">Endereços</h3>
	                    </div>
	                    <div class="panel-body">
	                        <table class="table  table-hover" >
							   <c:if test="${not empty enderecos }">
							   		<thead >
								    	<tr >
								          	<th>Identificação do Endereço</th>
								          	<th class="text-center ">Selecionar como:</th>
								          	<th class="text-center "> </th>
								          	<th></th>
								          	
						        		</tr>
								 	</thead>
								    <tbody>
								   		<c:forEach var= "end" items = "${enderecos }">
									    	<tr>
									          	<th><label id="txtIdentificacaoEnd"  disable class="form-control" type="text" > ${endereco.identificacao} </th>
												<td class="text-center "><label class="radio-inline"><input type="radio" name="rdEndPreferencial">Preferencial </label></td>
											    <td class="text-center "><label class="radio-inline"><input type="radio" name="rdEndCobranca">Cobrança</label></td>
									          	<td><button class="btn btn-sm btn-danger" id="operacao" name="operacao" value="EXCLUIR">
									          				<i class="fa fa-trash" style="padding: 4px;" ></i> </button></td>
									          
									       </tr>
									  	</c:forEach>
								  	</tbody>
								  	
							  	</c:if>
							  	<c:if test="${empty enderecos }">
							  		<label>Você Não Possui Endereços Cadastrados</label>
							  	</c:if>
							  	
							</table>
							<form action = "AlterarEndereco" method= "post">    		
								<button class="btn btn-sm btn-success" id="operacao" name="operacao" value="ALTERAR">Alterar</button>
		                   	</form>
						</div>	
					</div>
							
	                <div class="panel panel-success border" style="margin: 1em;">
	                    <div class="panel-heading">
	                        <h3 class="panel-title">Cartões</h3>
	                    </div>
	                    <div class="panel-body">
	                    	<table class="table  table-hover">
						   		<c:if test="${not empty cartoes }"> 
							   		<thead>
								    	<tr>
								          	<th>Numero </th>
								          	<th>Titular </th>
								          	<th class="text-center ">Selecionar como:</th>
								          	<th></th>
								          	
						        		</tr>
								 	</thead>
								    <tbody>
								    	<c:forEach var = "car" items = "${cartoes}">
									    	<tr>
									          	<th><label id="txtNumeroCartao"  disable class="form-control" type="text" > ${car.numero} </th>
									          	<th><label id="txtTitular"  disable class="form-control" type="text" > ${car.titular} </th>
									          	<td class="text-center "><label class="radio-inline"><input type="radio" name="rdCartaoPreferencial">Preferencial</label></td>
										        <form action = "ExcluirCartao" method= "post">
									          		<td><button class="btn btn-sm btn-danger" id="operacao" name="operacao" value="EXCLUIR">
									          				<i class="fa fa-trash" style="padding: 4px;" ></i> </button></td>
									          	</form>
									       </tr>
									  	</c:forEach>
								    </tbody>
								    
							    </c:if>
							    <c:if test="${empty cartoes }">
							  		<label>Você Não Possui Cartões Cadastrados</label>
							  	</c:if>
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
	                        Você deseja mesmo sair ?  
	                        <a  href="#" class="label label-success"
	                            onclick="event.preventDefault();
	                                                     document.getElementById('logout-form').submit();">
	                            <span >   Não   </span>
	                        </a>    
	                        <a href="Login.jsp" class="label label-danger"> <span >  Sim   </span></a>
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

