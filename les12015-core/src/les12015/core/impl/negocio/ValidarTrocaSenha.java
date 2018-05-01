package les12015.core.impl.negocio;

import java.util.ArrayList;
import java.util.List;

import les12015.core.IStrategy;
import les12015.core.impl.dao.ClienteDAO;
import les12015.dominio.Cliente;
import les12015.dominio.EntidadeDominio;

public class ValidarTrocaSenha implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Cliente cli = (Cliente) entidade;
		ClienteDAO dao = new ClienteDAO();
		List<EntidadeDominio> clientes;
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		try {
			clientes = new ArrayList<EntidadeDominio>(dao.consultar(cli));
			
			if (cli.getSenha().equals("") || cli.getSenha() == null)
				return "Senha precisa ser preenchida!";
			
			if (cli.getConfSenha().equals("") || cli.getConfSenha() == null)
				return "Senha precisa ser preenchida!";
			
			if(!cli.getSenha().matches(pattern))
				return "A senha precisa ter letras minusculas, maiusculas, numeros e caracteres especiais!";
			
			if(!cli.getSenha().equals(cli.getConfSenha()))
				return "As senhas devem ser identicas!";
			
			if(cli.getSenha().equals(((Cliente) clientes.get(0)).getSenha()))
				return "A senha deve ser diferente em relação à antiga!";
			
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
