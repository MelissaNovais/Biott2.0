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
import les12015.dominio.EntidadeDominio;
import les12015.dominio.ItemCompra;

public class LivroViewHelper implements IViewHelper{

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		RequestDispatcher reqD = null;
		String operacao = request.getParameter("operacao");
		
		
		if(resultado.getMsg() == null){
			if(operacao.equals("SALVAR")){
			
				resultado.setMsg("Livro Cadastrado com Sucesso!!");
				request.getSession().setAttribute("resultado", resultado);
				reqD = request.getRequestDispatcher("CadastroLivro.jsp");  
				
				
			}
			if(operacao.equals("EXCLUIR")){
				resultado.setMsg("Livro Excluido com Sucesso!!");
				reqD = request.getRequestDispatcher("HomeAdmin.jsp"); 
			}
			else if (operacao.equals("CONSULTAR")) {
			
				request.getSession().setAttribute("livros", resultado.getEntidades());
				reqD = request.getRequestDispatcher("ConsultarLivro.jsp");  
			
				
			}
		}
		else if (resultado.getMsg() != null){
			if(operacao.equals("SALVAR")){
				request.getSession().setAttribute("resultado", resultado);
				reqD = request.getRequestDispatcher("CadastroLivro.jsp");  	
			}
			else if(operacao.equals("Consultar")){
				
				request.getSession().setAttribute("resultado", resultado);
				reqD = request.getRequestDispatcher("CadastroLivro.jsp");  	
			}
		}
		reqD.forward(request,response); 
		
	}

}
