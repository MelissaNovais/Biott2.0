package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Cliente;
import les12015.dominio.Compra;
import les12015.dominio.EntidadeDominio;

public class CompraDAO extends AbstractJdbcDAO {

	public CompraDAO() {
		super("compra", "com_id");
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub

		openConnection();
		PreparedStatement pst = null;
		Compra compra = (Compra) entidade;

		try {
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO compra(com_cli_id, com_end_id, com_car_id, com_cup_id, com_valor_total, com_data)");
			sql.append(" VALUES (?,?,?,?,?,?)");
			
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, compra.getCliente().getId());
			pst.setString(2, compra.getEnd().getId());
			pst.setString(3, compra.getCartao().getId());
			pst.setString(4, compra.getCupom().getId());
			pst.setString(5, compra.getValorTotal());
			pst.setString(6, compra.getData());
			
			pst.executeUpdate();	
			ResultSet result = pst.getGeneratedKeys();
			result.next();	
			int id= result.getInt(1);
			compra.setId(id);	
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
		Compra compra = (Compra) entidade;
		List<EntidadeDominio> compras = new ArrayList<EntidadeDominio>();
		String sql = null;
		
		//Juntando as tabelas
		sql= "";
		
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while(result.next()) {
				compra = new Compra();
				
				//Pegando os atributos de cliente
				compra.set(result.getString("com_"));
				
				compras.add(compra);
			}
			return compras;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

}
