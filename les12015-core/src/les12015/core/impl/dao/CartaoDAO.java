package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Cartao;
import les12015.dominio.Cliente;
import les12015.dominio.EntidadeDominio;

public class CartaoDAO extends AbstractJdbcDAO{

	public CartaoDAO() {
		super("cartao", "car_id");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		openConnection();
		PreparedStatement pst = null;
		Cartao  cartao = (Cartao) entidade;
		
		try {
			connection.setAutoCommit(false);		
			StringBuilder sql = new StringBuilder();
			
			sql.append("INSERT INTO cartao(car_cli_id, car_titular, car_numero, car_cod_seg, car_data_venc, car_preferencial)");
			sql.append(" VALUES (?,?,?,?,?,?)");	
			
			//Retornar o ID gerado automaticamente
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setInt(1, cartao.getIdCliente());
			pst.setString(2,cartao.getTitular());
			pst.setString(3, cartao.getNumero());
			pst.setString(4, cartao.getCodSeguranca());
			pst.setString(5, cartao.getDataVenc());
			pst.setBoolean(6, cartao.isPreferencial());
			
			pst.executeUpdate();	
			
			ResultSet result = pst.getGeneratedKeys();
			result.next();
			int id= result.getInt(1);
			cartao.setId(id);
			
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
	public void alterar(EntidadeDominio entidade) throws SQLException {
		openConnection();
		PreparedStatement pst = null;
		Cartao cartao = (Cartao)entidade;
		
		try {
			connection.setAutoCommit(false);		
			StringBuilder sql = new StringBuilder();
			
			sql.append("UPDATE cartao SET car_preferencial=?");
			sql.append(" WHERE car_id=?");			
			
			pst = connection.prepareStatement(sql.toString());
			
			pst.setBoolean(1, cartao.isPreferencial());
			pst.setInt(2, cartao.getId());
			
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
		
		Cliente cliente = (Cliente) entidade;
		String sql=null;
		
		sql = "SELECT * FROM cartao WHERE car_cli_id = "
				+ cliente.getId();
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> cartoes = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Cartao car = new Cartao();
				car.setId(rs.getInt("car_id"));
				car.setTitular(rs.getString("car_titular"));
				car.setCodSeguranca(rs.getString("car_data_venc"));
				car.setNumero(rs.getString("car_numero"));
				car.setPreferencial(rs.getBoolean("car_preferencial"));
				
				cartoes.add(car);
			}
			return cartoes;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
