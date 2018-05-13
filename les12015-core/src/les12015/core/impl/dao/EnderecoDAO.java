
package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Cliente;
import les12015.dominio.Endereco;
import les12015.dominio.EntidadeDominio;

public class EnderecoDAO extends AbstractJdbcDAO {

	
	public EnderecoDAO() {
		super("endereco", "end_id");	
	}
	
	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;
		Endereco end = (Endereco)entidade;
		
		try {
			connection.setAutoCommit(false);	
			String sql = null;
			
			sql = "INSERT INTO endereco (end_cli_id, end_cep, end_rua, end_numero, end_bairro, "
					+ "end_identificacao, end_estado, end_cidade, end_complemento, end_preferencial, end_cobranca)" 
					+ " VALUES(?,?,?,?,?,?,?,?,?,?,?);";
			
			pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pst.setInt(1, end.getIdCliente());
			pst.setString(2, end.getCep());
			pst.setString(3, end.getRua());
			pst.setString(4, end.getNumero());
			pst.setString(5, end.getBairro());
			pst.setString(6, end.getIdentificacao());
			pst.setString(7, end.getEstado());
			pst.setString(8, end.getCidade());
			pst.setString(9, end.getComplemento());
			pst.setBoolean(10, end.isPereferencial());
			pst.setBoolean(11, end.isCobranca());
			
			pst.executeUpdate();
			ResultSet rs = pst.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			end.setId(id);
			connection.commit();				
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}finally{
			if(ctrlTransaction){
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
	}

	
	@Override
	public void alterar(EntidadeDominio entidade) {
		if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		Endereco end = (Endereco)entidade;
		try {
			connection.setAutoCommit(false);
			
					
			String sql = null;
			
			sql = "UPDTAE endereco SET end_preferencial=?, end_cobranca = ?"
					+ " WHERE end_id = ?";
			
			pst = connection.prepareStatement(sql);
			
			pst.setBoolean(1, end.isPereferencial());
			pst.setBoolean(2, end.isCobranca());
			pst.setInt(3, end.getId());
			
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
			if(ctrlTransaction){
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
	}

	/** 
	 * TODO Descrição do Método
	 * @param entidade
	 * @return
	 * @see fai.dao.IDAO#consulta(fai.domain.EntidadeDominio)
	 */
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		PreparedStatement pst = null;
		Cliente cliente  = (Cliente) entidade;
		String sql = null;
		
		sql = "SELECT * FROM endereco WHERE end_cli_id = " + cliente.getId() + "";
		
		try {
			
			openConnection();
			pst = connection.prepareStatement(sql);
			
			
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> enderecos = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Endereco end = new Endereco();
				end.setId(rs.getInt("end_id"));
				end.setBairro(rs.getString("end_bairro"));
				end.setCep(rs.getString("end_cep"));
				end.setCidade(rs.getString("end_cidade"));
				end.setComplemento(rs.getString("end_complemento"));
				end.setEstado(rs.getString("end_estado"));
				end.setIdentificacao(rs.getString("end_identificacao"));
				end.setNumero(rs.getString("end_numero"));
				end.setRua(rs.getString("end_rua"));
				end.setPereferencial(rs.getBoolean("end_preferencial"));
				end.setCobranca(rs.getBoolean("end_cobranca"));
				
				enderecos.add(end);
			}
			
			return enderecos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
			
	}

}
