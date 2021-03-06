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
import les12015.dominio.Cliente;
import les12015.dominio.Endereco;
import les12015.dominio.EntidadeDominio;

public class EnderecoViewHelper implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String operacao = request.getParameter("operacao");
		Endereco endereco = new Endereco();
		
		
		String rua = request.getParameter("txtRua");
		String cep = request.getParameter("txtCep");
		String numero = request.getParameter("txtNumero");
		String bairro = request.getParameter("txtBairro");
		String cidade = request.getParameter("txtCidade");
		String estado = request.getParameter("txtEstado");
		String identificacao = request.getParameter("txtIdentificacaoEnd");
		Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");

		if (operacao.equals("SALVAR")) {
			endereco.setNumero(numero);
			endereco.setRua(rua);
			endereco.setBairro(bairro);
			endereco.setCidade(cidade);
			endereco.setEstado(estado);
			endereco.setCep(cep);
			endereco.setIdentificacao(identificacao);
			endereco.setPereferencial(true);
			endereco.setIdCliente(cliente.getId());
		}
		
		return endereco;
	}

	@SuppressWarnings("unchecked")
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher reqD = null;
		String operacao = request.getParameter("operacao");
		String uri = request.getRequestURI();
		
		if (resultado.getMsg() == null) {
			if (operacao.equals("SALVAR")) {
				resultado.setMsg("Endere�o Cadastrado com Sucesso!!");
				request.getSession().setAttribute("resultado", resultado);
				List<EntidadeDominio> enderecos = new ArrayList<EntidadeDominio>();
				enderecos = (List<EntidadeDominio>) request.getSession().getAttribute("enderecos");
				enderecos.add((EntidadeDominio) resultado.getEntidades().get(resultado.getEntidades().size() - 1));
				request.getSession().setAttribute("enderecos", enderecos);
				if(uri.equals("/les12015-web/EnderecoCompraCompra")) 
					reqD = request.getRequestDispatcher("FinalizandoCompra.jsp");  
				else
					reqD = request.getRequestDispatcher("Perfil.jsp");  
				
			}
			if (operacao.equals("EXCLUIR")) {
				reqD = request.getRequestDispatcher("");
				resultado.setMsg("Esse Cart�o foi Excluido com sucesso");
			} else if (operacao.equals("CONSULTAR")) {

				reqD = request.getRequestDispatcher("");
			}
		} else if (resultado.getMsg() != null) {

			request.getSession().setAttribute("resultado", resultado);
			reqD = request.getRequestDispatcher("Perfil.jsp");

		}
		reqD.forward(request, response);

	}

}
