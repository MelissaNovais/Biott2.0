package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.EntidadeDominio;
import les12015.dominio.Precificacao;

public class PrecificacaoDAO extends AbstractJdbcDAO{

	public PrecificacaoDAO() {
		super("precificacao", "pre_id");
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
		
		Precificacao precificacao = (Precificacao)entidade;
		String sql=null;
		
		if(precificacao.getDescricao() == null){
			precificacao.setDescricao("");
		}
		
		if(precificacao.getId() == null && precificacao.getDescricao().equals("")){
			sql = "SELECT * FROM precificacao";
		}else if(precificacao.getId() != null &&precificacao.getDescricao().equals("")){//Null funciona com int?
			sql = "SELECT * FROM precificacao WHERE pre_id=?";
		}else if(precificacao.getId() == null && !precificacao.getDescricao().equals("")){
			sql = "SELECT * FROM precificacao WHERE pre_tipo like ?";
		
		}
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			
			if(precificacao.getId() != null && precificacao.getDescricao().equals("")){
				pst.setInt(1, precificacao.getId());
			}else if(precificacao.getId() == null && !precificacao.getDescricao().equals("")){
				pst.setString(1, "%"+precificacao.getDescricao()+"%");			
			}
		
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> precificacoes = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Precificacao pre = new Precificacao();
				pre.setId(rs.getInt("pre_id"));
				pre.setDescricao(rs.getString("pre_tipo"));
				precificacoes.add(pre);
			}
			return precificacoes;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
