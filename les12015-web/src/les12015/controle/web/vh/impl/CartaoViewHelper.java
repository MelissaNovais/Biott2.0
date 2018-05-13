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
import les12015.dominio.Cartao;
import les12015.dominio.Cliente;
import les12015.dominio.EntidadeDominio;

public class CartaoViewHelper implements IViewHelper{

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String operacao = request.getParameter("operacao");
		Cartao cartao = new Cartao();

		String numero = request.getParameter("txtNumero");
		String codSeguranca = request.getParameter("txtCodSeguranca");
		String titular = request.getParameter("txtTitular");
		String dataVencimento = request.getParameter("txtExpiracao");
		Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
			
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
		cartao.setIdCliente(cliente.getId());
		
		return cartao;
	}

	@SuppressWarnings("unchecked")
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher reqD = null;
		String operacao = request.getParameter("operacao");
		
		
		if(resultado.getMsg() == null){
			if(operacao.equals("SALVAR")){
				resultado.setMsg("Cartao Cadastrado com Sucesso!!");
				request.getSession().setAttribute("resultado", resultado);
				List<EntidadeDominio> cartoes = new ArrayList<EntidadeDominio>();
				cartoes = (List<EntidadeDominio>) request.getSession().getAttribute("cartoes");
				cartoes.add((EntidadeDominio) resultado.getEntidades().get(resultado.getEntidades().size() - 1));
				request.getSession().setAttribute("cartoes", cartoes);
				reqD = request.getRequestDispatcher("Perfil.jsp");  
			}
			if(operacao.equals("EXCLUIR")){
				reqD = request.getRequestDispatcher(""); 
				resultado.setMsg("Esse Cartão foi Excluido com sucesso ");
			}
			else if (operacao.equals("CONSULTAR")) {

				reqD = request.getRequestDispatcher("");  	
			}
		}
		else if (resultado.getMsg() != null){
		
				request.getSession().setAttribute("resultado", resultado);
				reqD = request.getRequestDispatcher("Perfil.jsp");  	
			
		}
		reqD.forward(request,response); 
		
	}

}
