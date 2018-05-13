package les12015.controle.web.vh.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import les12015.controle.web.vh.IViewHelper;
import les12015.core.aplicacao.Resultado;
import les12015.core.impl.dao.CartaoDAO;
import les12015.core.impl.dao.ClienteDAO;
import les12015.core.impl.dao.CupomDAO;
import les12015.core.impl.dao.EnderecoDAO;
import les12015.dominio.Cartao;
import les12015.dominio.Cliente;
import les12015.dominio.Cupom;
import les12015.dominio.Endereco;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Login;

public class LoginViewHelper implements IViewHelper{

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String operacao = request.getParameter("operacao");
		Login login = new Login(); 
		
		
		if(operacao.equals("CONSULTAR")) { //Ou logar?
			String email = request.getParameter("txtEmail");
			String senha = request.getParameter("txtSenha");
			
			if (email != null && !email.trim().equals(""))
				login.setEmail(email);
			
			if (senha != null && !senha.trim().equals("")) 
				login.setSenha(senha);
				
		}
		
		if(operacao.equals("ALTERAR")) {
			String senha = request.getParameter("txtSenha");
			String confSenha = request.getParameter("txtConfSenha");
			
			if (senha != null && !senha.trim().equals(""))
				login.setSenha(senha);
			
			if (confSenha != null && !confSenha.trim().equals(""))
				login.setConfSenha(confSenha);
		}
		login.setTipoUsuario("cliente");
		return login;
	}

	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher reqD = null;
		String operacao = request.getParameter("operacao");

		if(resultado.getMsg() == null){
			
			
			if(operacao.equals("CONSULTAR")) {
				if (resultado.getEntidades().size() == 0) {
					resultado.setMsg("Email ou Senha Errados");
					request.getSession().setAttribute("resultado", resultado);
					reqD = request.getRequestDispatcher("Login.jsp");  
				}
				else {
					Login log = (Login) resultado.getEntidades().get(0);
					if(log.getTipoUsuario().equals("cliente")) {
						
						Cliente cliente = new Cliente();
						
						//Compras tbm tem q ta aqui hein
						ClienteDAO daoCli = new ClienteDAO();
						CartaoDAO carDAO = new CartaoDAO();
						EnderecoDAO endDAO = new EnderecoDAO();
						CupomDAO cupDAO = new CupomDAO();
						Cupom cup = new Cupom();

						cliente.setId(log.getIdUsuario());
						cup.setCliente(cliente);
						
						List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();
						lista = daoCli.consultar(cliente);
						cliente = (Cliente) lista.get(0);
						
						
						request.getSession().setAttribute("cliente", cliente);
						try {
							lista = carDAO.consultar(cliente);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						request.getSession().setAttribute("cartoes", lista);
						
						lista = endDAO.consultar(cliente);
						request.getSession().setAttribute("enderecos", lista);
						
						try {
							lista = carDAO.consultar(cliente);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						try {
							lista = cupDAO.consultar(cup);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						request.getSession().setAttribute("cupons", lista);
						
						reqD = request.getRequestDispatcher("HomeCliente.jsp");  
					}
					else if (log.getTipoUsuario().equals("admin")) {
						reqD = request.getRequestDispatcher("HomeAdmin.jsp");  
					}	
				}
			}
			if(operacao.equals("ALTERAR")){
				resultado.setMsg("Senha alterada com Sucesso");
				request.getSession().setAttribute("resultado", resultado);
				reqD = request.getRequestDispatcher("Perfil.jsp"); 
			}
			
		}
		else if (resultado.getMsg() != null){
			request.getSession().setAttribute("resultado", resultado);
			reqD = request.getRequestDispatcher("Login.jsp");  

		}
		reqD.forward(request,response); 
		
	}

}
