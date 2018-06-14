package les12015.controle.web.vh.impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import les12015.controle.web.vh.IViewHelper;
import les12015.core.aplicacao.Resultado;
import les12015.dominio.Autor;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.ItemCompra;
import les12015.dominio.Livro;

public class CarrinhoViewHelper implements IViewHelper{

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		ItemCompra item = new ItemCompra();
		
		if (operacao.equals("SALVAR")) { //Adicionar um livro no carrinho

			/*String idLivro = request.getParameter("txtIdLivro");
			String qtde = request.getParameter("txtQtde");
			String titulo = request.getParameter("txtTitulo");
			String preco = request.getParameter("txtPreco");
		
			item.getLivro().setId(Integer.parseInt(idLivro));
			item.setQtde(Integer.parseInt(qtde));
			item.getLivro().setPreco(Integer.parseInt(preco));
			item.getLivro().setTitulo(titulo);
			
			*/
			
			// Soh enqt CRUD livro nao esta pronto ********************************************************************
			Livro liv = new Livro();
			Autor autor = new Autor();
			autor.setNome("Paulo José da Cunha");
			ArrayList<Autor> autores = new ArrayList<Autor>();
			autores.add(autor);
			liv.setAutores(autores);
			liv.setPreco(20.50);
			liv.setTitulo("A Volta da Pequena Sereia");
			liv.setQtdeEstoque(20);
			
			item.setLivro(liv);
			item.setQtde(4);
			System.out.println("ViewHelper Carrinho");
			ArrayList<ItemCompra> carrinho = new ArrayList<ItemCompra>(); 
			carrinho = (ArrayList<ItemCompra>) request.getSession().getAttribute("carrinho");
			carrinho.add(item);
			request.getSession().setAttribute("carrinho", carrinho);
			//***********************************************************************************************************
			
			
		}
		/*Alterar a qtde de um livro no carrinho
		 * Nao sei se verifico aqui ou soh na hora que ele clica em finalizar compra
		 * */
		if (operacao.equals("ALTERAR")) {
			
		}
		if (operacao.equals("EXCLUIR")) {//Retirar um livro do carrinho
			
		}
		return item;
	}

	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		RequestDispatcher reqD = null;
		String operacao = request.getParameter("operacao");
		
		if (resultado.getMsg() == null) {
		
			if(operacao.equals("SALVAR")) {
				
			}
		}
		
		if (resultado.getMsg() != null) {
			request.getSession().setAttribute("resultado", resultado);
		}
		
			
			reqD = request.getRequestDispatcher("Carrinho.jsp");  	
			reqD.forward(request,response); 
		
	}

}
