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
import les12015.dominio.Livro;
import les12015.dominio.StatusDeCompra;

public class ItemCompraDAO extends AbstractJdbcDAO {

	public ItemCompraDAO() {
		super("item_compra", "ite_id");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pst = null;
		
		Compra compra  = (Compra) entidade;

		try {
			
			
			for (ItemCompra item : compra.getCarrinho()) {
				openConnection();
				
				
				connection.setAutoCommit(false);
				StringBuilder sql = new StringBuilder();
				
				sql.append("INSERT INTO item_compra(ite_compra_id, ite_livro_id, ite_qtde, ite_status)");
				sql.append("VALUES (?,?,?,?)");
				
				pst = connection.prepareStatement(sql.toString(), 
						Statement.RETURN_GENERATED_KEYS);
				
				pst.setInt(1,compra.getId());
				pst.setInt(2, item.getLivro().getId());
				pst.setInt(3, item.getQtde()); 
				pst.setInt(4, item.getStatusDaCompra().getId()); 
				
				pst.executeUpdate();	
				ResultSet result = pst.getGeneratedKeys();
				result.next();	
				int id= result.getInt(1);
				item.setId(id);	
				connection.commit();	
			}
			
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
		openConnection();
		PreparedStatement pst = null;
		ItemCompra itemCompra  = (ItemCompra) entidade;		
		
		try {
			connection.setAutoCommit(false);			
					
			String sql = null;
			sql = "UPDATE item_compra SET ite_status = " + itemCompra.getStatusDaCompra();

			pst = connection.prepareStatement(sql);

			sql = sql + " WHERE ite_id = " + itemCompra.getId()+ "";		
			
			pst.executeUpdate();			
			connection.commit();
			
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	

	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		PreparedStatement pst = null;
		Compra compra = (Compra) entidade;
		List<EntidadeDominio> itens = new ArrayList<EntidadeDominio>();
		String sql = null;
		
		
		//Juntando as tabelas
		sql= "SELECT * FROM item_compra INNER JOIN livro ON item_compra.ite_livro_id = livro.liv_id"
							+ " INNER JOIN status_compra ON item_compra.ite_status = status_compra.sco_id"
							+ " where ite_compra_id =  " + compra.getId() + "";
			
		//try catch
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while(result.next()) {
				ItemCompra item = new ItemCompra();
				StatusDeCompra status = new StatusDeCompra();
				Livro liv = new Livro();
				//Pegando os atributos de cliente
				item.setId(result.getInt("ite_id"));
				item.setQtde(result.getInt("ite_qtde"));
				
				liv.setId(result.getInt("ite_livro_id"));
				liv.setTitulo(result.getString("liv_titulo"));
				liv.setPreco(result.getDouble("liv_preco"));
				
				item.setLivro(liv);
				
				status.setId(result.getInt("ite_status"));
				status.setNomeStatus(result.getString("sco_status"));
				item.setStatusDaCompra(status);
				
				
				itens.add(item);
			}
			
			return itens;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

}
