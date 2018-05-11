
package les12015.controle.web.vh.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import les12015.controle.web.vh.IViewHelper;
import les12015.core.aplicacao.Resultado;
import les12015.dominio.Cartao;
import les12015.dominio.Cliente;
import les12015.dominio.Endereco;
import les12015.dominio.EntidadeDominio;



public class ClienteViewHelper implements IViewHelper {

	/** 
	 * TODO Descrição do Método
	 * @param request
	 * @param response
	 * @return
	 * @see les12015.controle.web.vh.IViewHelper#getEntidade(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String operacao = request.getParameter("operacao");
		Cliente cliente = new Cliente(); 
		cliente.setTipoUsuario("cliente");
	
		if(operacao.equals("CONSULTAR")) {
			String nome = request.getParameter("txtNome");
			String cpf = request.getParameter("txtCpf");
			String email = request.getParameter("txtEmail");
			//Verificando o resto
			if (nome != null && !nome.trim().equals("")) {
                cliente.setNome(nome);
            }
			if (cpf != null && !cpf.trim().equals("")) {
                cliente.setCpf(cpf);
            }
			if (email != null && !email.trim().equals("")) {
                cliente.setEmail(email);
            }
			String id = request.getParameter("txtId");
			if (id != null && !id.trim().equals("")) {
                cliente.setId(Integer.parseInt(id));
			}
		}
	
		if(operacao.equals("SALVAR") || operacao.equals("ALTERAR")) {
			if(operacao.equals("SALVAR")){
				//Pegando os atributos dos inputs
				String nome = request.getParameter("txtNome");
				String cpf = request.getParameter("txtCpf");
				String email = request.getParameter("txtEmail");
				//Verificando o resto
				if (nome != null && !nome.trim().equals("")) {
	                cliente.setNome(nome);
	            }
				if (cpf != null && !cpf.trim().equals("")) {
	                cliente.setCpf(cpf);
	            }
				if (email != null && !email.trim().equals("")) {
	                cliente.setEmail(email);
	            }
	
				//Colocando no Obj cliente ... Pq se eu tiro isso ele para de funfar??
				cliente.setEmail(email);
				cliente.setCpf(cpf);
				cliente.setNome(nome);
			}
		
				String senha = request.getParameter("txtSenha");
				String confSenha = request.getParameter("txtConfSenha");
				if (senha != null && !senha.trim().equals("")) {
		                cliente.setSenha(senha);
		            }
				if (confSenha != null && !confSenha.trim().equals("")) {      
					cliente.setSenha(confSenha);
				}
				cliente.setSenha(senha);
				cliente.setConfSenha(confSenha);
			
			//Verficar campos especificos da operação Consultar ou Alterar
			if(operacao.equals("ALTERAR") ) {
				String id = request.getParameter("txtId");
				if (id != null && !id.trim().equals("")) {
	                cliente.setId(Integer.parseInt(id));
				}
			}
			if(operacao.equals("SALVAR") ) {
				cliente.getCartoes().add(new Cartao());
				cliente.getEnderecos().add(new Endereco());
			}
		}
		
		if(operacao.equals("EXCLUIR")){
			//String id = request.getParameter("txtCliId");
			cliente = (Cliente) request.getAttribute("cliente");
		}
		
		return cliente;
	}

	/** 
	 * TODO Descrição do Método
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 * @see les12015.controle.web.vh.IViewHelper#setView(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void setView(Resultado resultado, HttpServletRequest request, 
							HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher reqD = null;
		String operacao = request.getParameter("operacao");
		
		
		if(resultado.getMsg() == null){
			if(operacao.equals("SALVAR")){
				request.getSession().setAttribute("resultado", resultado);
				request.getSession().setAttribute("cliente", resultado.getEntidades().get(0));
				reqD = request.getRequestDispatcher("HomeCliente.jsp");  
			}
			if(operacao.equals("EXCLUIR")){
				reqD = request.getRequestDispatcher("Login.jsp"); 
				resultado.setMsg("Sua Conta foi Excluida :( ");
			}
			else if (operacao.equals("CONSULTAR")) {
				request.getSession().setAttribute("clientes", resultado.getEntidades());
				reqD = request.getRequestDispatcher("ConsultarCliente.jsp");  	
			}
		}
		else if (resultado.getMsg() != null){
			if(operacao.equals("SALVAR")){
				request.getSession().setAttribute("resultado", resultado);
				reqD = request.getRequestDispatcher("CadastroCliente.jsp");  	
			}
		}
		reqD.forward(request,response); 
		
	}

}
