package les12015.core.impl.negocio;

import les12015.core.IStrategy;
import les12015.dominio.Endereco;
import les12015.dominio.EntidadeDominio;

public class ValidarCamposEndereco implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Endereco end = (Endereco) entidade;
		if ( end.getBairro() == null || end.getBairro().equals(""))
			return "Todos os campos de Endereço devem ser preenchidos!";

		if (  end.getCep() == null  || end.getCep().equals(""))
			return "Todos os campos de Endereço devem ser preenchidos!";

		if (end.getCidade() == null || end.getCidade().equals(""))
			return "Todos os campos de Endereço devem ser preenchidos!";
		if (end.getEstado() == null || end.getEstado().equals(""))
			return "Todos os campos de Endereço devem ser preenchidos!";

		if (end.getNumero() == null || end.getNumero().equals(""))
			return "Todos os campos de Endereço devem ser preenchidos!";

		if (end.getRua() == null || end.getRua().equals(""))
			return "Todos os campos de Endereço devem ser preenchidos!";
		
		
		if (end.getIdentificacao() == null || end.getIdentificacao().equals(""))
			return "A Identificação deve ser preenchida";
		
		return null;
	}

}
