package les12015.core.impl.negocio;

import java.sql.SQLException;
import java.util.ArrayList;

import les12015.core.IStrategy;
import les12015.core.impl.dao.LivroDAO;
import les12015.dominio.Compra;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Livro;

public class ValidarQtdeLivroCarrinho implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Compra compra  = (Compra) entidade;
		LivroDAO dao = new LivroDAO();
		ArrayList<EntidadeDominio> livros = new ArrayList<EntidadeDominio>();
		Livro livro = new Livro();
		Livro livroCarr = new Livro();
		
		for (EntidadeDominio livCarrinho : compra.getCarrinho()) {
			try {
				
				livros =   (ArrayList<EntidadeDominio>) dao.consultar(livCarrinho);
				livro = (Livro) livros.get(0);
				livroCarr = (Livro) livCarrinho;
				if (livro.getQtdeEstoque() < livroCarr.getQtdeEstoque() ) {
					return "Nao temos essa quantidade no estoque, sorry";
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

}
