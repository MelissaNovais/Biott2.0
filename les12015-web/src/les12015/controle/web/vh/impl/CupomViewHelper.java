package les12015.controle.web.vh.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import les12015.controle.web.vh.IViewHelper;
import les12015.core.aplicacao.Resultado;
import les12015.dominio.Cupom;
import les12015.dominio.EntidadeDominio;

public class CupomViewHelper implements IViewHelper{

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		Cupom cupom = new Cupom(); 
		
		if(operacao.equals("CONSULTAR")|| operacao.equals("SALVAR") ) {
			String idCupom = request.getParameter("txtIdCupom");
			String codCupom = request.getParameter("txtCodCupom");
			String valor = request.getParameter("txtValorCupom");
			String idCliente = request.getParameter("txtIdCliente");
			
			if (idCupom != null && !idCupom.trim().equals("")) {
                cupom.setId(Integer.parseInt(idCupom));
            }
			if (valor != null && !valor.trim().equals("")) {
               cupom.setValor(Double.parseDouble(valor));
            }
			if (idCliente != null && !idCliente.trim().equals("")) {
                cupom.getCliente().setId(Integer.parseInt(idCliente));
            }
			if (codCupom != null && !codCupom.trim().equals("")) {
                cupom.setCodigo((codCupom));
            }
		}
		
		if (operacao.equals("EXCLUIR")) {
			
		}
		if (operacao.equals("EXCLUIR")) {
			
		}
		return cupom;
	}

	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		RequestDispatcher reqD = null;
		String uri = request.getRequestURI();
		String operacao = request.getParameter("operacao");
		
		
		if(resultado.getMsg() == null){
			if(operacao.equals("SALVAR")){
				 
			}
			if(operacao.equals("EXCLUIR")){
				
			}
			else if (operacao.equals("CONSULTAR")) {
				request.getSession().setAttribute("cupons", resultado.getEntidades()); 	
			}
		}
		else if (resultado.getMsg() != null){
			if(operacao.equals("SALVAR")){
				request.getSession().setAttribute("resultado", resultado);  	
			}
			else if(operacao.equals("CONSULTAR")){
				request.getSession().setAttribute("resultado", resultado);	
				
			}
		}
		/**
		 * Tem diferentes paginas q pedem consultar clientes 
		 * 	dependendo de quem pediu (uri) ... ele devolve
		 */
		if (uri.equals("/les12015-web/ConsultarCupomCliente")) {
			reqD = request.getRequestDispatcher("Perfil.jsp");  	
		}
		else if (uri.equals("/les12015-web/ConsultarCupomCompra")) {
			reqD = request.getRequestDispatcher("FinalizandoCompra.jsp");  	
		}
		reqD.forward(request,response); 
		
	}

}
