package les12015.core.impl.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import les12015.core.IStrategy;
import les12015.core.impl.dao.LoginDAO;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Login;

public class ValidarCamposLogin implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Login log = (Login) entidade;
		LoginDAO dao = new LoginDAO();
		List<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();
		
		if (log.getEmail().equals("") || log.getEmail() == null)
				return "Email precisa ser preenchido!";

		if (log.getSenha().equals("") || log.getSenha() == null)
				return "Senha precisa ser preenchida!";
		
		try {
			lista = dao.consultar(log);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (lista.isEmpty()) {
			return "E-mail ou senha erradas!";
		}
		

		return null;
	}

}
