package les12015.core.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Compra;
import les12015.dominio.Cupom;
import les12015.dominio.EntidadeDominio;

public class CupomDAO extends AbstractJdbcDAO {

	public CupomDAO() {
		super("", "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub

		openConnection();
		PreparedStatement pst = null;
		Cupom cupom = (Cupom)entidade;

		try {
			connection.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();
			
			sql.append("INSERT INTO cupom(cup_codigo, cup_valor)");
			sql.append("VALUES (?,?)");
			
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1,cupom.getCodigo());
			pst.setString(2, cupom.getValor());
			
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
		// TODO Auto-generated method stub

	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		
		PreparedStatement pst = null;
		Cupom cupom= (Cupom) entidade;
		List<EntidadeDominio> compras = new ArrayList<EntidadeDominio>();
		String sql = null;
		
		//Juntando as tabelas
		sql= "";
		
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while(result.next()) {
				cupom = new Cupom();
				
				//Pegando os atributos de cliente
				cupom.set(result.getString("cup_"));
				
				compras.add(cupom);
			}
			return compras;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
