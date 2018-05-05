package les12015.core.impl.negocio;

import java.util.ArrayList;
import java.util.List;

import les12015.core.IStrategy;
import les12015.core.impl.dao.CartaoDAO;
import les12015.dominio.Cartao;
import les12015.dominio.EntidadeDominio;

public class ValidarCadastroCartao implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Cartao car = (Cartao) entidade;
		CartaoDAO dao = new CartaoDAO();
		Cartao carNumero = (Cartao) new EntidadeDominio();
		carNumero.setNumero(car.getNumero());
		List<EntidadeDominio> cartoes;
		try {
			cartoes = new ArrayList<EntidadeDominio>(dao.consultar(car));
			
			// ideia: Buscar todos os cart�es, e pesquisar
			ArrayList<EntidadeDominio> verificarCartoes = new ArrayList<EntidadeDominio>(dao.consultar(carNumero));
			
			if(!verificarCartoes.isEmpty())
				return "Este cart�o j� est� cadastrado!";
			
			if(!cartoes.isEmpty())
				return "J� existe um cart�o com esses dados cadastrados";

			
		} catch (Exception e) {
			// TODO: handle exception
		}

		return null;
	}

}
