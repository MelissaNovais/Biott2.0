<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Finalizando Compra - XINGLING</title>
        <link rel="stylesheet" href="CSS/Reset.css">
        <link rel="stylesheet" href="CSS/GeralSite.css">
        <link rel="stylesheet" href="CSS/Cliente/FinalizandoCompra.css">
        <link rel="stylesheet" href="CSS/Cliente/Endereco.css">
        <link rel="stylesheet" href="CSS/Cliente/Cartao.css">
        <link rel="icon" href = "Img/livro-icone.png">
    </head>
    <body>
		
		<%	
			Cliente cliente = (Cliente) request.getAttribute("cliente");
			Resultado resultado = (Resultado) request.getAttribute("resultado");
			List<Endereco> enderecos = new ArrayList<Endereco>();
			List<Cartao> cartoes = new ArrayList<Cartao>();
			cartoes = (ArrayList<Cartao>) request.getAttribute("cartoes");
			enderecos = (ArrayList<Endereco>) request.getAttribute("enderecos");
			
		%>

        <c:import url= "CabecalhoCliente.jsp"/>
		
		<%-- Alert de terminar cadastro ou msg no caso de cadastros com dados respetidos e verificação de cupom --%>
		<c:if test="${empty cliente}">
			<c:redirect url="Login.jsp"/>
		</c:if>
		
		<c:if test ="${not empty resultado.msg }">
			<div class="alert alert-warning alert-dismissible" role="alert" id="alert-completar-cadastro">
			 	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					${resultado.msg}
			</div>
		</c:if>
		
		<div class="espacamento"> </div>
		
		<%-- Se nao tiver endereço faz o cadastro
				Se tiver aparece o dropdown --%>
		
		<c:if test="${empty enderecos || empty cartoes}"> 
			<div class="alert alert-warning alert-dismissible" role="alert" id="alert-completar-cadastro">
			 	<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				Quase lá! Complete seu Cadastro para Continuar
			</div>
			<c:if test="${empty enderecos }"> 
				<form action = "SalvarEnderecoCompra" method= "post">
					<c:import url="Endereco.jsp" />
					<button type="submit" class="form-control btn btn-success" name="operacao" id="btn-cad-end" value="SALVAR">Cadastrar Endereço</button>
				</form>
			</c:if>
			<c:if test="${empty cartoes }"> 
				<form action = "SalvarCartaoCompra" method= "post">
					<c:import url="Cartao.jsp" />
					<button type="submit" class="form-control btn btn-success" name="operacao" id="btn-cad-cartao" value="SALVAR">Cadastrar Cartão</button>
				</form>
			</c:if>
		</c:if>
	
		
	
		<c:if test="${not empty enderecos }"> 
			<div class="btn-dropdown">
				<div class="btn-group">
					<button type="button" class="btn btn-success">Endereços</button>
					<button type="button"
						class="btn btn-success dropdown-toggle dropdown-toggle-split"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" >
						<span class="sr-only">Toggle Dropdown</span>
					</button>
					<div class="dropdown-menu">
						<c:forEach var="end" items ="${enderecos}">
							<a  class="dropdown-item btn" value = "${end.id}" href="#" 
							data-cep="${end.cep}"
							data-rua="${end.rua}"
							data-numero="${end.numero}"
							data-bairro="${end.bairro}"
							data-cidade="${end.cidade}"
							data-estado="${end.estado}"
							data-identificacao="${end.identificacao}"
							onclick="preencheEndereco(this)"
							> 
							${end.identificacao} </a>
							
						</c:forEach>						
					</div>
				</div>
			</div>
			<c:import url="Endereco.jsp" />
		</c:if>
		
		<div class="espacamento"></div>
		
		<c:if test="${not empty cartoes}"> 
			<div class="btn-dropdown">
				<div class="btn-group">
					<button type="button" class="btn btn-success">Cartões</button>
					<button type="button"
						class="btn btn-success dropdown-toggle dropdown-toggle-split"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<span class="sr-only">Toggle Dropdown</span>
					</button>
					<div class="dropdown-menu">
						<c:forEach var="car" items = "${cartoes}">
							<a  class="dropdown-item btn" value = "${car.id}" href="#" 
							data-numerocar="${car.numero}"
							data-titular="${car.titular}"
							data-datavenc="${car.dataVenc}"
							
							data-codseg="${car.codSeguranca}"
							onclick="preencheCartao(this)"
							> 
							${car.titular} </a>
						</c:forEach>
					</div>
				</div>
			</div>
			<c:import url="Cartao.jsp" />
		</c:if>

		<div class="espacamento"> </div>
		
		<form action="ConsultarCupomCompra" method="post">	
			<c:if test="${empty cupom}"> 
				<div class="row">
					<div class="input-cupom col-md-2">
						<div class="form-group">
							<input id="txtIdCupom" name = "txtCodCupom" class="form-control" type="text"
								placeholder="Codigo do Cupom ">
						</div>
					</div>	
				</div>
				<button 
					type="submit" class="form-control btn btn-success verificar-cumpom" 
						id="verificar-cumpom" name="operacao" value="CONSULTAR"> Aplicar Cupom
				</button>
			</c:if>
		</form>
		
		<c:if test="${not empty cupom}">
			<form action="ConsultarCupomCompra" method="post">	
				<div class="row">
						<div class="input-cupom col-md-2">
							<div class="form-group">
								<input id="txtIdCupom" name = "txtCodCupom" class="form-control" type="text"
									placeholder = "${cupom.codigo }">
							</div>
						</div>	
					</div>
					<button 
						type="submit" class="form-control btn btn-success verificar-cumpom" 
							id="verificar-cumpom" name="operacao" value="CONSULTAR"> Trocar Cupom
					</button>
			</form>
			<div class="row">
				<div class="input-cupom col-md-2">
					<div class="form-group">
						<label  name = "txtValorCupom" class="" type="text">Valor do Cupom: </label>
					</div>
				</div>	
				<div class="col-md-2">
					<div class="form-group">
						<input id="txtValorCupom"disabled class="form-control" type="text" value = "<fmt:formatNumber value = "${cupom.valor}" type = "currency"/>">	
					</div>
				</div>
			</div>
		</c:if>
		
		<div class="espacamento"> </div>
		
		<div class="form-group">
			<div >
				<a href="CompraFinalizada.jsp" id="btn-final-compra" class="form-control btn btn-success">Finalizar Compra </a> 
			</div>
		</div>

        <c:import url= "RodapeCliente.jsp"/>

<script>
			
			function preencheEndereco(link){				
				
				$('#txtCep').val($(link).data('cep'));
				$('#txtRua').val($(link).data('rua'));
				$('#txtNumero').val($(link).data('numero'));
				$('#txtBairro').val($(link).data('bairro'));
				$('#txtCidade').val($(link).data('cidade'));
				$('#txtEstado').val($(link).data('estado'));
				$('#txtIdentificacaoEnd').val($(link).data('identificacao'));
			}
			
			function preencheCartao(link){	
				$('#txtCodSeguranca').val($(link).data('codseg'));
				$('#txtExpiracao').val($(link).data('datavenc'));
				$('#txtNumeroCar').val($(link).data('numerocar'));
				$('#txtTitular').val($(link).data('titular'));
				
			}
			
			
</script>
    </body>
</html>