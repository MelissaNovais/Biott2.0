<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="les12015.core.aplicacao.Resultado, les12015.dominio.*, java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Login - XINGLING</title>
        <link rel="stylesheet" href="CSS/Reset.css">
        <link rel="stylesheet" href="CSS/GeralSite.css">
        <link rel="stylesheet" href="CSS/Login.css">
        <link rel="icon" href = "Img/livro-icone.png">
    </head>
    <body>

        <c:import url= "CabecalhoCliente.jsp"/>
		
		<%	
			Resultado resultado = (Resultado) request.getAttribute("resultado");
		%>
		
		<c:if test="${not empty resultado}">
			<div class="alert alert-danger text-center alert-dismissible" role="alert" id="alert-sucesso">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				${resultado.msg}
		  		<br/>
			</div>
		</c:if>
	
		<div>
			<div class="container container-login" >
			    <div class="info">
			    	<h1>Login</h1>
			    </div>
			</div>
			<div class="form">
				<div class="thumbnail">
			    	<img src="Img/livro-icone.png">
			    </div>
			    <form class="login-form" action ="Logar" method= "post">
			      	<input type="text" placeholder="Email"  id = "txtEmail" v-model="email"/>
			      	<input type="password" placeholder="Senha" id = "txtSenha" v-model="senha"/>
			      	<button name="operacao" id="operacao" value = "CONSULTAR"> Login </button> 
			      </form>
			       	<p class="message">Não tem uma conta?
			        	<a href="CadastroInicial.jsp">Crie uma conta</a>
			      	</p>
			</div>
			
		</div>

        <c:import url= "RodapeCliente.jsp"/>

    </body>
    <script>
import AuthenticationService from '@/services/AuthenticationService'
export default {
  data(){
    return {
      email: '',
      senha: ''
    }
  },
  methods: {
    async register(){
      const response = await AuthenticationService.register({
        email: this.email,
        password: this.senha
      })
      console.log(response.data)
    }
  }
};

$('.message a').click(function(){
	   $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
	});
</script>
</html>