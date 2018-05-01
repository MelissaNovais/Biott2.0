package les12015.dominio;

public class LivroMotivoStatus  extends EntidadeDominio{
	
	private CatInativacao catInativacoes ;
	private CatAtivacao catAtivacoes;
	private Boolean status;
	private String descricao;
	private Livro livro = new Livro();
	
	public CatInativacao getCatInativacoes() {
		return catInativacoes;
	}
	public void setCatInativacoes(CatInativacao catInativacoes) {
		this.catInativacoes = catInativacoes;
	}
	public CatAtivacao getCatAtivacoes() {
		return catAtivacoes;
	}
	public void setCatAtivacoes(CatAtivacao catAtivacoes) {
		this.catAtivacoes = catAtivacoes;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
}
