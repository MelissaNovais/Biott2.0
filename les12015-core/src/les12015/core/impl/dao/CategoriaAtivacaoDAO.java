package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.CatAtivacao;
import les12015.dominio.EntidadeDominio;

public class CategoriaAtivacaoDAO extends AbstractJdbcDAO{

	public CategoriaAtivacaoDAO() {
		super("cat_ativacao", "ati_id");
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
		
		CatAtivacao catAtivacao = (CatAtivacao)entidade;
		String sql=null;
		
		if(catAtivacao.getMotivo() == null){
			catAtivacao.setMotivo("");
		}
		
		if(catAtivacao.getId() == null && catAtivacao.getMotivo().equals("")){
			sql = "SELECT * FROM cat_ativacao";
		}else if(catAtivacao.getId() != null && catAtivacao.getMotivo().equals("")){//Null funciona com int?
			sql = "SELECT * FROM cat_ativacao WHERE ati_id=?";
		}else if(catAtivacao.getId() == null && !catAtivacao.getMotivo().equals("")){
			sql = "SELECT * FROM cat_ativacao WHERE ati_cat like ?";
		
		}
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			
			if(catAtivacao.getId() != null && catAtivacao.getMotivo().equals("")){
				pst.setInt(1, catAtivacao.getId());
			}else if(catAtivacao.getId() == null && !catAtivacao.getMotivo().equals("")){
				pst.setString(1, "%"+catAtivacao.getMotivo()+"%");			
			}
		
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> catAtivacoes = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				CatAtivacao cat = new CatAtivacao();
				cat.setId(rs.getInt("ati_id"));
				cat.setMotivo(rs.getString("ati_cat"));
				catAtivacoes.add(cat);
			}
			return catAtivacoes;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
