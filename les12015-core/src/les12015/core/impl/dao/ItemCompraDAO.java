package les12015.core.impl.dao;

import java.sql.SQLException;
import java.util.List;

import les12015.dominio.EntidadeDominio;

public class ItemCompraDAO extends AbstractJdbcDAO {

	public ItemCompraDAO( ) {
		super("item_compra", "ite_id");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
