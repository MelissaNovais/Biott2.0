package les12015.core.impl.negocio;

import java.util.ArrayList;
import java.util.List;

import les12015.core.IStrategy;
import les12015.core.impl.dao.EnderecoDAO;
import les12015.dominio.Endereco;
import les12015.dominio.EntidadeDominio;

public class ValidarCadastroEndereco implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Endereco end = (Endereco) entidade;
		EnderecoDAO dao = new EnderecoDAO();
		List<EntidadeDominio> enderecos;
		try {
			enderecos = new ArrayList<EntidadeDominio>(dao.consultar(end));
			if (enderecos.size() > 0)
				return "Esse endereço ja esta cadastrado";
			
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

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
