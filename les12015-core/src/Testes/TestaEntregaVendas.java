package Testes;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import les12015.core.impl.dao.CompraDAO;
import les12015.dominio.Cartao;
import les12015.dominio.Cliente;
import les12015.dominio.Compra;
import les12015.dominio.Endereco;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.ItemCompra;
import les12015.dominio.Livro;
import les12015.dominio.StatusDeCompra;

public class TestaEntregaVendas {
	
	public static void main(String[] args) throws SQLException {
		
		CompraDAO daoCompra = new CompraDAO();
		Compra compra = new Compra();
		
		ItemCompra item = new ItemCompra();
		List<ItemCompra> itens = new ArrayList<ItemCompra>();
		Livro liv = new Livro();
		StatusDeCompra status = new StatusDeCompra();
		Cartao cartao = new Cartao();
		Endereco end = new Endereco();
		Cliente cliente = new Cliente();
		String data = "2018/10/10";
		status.setId(1);
		liv.setId(3);
		
		item.setLivro(liv);
		item.setQtde(3);
		item.setStatusDaCompra(status);
		
		itens.add(item);
		itens.add(item);
		itens.add(item);
		
		cliente.setId(1);
		
		cartao.setId(50);
		
		end.setId(17);
		
		compra.setCarrinho((List<ItemCompra>) itens);
		compra.setCartao(cartao);
		compra.setCliente(cliente);
		compra.setData(data);
		compra.setEnd(end);
		compra.setSubTotal(150);
		compra.setValorFrete(20);
		compra.setValorTotal(170);
		
		//daoCompra.salvar(compra);
		
		
		ArrayList<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();
		
		compra.setId(33);
		
		lista = (ArrayList<EntidadeDominio>) daoCompra.consultar(compra);
		
		compra = (Compra) lista.get(0);
		
		
			System.out.println("Id compra: " + compra.getId() + " Nome cliente: " + compra.getCliente().getNome());
			System.out.println("*******Itens da compra**********");
			for (ItemCompra item1 : compra.getCarrinho()) {
				System.out.println("Livro: " + item1.getLivro().getTitulo());
				System.out.println("Qtde: " + item1.getQtde());
				System.out.println("Staus do pedido: " + item1.getStatusDaCompra().getNomeStatus());
				System.out.println("           *************");
		}
		
		/*admin.setNome("Thales Burakowski");
		admin.setEmail("thales.burakowski@fatec.sp.gov.br");
		admin.setSenha("Senha@123");
		admin.setTipoUsuario("admin");
		
		dao.salvar(admin);*/
		
		
	}
	
	
	
}
