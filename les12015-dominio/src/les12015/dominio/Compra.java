package les12015.dominio;

import java.util.ArrayList;
import java.util.List;

public class Compra extends EntidadeDominio{

	private Cliente cliente = new Cliente();
	private Endereco end = new Endereco();
	private Cartao cartao = new Cartao();
	private Cupom cupom = new Cupom();
	private double valorFrete;
	private double subTotal;
	private double valorTotal;
	private String data;
	private List<ItemCompra> carrinho = new ArrayList<ItemCompra>(); // Lista da classe item compra
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Endereco getEnd() {
		return end;
	}
	public void setEnd(Endereco end) {
		this.end = end;
	}
	public Cartao getCartao() {
		return cartao;
	}
	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	public Cupom getCupom() {
		return cupom;
	}
	public void setCupom(Cupom cupom) {
		this.cupom = cupom;
	}
	public double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	public double getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}
	public List<ItemCompra> getCarrinho() {
		return carrinho;
	}
	public void setCarrinho(List<ItemCompra> carrinho) {
		this.carrinho = carrinho;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	
	
	
	
}
