package les12015.core.impl.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.EntidadeDominio;
import les12015.dominio.Livro;
import les12015.dominio.LivroMotivoStatus;

public class LivroMotivoStatusDAO extends AbstractJdbcDAO{

	public LivroMotivoStatusDAO() {
		super("liv_motivo_status", "lms_id");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		LivroMotivoStatus lms = (LivroMotivoStatus) entidade;
		openConnection();
		PreparedStatement pst=null;
		
		try {
			connection.setAutoCommit(false);		
			StringBuilder sql = new StringBuilder();
			sql = new StringBuilder();
			sql.append("INSERT INTO liv_motivo_status(lms_data, livro_liv_id, lms_status, lms_descricao, "
					+ "cat_ativacao_ati_id, cat_inativacao_ina_id)");
			sql.append(" VALUES(?,?,?,?,?,?)");
			
			// Retornar o ID gerado automaticamente
			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
			
			pst.setDate(1, (Date)lms.getDtCadastro());
			pst.setInt(2, lms.getLivro().getId());
			pst.setBoolean(3, lms.getStatus());
			pst.setString(4, lms.getDescricao());
			pst.setInt(5, lms.getCatAtivacoes().getId());
			pst.setInt(6, lms.getCatInativacoes().getId());
			
			pst.executeUpdate();
			
			//Modificar em livro 
			LivroDAO livDao = new LivroDAO();
			ArrayList<EntidadeDominio> livros = new ArrayList<EntidadeDominio>( );
			livros = (ArrayList<EntidadeDominio>) livDao.consultar(lms.getLivro());
			Livro liv = (Livro) livros.get(0);
			liv.setStatus(lms.getStatus());
			
			livDao.alterar(liv);
			
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
		// TODO Auto-generated method stub
		return null;
	}

}
