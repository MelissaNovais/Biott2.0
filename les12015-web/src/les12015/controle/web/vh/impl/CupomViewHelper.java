package les12015.controle.web.vh.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import les12015.controle.web.vh.IViewHelper;
import les12015.core.aplicacao.Resultado;
import les12015.dominio.Cliente;
import les12015.dominio.Cupom;
import les12015.dominio.EntidadeDominio;

public class CupomViewHelper implements IViewHelper{

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		Cupom cupom = new Cupom(); 
		
		if(operacao.equals("CONSULTAR")) {
			String idCupom = request.getParameter("txtIdCupom");
			String codCupom = request.getParameter("txtCodCupom");
			String valor = request.getParameter("txtValorCupom");
			Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");
			
			if (idCupom != null && !idCupom.trim().equals("")) {
                cupom.setId(Integer.parseInt(idCupom));
            }
			if (valor != null && !valor.trim().equals("")) {
               cupom.setValor(Double.parseDouble(valor));
            }
			if (cliente != null) {
                cupom.getCliente().setId(cliente.getId());
            }
			if (codCupom == null || !codCupom.trim().equals("")) {
                cupom.setCodigo((null));
            }
			cupom.setCodigo(codCupom);
		}
		
		if (operacao.equals("EXCLUIR")) {
			
		}
		if (operacao.equals("SALVAR")) {
			
		}
		request.getSession().removeAttribute("cupom");
		request.getSession().removeAttribute("resultado");
		return cupom;
	}

	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		RequestDispatcher reqD = null;
		String operacao = request.getParameter("operacao");
		
		
		if(resultado.getMsg() == null){
			if(operacao.equals("SALVAR")){
				 
			}
			if(operacao.equals("EXCLUIR")){
				
			}
			else if (operacao.equals("CONSULTAR")) {
				request.getSession().setAttribute("cupom", resultado.getEntidades().get(0)); 	
				reqD = request.getRequestDispatcher("FinalizandoCompra.jsp");  	
				
			}
			
		}
		else if (resultado.getMsg() != null){
			if(operacao.equals("SALVAR")){
				request.getSession().setAttribute("resultado", resultado);  	
			}
			else if(operacao.equals("CONSULTAR")){
				request.getSession().setAttribute("resultado", resultado);	
				reqD = request.getRequestDispatcher("FinalizandoCompra.jsp");  	
			}
		}
		/**
		 * Tem diferentes paginas q pedem consultar clientes 
		 * 	dependendo de quem pediu (uri) ... ele devolve
		 */
		
		reqD.forward(request,response); 
		
	}

}
