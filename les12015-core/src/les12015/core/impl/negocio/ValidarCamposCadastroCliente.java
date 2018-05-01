package les12015.core.impl.negocio;

import java.util.ArrayList;
import java.util.List;

import les12015.core.IStrategy;
import les12015.core.impl.dao.ClienteDAO;
import les12015.dominio.Cliente;
import les12015.dominio.EntidadeDominio;

public class ValidarCamposCadastroCliente implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Cliente cli = (Cliente) entidade;
		ClienteDAO dao = new ClienteDAO();
		List<EntidadeDominio> clientes;
		
		// pattern da senha com numeros, letras minusculas, minusculas, e caracteres especiais
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		try {
			if (cli.getNome().equals("") || cli.getNome() == null)
				return "Nome precisa ser preenchido!";
			
			if (cli.getCpf().equals("") || cli.getCpf() == null)
				return "CPF precisa ser preenchido!";
			
			if (cli.getEmail().equals("") || cli.getEmail() == null)
				return "Email precisa ser preenchido!";

			if (cli.getSenha().equals("") || cli.getSenha() == null)
				return "Senha precisa ser preenchida!";
			
			if(!cli.getSenha().matches(pattern))
				return "A senha precisa ter letras minusculas, maiusculas, numeros e caracteres especiais!";
			
			if(!cli.getSenha().equals(cli.getConfSenha()))
				return "As senhas devem ser identicas!";
			
			clientes = new ArrayList<EntidadeDominio>(dao.consultar(cli));
			if(cli.getEmail().equals(((Cliente) clientes.get(0)).getEmail()))
				return "Este email já está cadastrado!";
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
