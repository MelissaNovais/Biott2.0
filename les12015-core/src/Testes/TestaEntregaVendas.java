package Testes;

import java.sql.SQLException;
import java.util.ArrayList;

import les12015.core.impl.dao.AdminDAO;
import les12015.dominio.Administrador;
import les12015.dominio.EntidadeDominio;

public class TestaEntregaVendas {
	
	public static void main(String[] args) throws SQLException {
		
		AdminDAO dao = new AdminDAO();
		Administrador admin = new Administrador();
		
		ArrayList<EntidadeDominio> lista = new ArrayList<EntidadeDominio>();
		
		admin.setNome("Thales Burakowski");
		admin.setEmail("thales.burakowski@fatec.sp.gov.br");
		admin.setSenha("Senha@123");
		admin.setTipoUsuario("admin");
		
		dao.salvar(admin);
		
		
	}
	
	
	
}
