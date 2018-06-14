package les12015.core.impl.negocio;

import les12015.core.IStrategy;
import les12015.dominio.Compra;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.ItemCompra;

public class CalcularFrete implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		Compra compra = (Compra) entidade; 
		
		//De acordo com o primeiro numero do CEP o estado eh longe de SP entao o frete eh maior
		double valorFrete = Double.parseDouble(compra.getEnd().getCep().substring(0, 1));
		
		if (valorFrete < 4 || valorFrete == 8) {
			valorFrete = 9.99;
		} else if (valorFrete == 7 || valorFrete == 9 || valorFrete == 4) {
			valorFrete = 14.99;
		}else
			valorFrete = 19.99;
		
		int adicionalTransporte = 0;
		
		for (ItemCompra item : compra.getCarrinho()) {
			adicionalTransporte = adicionalTransporte + ( (item.getLivro().getPeso() * item.getQtde())  /1000);	
		}
		
		valorFrete = valorFrete * adicionalTransporte;
		
		if (valorFrete < 9.99) {
			valorFrete = 9.99;
		}
		
		compra.setValorFrete(valorFrete);
		
		return null;
	}

}
