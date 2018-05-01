package les12015.dominio;

import java.util.ArrayList;

public class Livro extends EntidadeDominio{
	
	private String titulo;
	private int ano;
	private int edicao;
	private String isbn;
	private int paginas;
	private String sinopse;
	private int altura;
	private int peso;
	private int profundidade;
	private int largura;
	private double preco;
	private boolean status;
	private int qtdObgVenda;
	private int qtdeEstoque;
	private String codBarras;
	private double custo;
	private Editora editora = new Editora();
	private Precificacao precificacao = new Precificacao();

	private ArrayList<Autor> autores = new ArrayList<Autor>();
	private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public String getSinopse() {
		return sinopse;
	}
	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getProfundidade() {
		return profundidade;
	}
	public void setProfundidade(int profundidade) {
		this.profundidade = profundidade;
	}
	public int getLargura() {
		return largura;
	}
	public void setLargura(int largura) {
		this.largura = largura;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getQtdObgVenda() {
		return qtdObgVenda;
	}
	public void setQtdObgVenda(int qtdObgVenda) {
		this.qtdObgVenda = qtdObgVenda;
	}
	public int getQtdeEstoque() {
		return qtdeEstoque;
	}
	public void setQtdeEstoque(int qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	public double getCusto() {
		return custo;
	}
	public void setCusto(double custo) {
		this.custo = custo;
	}
	public Editora getEditora() {
		return editora;
	}
	public void setEditora(Editora editora) {
		this.editora = editora;
	}
	public Precificacao getPrecificacao() {
		return precificacao;
	}
	public void setPrecificacao(Precificacao precificacao) {
		this.precificacao = precificacao;
	}
	public ArrayList<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(ArrayList<Categoria> categorias) {
		this.categorias = categorias;
	}
	public ArrayList<Autor> getAutores() {
		return autores;
	}
	public void setAutores(ArrayList<Autor> autores) {
		this.autores = autores;
	}
	
}
