package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Editora;
import les12015.dominio.EntidadeDominio;

public class EditoraDAO extends AbstractJdbcDAO {

	public EditoraDAO() {
		super("editora","edi_id");
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
		
		Editora editora = (Editora)entidade;
		String sql=null;
		
		if(editora.getNome() == null){
			editora.setNome("");
		}
		
		if(editora.getId() == null && editora.getNome().equals("")){
			sql = "SELECT * FROM editora";
		}else if(editora.getId() != null && editora.getNome().equals("")){
			sql = "SELECT * FROM editora WHERE edi_id=?";
		}else if(editora.getId() == null && !editora.getNome().equals("")){
			sql = "SELECT * FROM editora WHERE edi_nome like ?";
		
		}
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			
			if(editora.getId() != null && editora.getNome().equals("")){
				pst.setInt(1, editora.getId());
			}else if(editora.getId() == null && !editora.getNome().equals("")){
				pst.setString(1, "%"+editora.getNome()+"%");			
			}
		
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> editoras = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Editora edi = new Editora();
				edi.setId(rs.getInt("edi_id"));
				edi.setNome(rs.getString("edi_nome"));
				editoras.add(edi);
			}
			return editoras;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
