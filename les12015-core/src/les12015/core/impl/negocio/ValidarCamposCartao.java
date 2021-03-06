package les12015.core.impl.negocio;

import les12015.core.IStrategy;
import les12015.dominio.Cartao;
import les12015.dominio.EntidadeDominio;

public class ValidarCamposCartao implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		Cartao car = (Cartao) entidade;
		
		if(car.getNumero() == null || car.getNumero().equals(""))
			return "O n�mero do cart�o deve ser preenchido!";
		
		if(car.getCodSeguranca() == null || car.getCodSeguranca().equals(""))
			return "O c�digo de seguran�a deve ser preenchido";
		
		if(car.getCodSeguranca().length() > 4 || car.getCodSeguranca().length() < 3)
			return "O c�digo de seguran�a deve ter entre 3 e 4 d�gitos";
		
		if(car.getTitular().equals("") || car.getTitular() == null)
			return "O nome do titular deve ser preenchido!";
		
		if(car.getDataVenc().equals("") || car.getDataVenc() == null)
			return "A data deve ser preenchida";
		
		return null;
	}

}
