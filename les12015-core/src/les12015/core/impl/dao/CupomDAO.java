package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Cupom;
import les12015.dominio.EntidadeDominio;

public class CupomDAO extends AbstractJdbcDAO {

	public CupomDAO() {
		super("cupom", "cup_id");
		
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {

		openConnection();
		PreparedStatement pst = null;
		Cupom cupom = (Cupom)entidade;

		try {
			connection.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();
			
			sql.append("INSERT INTO cupom(cup_codigo, cup_valor, cup_cli_id)");
			sql.append("VALUES (?,?,?)");
			
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1,cupom.getCodigo());
			pst.setDouble(2, cupom.getValor());
			pst.setInt(3, cupom.getCliente().getId());
			
			pst.executeUpdate();	
			ResultSet result = pst.getGeneratedKeys();
			result.next();	
			int id= result.getInt(1);
			cupom.setId(id);	
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
		

	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		
		PreparedStatement pst = null;
		Cupom cupom = (Cupom) entidade;
		String sql = null;
		
		
		sql= "SELECT * FROM CUPOM WHERE 1 = 1";
		
		if(cupom.getId() != null) {
			sql = sql + "AND cup_id = " + cupom.getId() + "";
		}
		if (cupom.getCodigo()!= null && !cupom.getCodigo().trim().equals(""))
			sql = sql + " AND cup_codigo = '" + cupom.getCodigo() + "'";
		
		if(cupom.getCliente() != null) {
			sql = sql + " AND cup_cli_id = " + cupom.getCliente().getId() + "";
		}
		
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> cupons = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Cupom cup = new Cupom();
				cup.setId(rs.getInt("cup_id"));
				cup.setCodigo(rs.getString("cup_codigo"));
				cup.setValor(rs.getDouble("cup_valor"));
				cup.getCliente().setId(rs.getInt("cup_cli_id"));
				cup.setStatus(rs.getBoolean("cup_status"));
				cupons.add(cup);
			}
			return cupons;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
