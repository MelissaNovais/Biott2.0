package les12015.core.impl.negocio;

import java.util.ArrayList;

import les12015.core.IStrategy;
import les12015.dominio.Autor;
import les12015.dominio.Categoria;
import les12015.dominio.Editora;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Livro;
import les12015.dominio.Precificacao;

public class ValidarCamposCadastroLivro implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		if(entidade instanceof Livro){
			Livro livro = (Livro)entidade;

			
			String titulo = livro.getTitulo();
			ArrayList<Autor> autores = new ArrayList<Autor>(livro.getAutores());
			ArrayList<Categoria> categorias;
			categorias = new ArrayList<Categoria>(livro.getCategorias());
			int ano = livro.getAno();
			int edicao =livro.getAno();
			String isbn = livro.getIsbn();
			String sinopse = livro.getSinopse();
			Precificacao precificacao = livro.getPrecificacao();
			double preco = livro.getPreco();
			Editora editora = livro.getEditora();
			String codBarras = livro.getCodBarras();
			int qtdeEstoque = livro.getQtdeEstoque();
			int qtdeObgVenda = livro.getQtdObgVenda();
			int peso = livro.getPeso();
			int altura = livro.getAltura();
			int profundidade = livro.getPaginas();
			int largura = livro.getLargura();
			
			
			if(titulo == null || sinopse == null || codBarras ==null || isbn == null ||
					ano < 1500 || edicao < 1 || qtdeEstoque < 1 || qtdeEstoque < 0 ||
					qtdeObgVenda < 0|| peso < 100 || altura < 10 || profundidade < 2 || largura < 5||
					preco < 10 || editora.getNome() == null || precificacao.getDescricao()== null||
					categorias.get(0).getNomeCategoria() == null || autores.get(0).getNome() == null){
				
				return "Todos os campos são de preenchimento obrigatório! Verifique os campos vazios";
			}
			
			if(titulo.trim().equals("") || sinopse.trim().equals("") ||isbn.trim().equals("")
					||editora.getNome().trim().equals("") || precificacao.getDescricao().trim().equals("")
					||categorias.get(0).getNomeCategoria().trim().equals("") 
					|| autores.get(0).getNome().trim().equals("")){
				
				return "Todos os campos são de preenchimento obrigatório! Verifique os campos vazios";
			}
			else
				return "Deve ser registrado um Livro!";

		}
		return null;
	}

}
