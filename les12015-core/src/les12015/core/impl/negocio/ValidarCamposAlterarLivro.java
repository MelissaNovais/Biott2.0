package les12015.core.impl.negocio;

import les12015.core.IStrategy;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Livro;

public class ValidarCamposAlterarLivro implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		if(entidade instanceof Livro){
            Livro liv = (Livro)entidade;
          
            if(liv.getId() == null){
                return "ID deve ser preenchido";
            }
           
            		
        }else{
            return "Essa entidade nao é um livro!";
        }
        return null;
	}
	
}
