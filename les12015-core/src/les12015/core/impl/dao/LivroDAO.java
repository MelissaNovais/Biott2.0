package les12015.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import les12015.dominio.Autor;
import les12015.dominio.Categoria;
import les12015.dominio.Editora;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Livro;
import les12015.dominio.Precificacao;

public class LivroDAO extends AbstractJdbcDAO {

	public LivroDAO() {
		super("livro", "liv_id");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		openConnection();
		PreparedStatement pst=null;
		Livro livro = (Livro)entidade;
		
		
		try {
			connection.setAutoCommit(false);		
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO livro(liv_titulo, liv_ano, liv_edicao, liv_isbn, "
					+ "liv_paginas, liv_sinopse, liv_altura, liv_peso, liv_profundidade, liv_largura, "
					+ "liv_preco, liv_status, editora_edi_id, precificacao_pre_id, liv_qtde_estoque, "
					+ "liv_qtde_obg_venda, liv_cod_barras, liv_custo)");
			sql.append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");	
			
			//Retornar o ID gerado automaticamente
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			pst.executeUpdate();
			ResultSet resultado = pst.getGeneratedKeys();
			resultado.next();
			
			int id= resultado.getInt(1);
			livro.setId(id);
			
			pst.setString(1, livro.getTitulo());
			pst.setInt(2, livro.getAno());
			pst.setInt(3, livro.getEdicao());
			pst.setString(4, livro.getIsbn());
			pst.setInt(5, livro.getPaginas());
			pst.setString(6, livro.getSinopse());
			pst.setInt(7, livro.getAltura());
			pst.setInt(8, livro.getPeso());
			pst.setInt(9, livro.getProfundidade());
			pst.setInt(10, livro.getLargura());
			pst.setDouble(11, livro.getPreco());
			pst.setBoolean(12, livro.isStatus());
			pst.setInt(13, livro.getEditora().getId());
			pst.setInt(13, livro.getPrecificacao().getId());
			pst.setInt(14, livro.getQtdeEstoque());
			pst.setInt(15, livro.getQtdObgVenda());
			pst.setString(16, livro.getCodBarras());
			pst.setDouble(17, livro.getCusto());
			
			pst.executeUpdate();			
			
			salvarAutores(livro.getAutores(), livro);			
			salvarCategorias(livro.getCategorias(), livro);			
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
	
	private void salvarCategorias(ArrayList<Categoria> categorias, Livro livro) throws SQLException {
		StringBuilder sql = new StringBuilder();
		PreparedStatement pst =  null;
		for (Categoria categoria : categorias) {
			sql.append("INSERT INTO liv_possui_cat(livro_liv_id, categoria_cat_id");
			sql.append(" VALUES (?,?)");
			pst = connection.prepareStatement(sql.toString());
			pst.setInt(1, livro.getId());
			pst.setInt(2, categoria.getId());
			pst.executeUpdate();	
		}
	}

	private void salvarAutores(ArrayList<Autor> autores,Livro livro) throws SQLException {
	
		StringBuilder sql = new StringBuilder();
		PreparedStatement pst =  null;
		for (Autor autor : autores) {
			sql.append("INSERT INTO liv_possui_aut(livro_liv_id, autor_aut_id");
			sql.append(" VALUES (?,?)");
			pst = connection.prepareStatement(sql.toString());
			pst.setInt(1, livro.getId());
			pst.setInt(2, autor.getId());
			pst.executeUpdate();		
		}		
	}

	@Override
	public void alterar(EntidadeDominio entidade) throws SQLException {
		openConnection();
		PreparedStatement pst=null;
		Livro livro = (Livro)entidade;
		
		try {
			connection.setAutoCommit(false);		
			
			StringBuilder sql = new StringBuilder();
			
			sql.append("UPDATE livro SET liv_titulo=?, liv_ano=?, liv_edicao=?, liv_isbn=?, " +
					"liv_paginas=?, liv_sinopse=?, liv_altura=?, liv_peso=?, liv_profundidade=?, liv_largura=?, "+
					"liv_preco=?, liv_status=?, editora_edi_id=?, precificacao_pre_id=?, liv_qtde_estoque=?, " +
					"liv_qtde_obg_venda=?, liv_cod_barras=?, liv_custo=?)");
			sql.append("WHERE liv_id=?");				
			
			pst = connection.prepareStatement(sql.toString());
			
			pst.setString(1, livro.getTitulo());
			pst.setInt(2, livro.getAno());
			pst.setInt(3, livro.getEdicao());
			pst.setString(4, livro.getIsbn());
			pst.setInt(5, livro.getPaginas());
			pst.setString(6, livro.getSinopse());
			pst.setInt(7, livro.getAltura());
			pst.setInt(8, livro.getPeso());
			pst.setInt(9, livro.getProfundidade());
			pst.setInt(10, livro.getLargura());
			pst.setDouble(11, livro.getPreco());
			pst.setBoolean(12, livro.isStatus());
			pst.setInt(13, livro.getEditora().getId());
			pst.setInt(13, livro.getPrecificacao().getId());
			pst.setInt(14, livro.getQtdeEstoque());
			pst.setInt(15, livro.getQtdObgVenda());
			pst.setString(16, livro.getCodBarras());
			pst.setDouble(17, livro.getCusto());
			pst.setInt(18, livro.getId());
			
			pst.executeUpdate();	
			salvarAutores(livro.getAutores(), livro);			
			salvarCategorias(livro.getCategorias(), livro);	
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
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		PreparedStatement pst = null;
		Livro livro = (Livro)entidade;
		List<EntidadeDominio> livros = new ArrayList<EntidadeDominio>();
		StringBuilder sql = new StringBuilder();
		
		
		//Pegando os Autores
		sql.append("SELECT * FROM livro LEFT JOIN liv_possui_aut ");
		sql.append("ON (livro.liv_id = liv_possui_aut.autor_aut_id) ");
		sql.append("LEFT JOIN autor ON (autor.aut_id = liv_possui_aut.autor_aut_id ");
		sql.append("AND livro.liv_id = livro_possui_autor.livro_liv_id) ");
		//Pegando as categorias
		sql.append("LEFT JOIN liv_possui_cat ON (livro.liv_id = liv_possui_cat.livro_liv_id) ");
		sql.append("LEFT JOIN categoria ON (categoria.cat_id = liv_possui_cat.categoria_cat_id ");
		sql.append("AND livro.liv_id = livro_possui_categoria.livro_liv_id) ");
		//Pegando o Resto  Simples (Editora e Precificação)
		sql.append("LEFT JOIN editora ON (livro.editora_edi_id = editora.edi_id) ");
		sql.append("LEFT JOIN precificacao ON (livro.precificacao_pre_id = precificacao.pre_id) ");
		//Condição Verdadeira		
		sql.append("WHERE 1=1\\n");//Precisa do \\n?
		
		if(livro.getTitulo() != null && !livro.getTitulo().trim().equals("")) {
			sql.append(" AND liv_titulo= '" + livro.getTitulo()+"'");
		}
		if(livro.getAno() > 0) {
			sql.append(" AND liv_ano= '" + livro.getAno() + "'");
		}
		if(livro.getIsbn() != null && !livro.getIsbn().trim().equals("")) {
			sql.append(" AND liv_isbn= '" + livro.getIsbn() + "'");
		}
		if(livro.getEditora().getNome() != null && !livro.getEditora().getNome().trim().equals("")) {
			sql.append(" AND editora_edi_id= '" + livro.getEditora().getId() + "'");
		}
		if(livro.getQtdeEstoque() > 0) {
			sql.append(" AND liv_qtde_estoque= '" + livro.getQtdeEstoque()  + "'");
		}
		if(livro.getPaginas() > 0) {
			sql.append(" AND liv_paginas= '" + livro.getPaginas()  + "'");
		}
		if(livro.getEdicao() > 0) {
			sql.append(" AND liv_edicao='" + livro.getEdicao()  + "'");
		}
		if(livro.getQtdObgVenda() > 0) {
			sql.append(" AND liv_qtde_obg_venda='" + livro.getQtdObgVenda()  + "'");
		}
		if(livro.getProfundidade() > 0) {
			sql.append(" AND liv_profundidade='" + livro.getProfundidade()  + "'");
		}
		if(livro.getAltura() > 0) {
			sql.append(" AND liv_altura='" + livro.getAltura()  + "'");
		}
		if(livro.getLargura() > 0) {
			sql.append(" AND liv_largura='" + livro.getLargura()  + "'");
		}
		if(livro.getPeso() > 0) {
			sql.append(" AND liv_peso='" + livro.getPeso()  + "'");
		}
		if(livro.getPreco() > 0) {
			sql.append(" AND liv_preco='" + livro.getPreco()  + "'");
		}
		if(livro.getPrecificacao().getId() !=  null ) {
			sql.append(" AND precificacao_pre_id='" + livro.getPrecificacao().getId()  + "'");
		}
		if(livro.getCodBarras() != null && !livro.getCodBarras().trim().equals("") ) {
			sql.append(" AND liv_cog_barras='" + livro.getCodBarras()  + "'");
		}
		if(livro.getSinopse() != null && !livro.getSinopse().trim().equals("") ) {
			sql.append(" AND liv_sinopse='" + livro.getSinopse()  + "'");
		}
		if(livro.getAutores().get(0).getNome()!= null && !livro.getAutores().get(0).getNome().trim().equals("")) {
			for (Autor autor : livro.getAutores()) {
				sql.append(" AND autor.aut_nome like '%" + autor.getNome() + "%'");
			}
		}
		if(livro.getCategorias().get(0).getNomeCategoria()!= null && !livro.getCategorias().get(0).getNomeCategoria().trim().equals("")) {
			for (Categoria cat : livro.getCategorias()) {
				sql.append(" AND categoria.cat_nome like '%" + cat.getNomeCategoria() + "%'");
			}
		}
		/*
		 titulo, ***************
		 autores ********************
		 editora ***************
		 categorias *****************
		 edicao  ***************
		 ano *******************
		 sinopse ***************
		 qtdObgVenda************
		 isbn ******************
		 paginas****************
		 precificacao***********
		 profundidade **********
		 preco *****************
		 codBarras**************
		 altura ****************
		 peso ******************
		 largura****************
	 	 qtdeEstoque ***********
		*/
		try {
			openConnection();
			pst = connection.prepareStatement(sql.toString());
			ResultSet result = pst.executeQuery();
			while(result.next()) {
				livro = new Livro();
				Editora editora = new Editora();
				Precificacao precificacao = new Precificacao();
				
				livro.setPrecificacao(precificacao);
				livro.setEditora(editora);
				
				//Pegando Atributos unicos do livro (Inclui classe Editora e Precificacao)
				livro.setId(result.getInt("liv_id"));
				livro.setAltura(result.getInt("liv_altura"));
				livro.setAno(result.getInt("liv_ano"));
				livro.setCodBarras(result.getString("liv_cod_barras"));
				livro.setCusto(result.getDouble("liv_custo"));
				livro.setEdicao(result.getInt("liv_edicao"));
				livro.getEditora().setId(result.getInt("editora_edi_id"));
				livro.getEditora().setNome("edi_nome");
				livro.setIsbn(result.getString("liv_isbn"));
				livro.setLargura(result.getInt("liv_largura"));
				livro.setPaginas(result.getInt("liv_paginas"));
				livro.setPeso(result.getInt("liv_peso"));
				livro.getPrecificacao().setId(result.getInt("precificacao_pre_id"));
				livro.getPrecificacao().setDescricao(result.getString("pre_tipo"));
				livro.getPrecificacao().setMargemLucro(result.getDouble("pre_margem_lucro"));
				livro.setPreco(result.getDouble("liv_preco"));
				livro.setProfundidade(result.getInt("liv_profundidade"));
				livro.setQtdeEstoque(result.getInt("liv_qtde_estoque"));
				livro.setQtdObgVenda(result.getInt("liv_qtde_obg_venda"));
				livro.setSinopse(result.getString("liv_sinopse"));
				livro.setStatus(result.getBoolean("liv_status"));
				livro.setTitulo(result.getString("liv_titulo"));
				
				//Pegando atributos q podem ser arrays(Autor e Categoria)
				for(int i=0;result.next(); i++) {
					livro.getAutores().add(null);
					livro.getAutores().get(i).setNome(result.getString("aut_nome"));
					livro.getAutores().get(i).setId(result.getInt("aut_id"));
				}
				for(int i=0;result.next(); i++) {
					livro.getCategorias().add(null);
					livro.getCategorias().get(i).setNomeCategoria(result.getString("cat_nome"));
					livro.getCategorias().get(i).setId(result.getInt("cat_id"));
				}
				
				livros.add(livro);
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}  finally {
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return livros;
	}
	@Override
	public void excluir(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst=null;
		Livro livro = (Livro)entidade;
		
		try {
			connection.setAutoCommit(false);		
			
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE livro SET liv_status=? ");
			sql.append("WHERE liv_id=?");
			
			pst = connection.prepareStatement(sql.toString());
			
			if(livro.isStatus()) {
				pst.setBoolean(1, false);
				pst.setInt(2, livro.getId());
			}
			else {
				pst.setBoolean(1, true);
				pst.setInt(2, livro.getId());
			}
			
			pst.executeUpdate();
			connection.commit();
			
			
		}catch (SQLException e) {
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
}
