package les12015.core.impl.negocio;

import les12015.core.IStrategy;
import les12015.dominio.Endereco;
import les12015.dominio.EntidadeDominio;

public class ValidarCamposEndereco implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Endereco end = (Endereco) entidade;
		if (end.getBairro().equals("") || end.getBairro() == null)
			return "O Bairro deve ser preenchido!";

		if (end.getCep().equals("") || end.getCep() == null)
			return "O CEP deve ser preenchido!";

		if (end.getCidade().equals("") || end.getCidade() == null)
			return "A cidade deve ser preenchida!";

		if (end.getEstado().equals("") || end.getEstado() == null)
			return "O Estado deve ser preenchido!";

		if (end.getNumero().equals("") || end.getNumero() == null)
			return "O Número deve ser preenchido!";

		if (end.getRua().equals("") || end.getRua() == null)
			return "A rua deve ser preenchida!";
		
		
		if (end.getIdentificacao().equals("") || end.getIdentificacao() == null)
			return "A Identificação deve ser preenchida";
		
		return null;
	}

}
