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

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
