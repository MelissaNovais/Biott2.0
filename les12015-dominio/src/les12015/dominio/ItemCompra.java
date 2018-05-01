package les12015.dominio;

public class ItemCompra extends EntidadeDominio {

	private Livro livro;
	private int qtde;
	private StatusDeCompra statusDaCompra;
	
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public StatusDeCompra getStatusDaCompra() {
		return statusDaCompra;
	}
	public void setStatusDaCompra(StatusDeCompra statusDaCompra) {
		this.statusDaCompra = statusDaCompra;
	}
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
}
