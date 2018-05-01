package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Categoria;
import les12015.dominio.EntidadeDominio;

public class CategoriaDAO extends AbstractJdbcDAO{

	public CategoriaDAO() {
		super("categoria", "cat_id");
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
		
		Categoria categoria = (Categoria)entidade;
		String sql=null;
		
		if(categoria.getNomeCategoria() == null){
			categoria.setNomeCategoria("");
		}
		
		if(categoria.getId() == null && categoria.getNomeCategoria().equals("")){
			sql = "SELECT * FROM categoria";
		}else if(categoria.getId() != null && categoria.getNomeCategoria().equals("")){//Null funciona com int?
			sql = "SELECT * FROM categoria WHERE cat_id=?";
		}else if(categoria.getId() == null && !categoria.getNomeCategoria().equals("")){
			sql = "SELECT * FROM categoria WHERE cat_nome like ?";
		
		}
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			
			if(categoria.getId() != null && categoria.getNomeCategoria().equals("")){
				pst.setInt(1, categoria.getId());
			}else if(categoria.getId() == null && !categoria.getNomeCategoria().equals("")){
				pst.setString(1, "%"+categoria.getNomeCategoria()+"%");			
			}
		
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> categorias = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Categoria cat = new Categoria();
				cat.setId(rs.getInt("cat_id"));
				cat.setNomeCategoria(rs.getString("cat_nome"));
				categorias.add(cat);
			}
			return categorias;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
