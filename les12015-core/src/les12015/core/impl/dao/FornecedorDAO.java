package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.EntidadeDominio;
import les12015.dominio.Fornecedor;

public class FornecedorDAO extends AbstractJdbcDAO{

	public FornecedorDAO() {
		super("fornecedor", "for_id");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		PreparedStatement pst = null;
		
		Fornecedor fornecedor = (Fornecedor)entidade;
		String sql=null;
		
		if(fornecedor.getNome() == null){
			fornecedor.setNome("");
		}
		
		if(fornecedor.getId() == null && fornecedor.getNome().equals("")){
			sql = "SELECT * FROM fornecedor";
		}else if(fornecedor.getId() != null && fornecedor.getNome().equals("")){//Null funciona com int?
			sql = "SELECT * FROM fornecedor WHERE for_id=?";
		}else if(fornecedor.getId() == null && !fornecedor.getNome().equals("")){
			sql = "SELECT * FROM fornecedor WHERE for_nome like ?";
		
		}
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			
			if(fornecedor.getId() != null && fornecedor.getNome().equals("")){
				pst.setInt(1, fornecedor.getId());
			}else if(fornecedor.getId() == null && !fornecedor.getNome().equals("")){
				pst.setString(1, "%"+fornecedor.getNome()+"%");			
			}
		
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> fornecedores = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Fornecedor f = new Fornecedor();
				f.setId(rs.getInt("for_id"));
				f.setNome(rs.getString("for_nome"));
				fornecedores.add(f);
			}
			return fornecedores;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
