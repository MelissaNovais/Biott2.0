package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.CatInativacao;
import les12015.dominio.EntidadeDominio;

public class CategoriaInativacaoDAO extends AbstractJdbcDAO{

	public CategoriaInativacaoDAO() {
		super("cat_inativacao","ina_id");
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
		
		CatInativacao catInativacao = (CatInativacao)entidade;
		String sql=null;
		
		if(catInativacao.getMotivo() == null){
			catInativacao.setMotivo("");
		}
		
		if(catInativacao.getId() == null && catInativacao.getMotivo().equals("")){
			sql = "SELECT * FROM cat_inativacao";
		}else if(catInativacao.getId() != null && catInativacao.getMotivo().equals("")){//Null funciona com int?
			sql = "SELECT * FROM cat_inativacao WHERE ina_id=?";
		}else if(catInativacao.getId() == null && !catInativacao.getMotivo().equals("")){
			sql = "SELECT * FROM cat_inativacao WHERE ina_categoria like ?";
		
		}
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			
			if(catInativacao.getId() != null && catInativacao.getMotivo().equals("")){
				pst.setInt(1, catInativacao.getId());
			}else if(catInativacao.getId() == null && !catInativacao.getMotivo().equals("")){
				pst.setString(1, "%"+catInativacao.getMotivo()+"%");			
			}
		
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> catInativacoes = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				CatInativacao cat = new CatInativacao();
				cat.setId(rs.getInt("ina_id"));
				cat.setMotivo(rs.getString("ina_categoria"));
				catInativacoes.add(cat);
			}
			return catInativacoes;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
