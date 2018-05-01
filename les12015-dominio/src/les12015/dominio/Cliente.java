
package les12015.dominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Login {

	private String nome;
	private String cpf;
	private List<EntidadeDominio> cartoes = new ArrayList<EntidadeDominio>();
	private List<EntidadeDominio> enderecos = new ArrayList<EntidadeDominio>();
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<EntidadeDominio> getCartoes() {
		return cartoes;
	}
	public void setCartoes(List<EntidadeDominio> cartoes) {
		this.cartoes = cartoes;
	}
	public List<EntidadeDominio> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<EntidadeDominio> enderecos) {
		this.enderecos = enderecos;
	}
	
	
	
	
}
