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

import les12015.dominio.EntidadeDominio;
import les12015.dominio.Login;

public class LoginDAO extends AbstractJdbcDAO {

	public LoginDAO() {
		super("login", "log_id");
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		openConnection();
		PreparedStatement pst = null;
		Login login = (Login) entidade;

		try {
			connection.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();
			
			if(login.getTipoUsuario().equals("cliente")) {
				sql.append("INSERT INTO login(log_email, log_senha, log_cli_id)");
				sql.append(" VALUES (?,?,?)");
			}
			else if(login.getTipoUsuario().equals("admin")) {
				sql.append("INSERT INTO login(log_email, log_senha, log_adm_id)");
				sql.append(" VALUES (?,?,?)");
			}

			

			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			
			try {
				MessageDigest md  = MessageDigest.getInstance("MD5");
				BigInteger hash = new BigInteger(1, md.digest( login.getSenha().getBytes()));
	            login.setSenha (hash.toString());
	                
	            
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
			pst.setString(1, login.getEmail());
			pst.setString(2, login.getSenha());
			pst.setInt(3, login.getId());

			pst.executeUpdate();

			ResultSet result = pst.getGeneratedKeys();
			result.next();
			int id = result.getInt(1);
			login.setId(id);

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
		openConnection();
		PreparedStatement pst = null;
		Login login  = (Login) entidade;		
		
		try {
			connection.setAutoCommit(false);			
			String sql = null;
			sql = "UPDATE login SET ";
			
			if(login.getSenha() != null) {
				 sql = sql + "log_senha = ";
				try {
					MessageDigest md = MessageDigest.getInstance("MD5");
					BigInteger hash = new BigInteger(1, md.digest( login.getSenha().getBytes()));
			        login.setSenha (hash.toString());
			        sql = sql + "'" + login.getSenha()  + "'";
				} catch (NoSuchAlgorithmException e) {
					
					e.printStackTrace();
				}	
			}

			pst = connection.prepareStatement(sql);

			sql = sql + "WHERE log_cli_id=" + login.getId()	+ " AND cli_status = 1";		
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
		Login login  = (Login) entidade;		
		
		List<EntidadeDominio> logins = new ArrayList<EntidadeDominio>();
		String sql = null;

		sql = "SELECT * FROM login WHERE log_email = '" + login.getEmail() + "' AND log_senha = ";
		
			try {
				MessageDigest md  = MessageDigest.getInstance("MD5");
				BigInteger hash = new BigInteger(1, md.digest( login.getSenha().getBytes()));
				 login.setSenha (hash.toString());
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
				Login log = new Login();
				
				// Pegando os atributos login
				log.setEmail(result.getString("log_email"));
				log.setId(result.getInt("log_id"));
				log.setSenha(result.getString("log_senha"));
				
				int idCliente = result.getInt("log_cli_id");
				int idAdmin = result.getInt("log_adm_id");
				
				if (idCliente > 0) {
					log.setTipoUsuario("cliente");
					log.setIdUsuario(idCliente);
				}
				else if (idAdmin > 0) {
					log.setTipoUsuario("admin");
					log.setIdUsuario(idAdmin);
				}
				System.out.println(log.getEmail());
				System.out.println(log.getSenha());
				logins.add(log);
			}
			
			
			System.out.println("Array DAO " +  logins.size());
			return logins;
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
			
	}

}
