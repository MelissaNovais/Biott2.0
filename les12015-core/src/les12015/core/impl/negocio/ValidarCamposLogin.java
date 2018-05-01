package les12015.core.impl.negocio;

import les12015.core.IStrategy;
import les12015.dominio.Cliente;
import les12015.dominio.EntidadeDominio;

public class ValidarCamposLogin implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Cliente cli = (Cliente) entidade;
		
		if (cli.getEmail().equals("") || cli.getEmail() == null)
				return "Email precisa ser preenchido!";

		if (cli.getSenha().equals("") || cli.getSenha() == null)
				return "Senha precisa ser preenchida!";
			
		

		return null;
	}

}
