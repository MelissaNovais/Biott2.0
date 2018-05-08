package les12015.core.impl.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Compra;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.ItemCompra;
import les12015.dominio.Login;

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
		Compra compra  = (Compra) entidade;

		try {
			connection.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();
			
			sql.append("INSERT INTO item_compra(ite_compra_id, ite_livro_id, ite_qtde)");
			sql.append("VALUES (?,?,?)");
			
			
			for (ItemCompra item : compra.getCarrinho()) {
				pst = connection.prepareStatement(sql.toString(), 
						Statement.RETURN_GENERATED_KEYS);
				
				pst.setInt(1,compra.getId());
				pst.setInt(2, item.getLivro().getId());
				pst.setInt(3, item.getQtde()); 
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
		openConnection();
		PreparedStatement pst = null;
		Compra compra = (Compra) entidade;		
		
		/*List<EntidadeDominio> logins = new ArrayList<EntidadeDominio>();
		String sql = null;

		sql = "SELECT * FROM login WHERE log_email = '" + login.getEmail() + "' AND log_senha = '";
		
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				String senha = login.getSenha();
				BigInteger hash = new BigInteger(1, md.digest( senha.getBytes()));
				senha =  (hash.toString());
				login.setSenha(senha);
	            sql = sql + "'" + login.getSenha()  + "'";
	          
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		

		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				login = new Login();
				// Pegando os atributos login
				login.setEmail(result.getString("log_email"));
				login.setId(result.getInt("log_id"));
				login.setSenha(result.getString("log_senha"));
				logins.add(login);
			}
			return logins;
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		return null;
	}

}
