package les12015.core.impl.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import les12015.core.IStrategy;
import les12015.core.impl.dao.FornecedorDAO;
import les12015.dominio.Aquisicao;
import les12015.dominio.EntidadeDominio;

public class ValidarCamposEstoque implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		if(entidade instanceof Aquisicao){
            Aquisicao aqui = (Aquisicao)entidade;
            FornecedorDAO dao = new FornecedorDAO();
            List<EntidadeDominio> fornecedores;

            if(aqui.getFornecedor().getId() == null || aqui.getLivro().getId() == null){
                return "Os ID's devem ser preenchidos";
            }
            try {
				fornecedores = new ArrayList<EntidadeDominio>(dao.consultar(aqui.getFornecedor()));
				 if(fornecedores.get(0) == null) {
		            	return "Esse id nao existe";
		            }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
          
           
            
            if(aqui.getDtCadastro()==null){
                return "Data deve ser preenchido";
            }
            if(aqui.getPreco() < 0 || aqui.getQuantidade() < 0){
                return "Preço e/ou Quantidade nao válidos";
            }

        }else{
            return "Essa não é uma entidade Aquisição";
        }
        return null;
	}

}
