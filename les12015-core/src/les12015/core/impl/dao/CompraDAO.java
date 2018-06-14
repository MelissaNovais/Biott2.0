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
		ItemCompraDAO daoItensCompra = new ItemCompraDAO();

		try {
			connection.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();
			if (compra.getCartao().getId() != null && compra.getCupom().getId() != null) {//Se pagar com cartao e cupom
				
				sql.append("INSERT INTO compra(com_cli_id, com_end_id, com_car_id, com_cup_id, com_valor_total, com_data)");
				sql.append(" VALUES (?,?,?,?,?,?)");
				
				pst = connection.prepareStatement(sql.toString(), 
						Statement.RETURN_GENERATED_KEYS);
				
				pst.setInt(1, compra.getCliente().getId());
				pst.setInt(2, compra.getEnd().getId());
				pst.setInt(3, compra.getCartao().getId());
				pst.setInt(4, compra.getCupom().getId());
				pst.setDouble(5, compra.getValorTotal());
				pst.setString(6, compra.getData());
			}
			else if (compra.getCartao() != null){ //Se pagar soh com cartao
				
				sql.append("INSERT INTO compra(com_cli_id, com_end_id, com_car_id, com_valor_total, com_data)");
				sql.append(" VALUES (?,?,?,?,?)");
				
				pst = connection.prepareStatement(sql.toString(), 
						Statement.RETURN_GENERATED_KEYS);
				
				pst.setInt(1, compra.getCliente().getId());
				pst.setInt(2, compra.getEnd().getId());
				pst.setInt(3, compra.getCartao().getId());
				pst.setDouble(4, compra.getValorTotal());
				pst.setString(5, compra.getData());
			} 
			else {//Se pagar soh com cupom
				sql.append("INSERT INTO compra(com_cli_id, com_end_id, com_cup_id, com_valor_total, com_data)");
				sql.append(" VALUES (?,?,?,?,?)");
				
				pst = connection.prepareStatement(sql.toString(), 
						Statement.RETURN_GENERATED_KEYS);
				
				pst.setInt(1, compra.getCliente().getId());
				pst.setInt(2, compra.getEnd().getId());
				pst.setInt(3, compra.getCupom().getId());
				pst.setDouble(4, compra.getValorTotal());
				pst.setString(5, compra.getData());
			}

			
			
			
			pst.executeUpdate();	
			ResultSet result = pst.getGeneratedKeys();
			result.next();	
			int id= result.getInt(1);
			compra.setId(id);
			connection.commit();
			daoItensCompra.salvar(compra); //Salvar cada item dessa copra
				
			
			
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
		sql= "SELECT * FROM compra INNER JOIN endereco ON compra.com_end_id = endereco.end_id\r\n" + 
				"					INNER JOIN cliente ON cliente.cli_id = compra.com_cli_id\r\n" + 
				"					INNER JOIN login ON cliente.cli_id = login.log_cli_id\r\n" + 
				"					INNER JOIN cartao ON cartao.car_id = compra.com_car_id";
		
		if(compra.getId() > 0) {
			sql = sql + " WHERE com_id = " + compra.getId() + "";
		//try catch
		}
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while(result.next()) {
				compra = new Compra();
				
				//Pegando os atributos de cliente
				compra.setData(result.getString("com_data"));
				compra.setId(result.getInt("com_id"));
				compra.setValorTotal(result.getDouble("com_valor_total"));
				
				compra.getCartao().setCodSeguranca(result.getString("car_cod_seg"));
				compra.getCartao().setNumero(result.getString("car_numero"));
				compra.getCartao().setTitular(result.getString("car_titular"));
				compra.getCartao().setId(result.getInt("car_id"));
				
				compra.getEnd().setIdentificacao(result.getString("end_identificacao"));
				compra.getEnd().setBairro(result.getString("end_bairro"));
				compra.getEnd().setCidade(result.getString("end_cidade"));
				compra.getEnd().setCep(result.getString("end_cep"));
				compra.getEnd().setEstado(result.getString("end_estado"));
				compra.getEnd().setNumero(result.getString("end_numero"));
				compra.getEnd().setRua(result.getString("end_rua"));
				compra.getEnd().setId(result.getInt("end_id"));
				
				compra.getCupom().setId(result.getInt("com_cup_id"));
				
				compra.getCliente().setCpf(result.getString("cli_cpf"));
				compra.getCliente().setEmail(result.getString("log_email"));
				compra.getCliente().setNome(result.getString("cli_nome"));
				compra.getCliente().setId(result.getInt("cli_id"));
				
				ItemCompraDAO daoItens = new ItemCompraDAO();
				List<EntidadeDominio> itens = new ArrayList<EntidadeDominio>();
				itens =  daoItens.consultar(compra);
				
				for (EntidadeDominio item : itens) {
					compra.getCarrinho().add((ItemCompra) item);
				}
				compras.add(compra);
			}
			
			return compras;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
