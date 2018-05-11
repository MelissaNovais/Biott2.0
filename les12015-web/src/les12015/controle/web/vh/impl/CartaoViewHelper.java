package les12015.controle.web.vh.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import les12015.controle.web.vh.IViewHelper;
import les12015.core.aplicacao.Resultado;
import les12015.dominio.Cartao;
import les12015.dominio.EntidadeDominio;

public class CartaoViewHelper implements IViewHelper{

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String operacao = request.getParameter("operacao");
		Cartao cartao = new Cartao();
		
		

		String numero = request.getParameter("txtNumero");
		String codSeguranca = request.getParameter("txtCodSeguranca");
		String titular = request.getParameter("txtTitular");
		String dataVencimento = request.getParameter("txtExpiracao");
		
		
		
		if(operacao.equals("SALVAR")) {
			if (numero != null && !numero.trim().equals(""))
				cartao.setNumero(numero);

			if (codSeguranca != null && !codSeguranca.trim().equals(""))
				cartao.setCodSeguranca(codSeguranca);

			if (titular != null && !titular.trim().equals(""))
				cartao.setTitular(titular);

			if (dataVencimento != null && !dataVencimento.trim().equals(""))
				cartao.setDataVenc(dataVencimento);

		}
		cartao.setPreferencial(true);
		cartao.setIdCliente(1263);
		
		return cartao;
	}

	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher reqD = null;
		String operacao = request.getParameter("operacao");
		
		
		if(resultado.getMsg() == null){
			if(operacao.equals("SALVAR")){
				resultado.setMsg("Cartao Cadastrado com Sucesso!!");
				request.getSession().setAttribute("resultado", resultado);
				request.getSession().setAttribute("cartoes", resultado.getEntidades());
				reqD = request.getRequestDispatcher("Perfil.jsp");  
			}
			if(operacao.equals("EXCLUIR")){
				reqD = request.getRequestDispatcher(""); 
				resultado.setMsg("Sua Conta foi Excluida :( ");
			}
			else if (operacao.equals("CONSULTAR")) {

				reqD = request.getRequestDispatcher("");  	
			}
		}
		else if (resultado.getMsg() != null){
			if(operacao.equals("SALVAR")){
				request.getSession().setAttribute("resultado", resultado);
				reqD = request.getRequestDispatcher("Perfil.jsp");  	
			}
		}
		reqD.forward(request,response); 
		
	}

}
