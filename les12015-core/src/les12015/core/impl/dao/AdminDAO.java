package les12015.core.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Administrador;
import les12015.dominio.Cliente;
import les12015.dominio.EntidadeDominio;

public class AdminDAO extends AbstractJdbcDAO{

	public AdminDAO() {
		super("", "");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		openConnection();
		PreparedStatement pst = null;
		Administrador  admin = (Administrador)entidade;
		
		try {
			connection.setAutoCommit(false);		
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("INSERT INTO admin (adm_nome)");
			sql.append(" VALUES (?)");	
			
			//Retornar o ID gerado automaticamente
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);

			
			
			pst.setString(1, admin.getNome());

			pst.executeUpdate();	
			ResultSet result = pst.getGeneratedKeys();
			result.next();	
			int id= result.getInt(1);
			admin.setId(id);
			connection.commit();	
			
			LoginDAO daoLogin = new LoginDAO();
			daoLogin.salvar(admin);
			
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		PreparedStatement pst = null;
		Administrador admin = (Administrador) entidade;
		List<EntidadeDominio> admins = new ArrayList<EntidadeDominio>();
		String sql = null;
		
		
		//Juntando as tabelas
		sql= "SELECT * FROM admin INNER JOIN login ON admin.adm_id = login.log_adm_id ";
				
		if(admin.getId()!= null && admin.getId() > 0) {
			sql = sql + "WHERE adm_id = " + admin.getId() + "" ;
		}else {
			sql = sql + "WHERE 1 = 1";
			
			if(admin.getNome() != null && !admin.getNome().trim().equals(""))
				sql = sql + " AND adm_nome like '%" + admin.getNome() + "%'";
			
		}
			
		//try catch
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while(result.next()) {
				admin = new Administrador();
				
				//Pegando os atributos de cliente
				admin.setNome(result.getString("adm_nome"));
				admin.setId(result.getInt("adm_id"));
				admin.setEmail(result.getString("log_email"));
				admin.setStatus(result.getBoolean("log_status"));
				
				
				admins.add(admin);
			}
			
			return admins;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

}
