package les12015.dominio;

public class Precificacao extends EntidadeDominio {
	
	 private double margemLucro;
	 private String descricao;
	 
	
	public double getMargemLucro() {
		return margemLucro;
	}
	public void setMargemLucro(double margemLucro) {
		this.margemLucro = margemLucro;
	}
	public String string() {
		return descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
