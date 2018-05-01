package les12015.core.impl.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import les12015.core.IStrategy;
import les12015.core.impl.dao.LivroDAO;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Livro;

public class ValidarIdLivro implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		if(entidade instanceof Livro){
			Livro liv = (Livro)entidade;
			LivroDAO dao = new LivroDAO();
			List<EntidadeDominio> livros;
			try {
				
				livros = new ArrayList<EntidadeDominio>(dao.consultar(liv));
				 if(livros.get(0) == null) {
					return "Esse ID não existe";
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

}
