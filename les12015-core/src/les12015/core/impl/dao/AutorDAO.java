package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Autor;
import les12015.dominio.EntidadeDominio;

public class AutorDAO extends AbstractJdbcDAO{

	public AutorDAO() {
		super("autor", "aut_id");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		openConnection();
		PreparedStatement pst=null;
		Autor autor = (Autor)entidade;
		
		
		try {
			connection.setAutoCommit(false);		
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO autor(aut_nome)");
			sql.append(" VALUES (?)");	
			
			//Retornar o ID gerado automaticamente
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, autor.getNome());
			pst.executeUpdate();
			
			ResultSet resultado = pst.getGeneratedKeys();			
			resultado.next();
			int id= resultado.getInt(1);
			autor.setId(id);			
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
	public void alterar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		PreparedStatement pst = null;

		Autor autor = (Autor) entidade;
		String sql = null;

		if (autor.getNome() == null) {
			autor.setNome("");
		}

		if (autor.getId() == null && autor.getNome().equals("")) {
			sql = "SELECT * FROM autor";
		} else if (autor.getId() != null && autor.getNome().equals("")) {
			sql = "SELECT * FROM autor WHERE aut_id=?";
		} else if (autor.getId() == null && !autor.getNome().equals("")) {
			sql = "SELECT * FROM autor WHERE aut_nome like ?";

		}
		try {
			openConnection();
			pst = connection.prepareStatement(sql);

			if (autor.getId() != null && autor.getNome().equals("")) {
				pst.setInt(1, autor.getId());
			} else if (autor.getId() == null && !autor.getNome().equals("")) {
				pst.setString(1, "%" + autor.getNome() + "%");
			}

			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> autores = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Autor aut = new Autor();
				aut.setId(rs.getInt("aut_id"));
				aut.setNome(rs.getString("aut_nome"));
				autores.add(aut);
			}
			return autores;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
