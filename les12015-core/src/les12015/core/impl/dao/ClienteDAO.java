
package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Cliente;
import les12015.dominio.EntidadeDominio;

public class ClienteDAO extends AbstractJdbcDAO {
	
	public ClienteDAO() {
		super("cliente", "cli_id");		
		
	}
	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Cliente  cliente = (Cliente)entidade;
		
		try {
			connection.setAutoCommit(false);		
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("INSERT INTO cliente (cli_email, cli_nome, cli_cpf)");
			sql.append(" VALUES (?,?,?)");	
			
			//Retornar o ID gerado automaticamente
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);

			
			pst.setString(1,cliente.getEmail());
			pst.setString(2, cliente.getNome());
			pst.setString(3, cliente.getCpf());

			pst.executeUpdate();	
			ResultSet result = pst.getGeneratedKeys();
			result.next();	
			int id= result.getInt(1);
			cliente.setId(id);
			connection.commit();	
			
			LoginDAO daoLogin = new LoginDAO();
			daoLogin.salvar(cliente);
			
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
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		Cliente cliente = (Cliente) entidade;
		List<EntidadeDominio> clientes = new ArrayList<EntidadeDominio>();
		String sql = null;
		
		
		//Juntando as tabelas
		sql= "SELECT * FROM cliente INNER JOIN login ON cliente.cli_id = login.log_cli_id ";
				
		if(cliente.getId()!= null && cliente.getId() > 0) {
			sql = sql + "WHERE cli_id = " + cliente.getId() + "" ;
		}else {
			sql = sql + "WHERE 1 = 1";
			if(cliente.getNome() != null)
				sql = sql + " AND cli_nome like '%" + cliente.getNome() + "%'";
			if(cliente.getCpf() != null)
				sql = sql + " AND cli_cpf like '" + cliente.getCpf() + "'";
			if(cliente.getEmail() != null)
				sql = sql + " AND log_email like '" + cliente.getEmail() + "'";
		}
			
		//try catch
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while(result.next()) {
				cliente = new Cliente();
				
				//Pegando os atributos de cliente
				cliente.setCpf(result.getString("cli_cpf"));
				cliente.setNome(result.getString("cli_nome"));
				cliente.setId(result.getInt("cli_id"));
				cliente.setEmail(result.getString("log_email"));
				
				
				clientes.add(cliente);
			}
			return clientes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

	
	

	

}
