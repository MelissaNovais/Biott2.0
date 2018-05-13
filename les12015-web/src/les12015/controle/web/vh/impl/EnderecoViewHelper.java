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
import les12015.dominio.Endereco;
import les12015.dominio.EntidadeDominio;

public class EnderecoViewHelper implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String operacao = request.getParameter("operacao");
		Endereco endereco = new Endereco();

		String rua = request.getParameter("txtRua");
		String numero = request.getParameter("txtNumero");
		String bairro = request.getParameter("txtBairro");
		String cidade = request.getParameter("txtCidade");
		String estado = request.getParameter("txtEstado");
		Cliente cliente = (Cliente) request.getSession().getAttribute("cliente");

		if (operacao.equals("SALVAR")) {
			if (numero != null && !numero.trim().equals(""))
				endereco.setNumero(numero);
			if (rua != null && !rua.trim().equals(""))
				endereco.setRua(rua);
			if (bairro != null && bairro.trim().equals(""))
				endereco.setBairro(bairro);
			if (cidade != null && cidade.trim().equals(""))
				endereco.setCidade(cidade);
			if (estado != null && estado.trim().equals(""))
				endereco.setEstado(estado);
		}

		endereco.setPereferencial(true);
		endereco.setIdCliente(cliente.getId());
		return endereco;
	}

	@SuppressWarnings("unchecked")
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher reqD = null;
		String operacao = request.getParameter("operacao");
		if (resultado.getMsg() == null) {
			if (operacao.equals("SALVAR")) {
				resultado.setMsg("Cartao Cadastrado com Sucesso!!");
				request.getSession().setAttribute("resultado", resultado);
				List<EntidadeDominio> enderecos = new ArrayList<EntidadeDominio>();
				enderecos = (List<EntidadeDominio>) request.getSession().getAttribute("enderecos");
				enderecos.add((EntidadeDominio) resultado.getEntidades().get(resultado.getEntidades().size() - 1));
				request.getSession().setAttribute("enderecos", enderecos);
				reqD = request.getRequestDispatcher("Perfil.jsp");
			}
			if (operacao.equals("EXCLUIR")) {
				reqD = request.getRequestDispatcher("");
				resultado.setMsg("Esse Cartão foi Excluido com sucesso");
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
