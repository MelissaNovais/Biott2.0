package les12015.core.impl.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import les12015.core.IStrategy;
import les12015.core.impl.dao.CupomDAO;
import les12015.dominio.Cupom;
import les12015.dominio.EntidadeDominio;

public class VerificarCupom implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		CupomDAO dao = new CupomDAO();
		Cupom cupom = (Cupom) entidade;
		List<EntidadeDominio> cupons = new ArrayList<EntidadeDominio>();
		try {
			cupons =  dao.consultar(cupom);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(cupons.isEmpty()) {
			return "Esse cupom não é válido";
		}
		return null;
	}

}
