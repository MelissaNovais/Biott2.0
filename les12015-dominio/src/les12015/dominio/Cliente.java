
package les12015.dominio;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Login {

	private String nome;
	private String cpf;
	private List<Cartao> cartoes = new ArrayList<Cartao>();
	private List<Endereco> enderecos = new ArrayList<Endereco>();
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
	public List<Cartao> getCartoes() {
		return cartoes;
	}
	public void setCartoes(List<Cartao> cartoes) {
		this.cartoes = cartoes;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	
	
	
}
