package les12015.core.impl.negocio;

import les12015.core.IStrategy;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Login;

public class ValidarCamposLogin implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Login log = (Login) entidade;

		if (log.getEmail() == null || log.getEmail().equals("") )
				return "Email precisa ser preenchido!";

		if (log.getSenha() == null || log.getSenha().equals("") )
				return "Senha precisa ser preenchida!";
		

		return null;
	}

}
