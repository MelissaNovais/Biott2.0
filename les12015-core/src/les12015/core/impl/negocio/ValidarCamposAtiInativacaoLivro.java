package les12015.core.impl.negocio;

import les12015.core.IStrategy;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.LivroMotivoStatus;

public class ValidarCamposAtiInativacaoLivro implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		if(entidade instanceof LivroMotivoStatus){
			LivroMotivoStatus lms = (LivroMotivoStatus)entidade;
			
			if(lms.getLivro().getId() == null) {
				return "Id do livro deve ser preenchido ";
			}
			
			if(lms.getStatus()== null) { 
				return "Especifique se a a��o � uma Ativa��o ou Inativa��o de Livro";
			}
			
			if(lms.getStatus() && lms.getCatAtivacoes()==null  ) {
				return "Categoria de Ativa��o deve ser preenchido ";
			}
			
			if(!lms.getStatus() && lms.getCatInativacoes() == null ) {
				return "Categoria de Inativa��o deve ser preenchido ";
			}
			if(lms.getDescricao()==null) {
				return "Preencha os detalhes do motivo dessa a��o";
			}
			
			
		}else{
			return "A entidade nao � um Motivo de Status!";
		}
		return null;
	}

}
