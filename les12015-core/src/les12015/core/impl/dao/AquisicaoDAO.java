package les12015.core.impl.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Aquisicao;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Livro;

public class AquisicaoDAO extends AbstractJdbcDAO{

	public AquisicaoDAO() {
		super("aquisicao", "aqu_id");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		openConnection();
		PreparedStatement pst = null;
		Aquisicao aquisicao = (Aquisicao) entidade;

		try {


			StringBuilder sql = new StringBuilder();
			/*Acho q aqui poderia mudar pra ter cliente_id e poder guardar no banco 
			 * qd houver uma devolução, ae soh por os dois como podendo ser nulo 
			 * Alterar tbm na parte de consultar
			 */
			sql.append("INSERT INTO aquisicao(fornecedor_for_id, livro_liv_id, aqu_date, aqu_qtde, aqu_custo_unidade)");
			sql.append(" VALUES (?,?,?,?,?)");

			// Retornar o ID gerado automaticamente
			pst = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

			pst.setInt(1, aquisicao.getFornecedor().getId());
			pst.setInt(2, aquisicao.getLivro().getId());
			pst.setDate(3, (Date) aquisicao.getDtCadastro());
			pst.setInt(4, aquisicao.getQuantidade());
			pst.setDouble(5, aquisicao.getPreco());
			pst.executeUpdate();

			ResultSet resultado = pst.getGeneratedKeys();
			resultado.next();
			int id = resultado.getInt(1);
			aquisicao.setId(id);
			connection.commit();
			
			//Adicionar essa Aquisição no estoque do livro
			LivroDAO livDao = new LivroDAO();
			ArrayList<EntidadeDominio> livros = new ArrayList<EntidadeDominio>( );
			livros = (ArrayList<EntidadeDominio>) livDao.consultar(aquisicao.getLivro());
			Livro liv = (Livro) livros.get(0);
			liv.setQtdeEstoque(liv.getQtdeEstoque() +  aquisicao.getQuantidade());
			if(liv.getCusto() < aquisicao.getPreco()) {
				liv.setCusto(aquisicao.getPreco());
			}
			livDao.alterar(liv);
			
			
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
		Aquisicao aquisicao = (Aquisicao) entidade;
		String sql = null;
		
		
		//Pesquisa todas aquisições
		if (aquisicao.getFornecedor().getId() == null && aquisicao.getLivro().getId() == null ) {
			sql = "SELECT * FROM aquisicao";
		}
		//Pesquisa pelo id do fornecedor
		else if (aquisicao.getFornecedor().getId()!= null && aquisicao.getLivro().getId() == null ) {
			sql = "SELECT * FROM aquisicao WHERE fornecedor_for_id=?";
		}
		//Pesquisa por id do livro
		else if (aquisicao.getFornecedor().getId() == null && aquisicao.getLivro().getId()==null) {
			sql = "SELECT * FROM autor WHERE livro_liv_id=?";
		}
		//Pesquisa por id de livro e de fornecedor 
		else {
			sql = "SELECT * FROM autor WHERE fornecedor_for_id=? AND livro_liv_id=?";
		}
		try {
			openConnection();
			pst = connection.prepareStatement(sql);

			if (aquisicao.getFornecedor().getId()!= null && aquisicao.getLivro().getId() == null) {
				pst.setInt(1, aquisicao.getFornecedor().getId());
			} else if (aquisicao.getFornecedor().getId() == null && aquisicao.getLivro().getId()==null) {
				pst.setInt(1, aquisicao.getLivro().getId());
			}else if (aquisicao.getFornecedor().getId() == null && aquisicao.getLivro().getId()==null) {
				pst.setInt(1, aquisicao.getFornecedor().getId());
				pst.setInt(2, aquisicao.getLivro().getId());
			}
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> aquisicoes = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Aquisicao aqui = new Aquisicao();
				aqui.setId(rs.getInt("aqu_id"));
				aqui.getFornecedor().setId(rs.getInt("fornecedor_for_id"));
				aqui.getLivro().setId(rs.getInt("livro_liv_id"));
				aqui.setDtCadastro(rs.getDate("aqu_data"));
				aqui.setQuantidade(rs.getInt("aqu_qtde"));
				aqui.setPreco(rs.getDouble("aqu_custo_unidade"));
				aquisicoes.add(aqui);
			}
			return aquisicoes;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
