package les12015.core.impl.negocio;

import les12015.core.IStrategy;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Livro;

public class ValidarPrecoLivro implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		if (entidade instanceof Livro) {
			Livro liv = (Livro) entidade;
			if (((liv.getPrecificacao().getMargemLucro() * liv.getCusto()) / 100) + liv.getCusto() > liv.getPreco()) {
				return "Esse valor esta abaixo do lucro estabelecido";
			}
			return "Essa nao é uma entidade de Livro";

		}
		return null;
	}

}
