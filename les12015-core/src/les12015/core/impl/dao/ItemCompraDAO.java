package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Compra;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.ItemCompra;

public class ItemCompraDAO extends AbstractJdbcDAO {

	public ItemCompraDAO() {
		super("item_compra", "ite_id");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub

		openConnection();
		PreparedStatement pst = null;
		ItemCompra itemCompra = (ItemCompra)entidade;

		try {
			connection.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();
			
			sql.append("INSERT INTO item_compra(ite_compra_id, ite_livro_id, ite_status, ite_qtde)");
			sql.append("VALUES (?,?,?,?)");
			
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			// qual é o 1??? ite_id` ou `ite_compra_id` ???	
			pst.setString(1, itemCompra.get);
			pst.setInt(2,itemCompra.getLivro().getId());
			pst.setString(3, itemCompra.getStatusDaCompra()); // sei nao hein
			pst.setInt(4, itemCompra.getQtde());
			
			
			pst.executeUpdate();	
			ResultSet result = pst.getGeneratedKeys();
			result.next();	
			int id= result.getInt(1);
			itemCompra.setId(id);	
			connection.commit();	
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void alterar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {

		PreparedStatement pst = null;
		ItemCompra itemCompra = (ItemCompra) entidade;
		List<EntidadeDominio> compras = new ArrayList<EntidadeDominio>();
		String sql = null;
		
		//Juntando as tabelas
		sql= "";
		
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while(result.next()) {
				itemCompra = new ItemCompra();
				
				//Pegando os atributos de cliente
				itemCompra.set(result.getString("com_"));
				
				compras.add(itemCompra);
			}
			return compras;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
