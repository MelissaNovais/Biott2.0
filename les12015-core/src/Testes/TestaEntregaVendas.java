package Testes;

import java.sql.SQLException;
import java.util.ArrayList;

import les12015.core.impl.dao.StatusDeCompraDAO;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.StatusDeCompra;

public class TestaEntregaVendas {
	
	public static void main(String[] args) throws SQLException {
		StatusDeCompra stato = new StatusDeCompra();
		StatusDeCompraDAO dao = new StatusDeCompraDAO();
		
		ArrayList<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();
		
		lista = (ArrayList<EntidadeDominio>) dao.consultar(stato);
		System.out.println("ueh");
		System.out.println(lista.size());
		
	}
	
	
	
}
