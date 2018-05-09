package les12015.controle.web.vh.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import les12015.controle.web.vh.IViewHelper;
import les12015.core.aplicacao.Resultado;
import les12015.core.impl.dao.ClienteDAO;
import les12015.dominio.Cliente;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Login;

public class LoginViewHelper implements IViewHelper{

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String operacao = request.getParameter("operacao");
		Login login = new Login(); 
		
		System.out.println("Viewhelper Login Get");
		if(operacao.equals("CONSULTAR")) {
			String email = request.getParameter("txtEmail");
			String senha = request.getParameter("txtSenha");
			
			if (email != null && !email.trim().equals(""))
				login.setEmail(email);
			
			if (senha != null && !senha.trim().equals("")) 
				login.setSenha(senha);
				
		}
		return login;
	}

	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher reqD = null;
		String operacao = request.getParameter("operacao");
		Login log = (Login) resultado.getEntidades().get(0);
		
		
		if(resultado.getMsg() == null){
			if(operacao.equals("CONSULTAR")){
				
				if(log.getTipoUsuario().equals("cliente")) {
					
					ClienteDAO daoCli = new ClienteDAO();
					Cliente cliente = new Cliente();
					cliente.setId(log.getIdUsuario());
					List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();
					lista = daoCli.consultar(cliente);
					cliente = (Cliente) lista.get(0);
					
					request.getSession().setAttribute("cliente", cliente);
					reqD = request.getRequestDispatcher("HomeCliente.jsp");  
				}
				else if (log.getTipoUsuario().equals("admin")) {
					reqD = request.getRequestDispatcher("HomeAdmin.jsp");  
				}				
			}	
		}
		else if (resultado.getMsg() != null){
			request.getSession().setAttribute("resultado", resultado);
		}
		reqD.forward(request,response); 
		
	}

}
