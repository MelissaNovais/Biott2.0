
package les12015.core.impl.controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import les12015.core.IDAO;
import les12015.core.IFachada;
import les12015.core.IStrategy;
import les12015.core.aplicacao.Resultado;
import les12015.core.impl.dao.CartaoDAO;
import les12015.core.impl.dao.ClienteDAO;
import les12015.core.impl.dao.CompraDAO;
import les12015.core.impl.dao.CupomDAO;
import les12015.core.impl.dao.EnderecoDAO;
import les12015.core.impl.dao.FornecedorDAO;
import les12015.core.impl.dao.LoginDAO;
import les12015.core.impl.dao.TesteCarrinhoDAO;
import les12015.core.impl.negocio.ValidarCadastroCartao;
import les12015.core.impl.negocio.ValidarCadastroEndereco;
import les12015.core.impl.negocio.ValidarCamposCadastroCliente;
import les12015.core.impl.negocio.ValidarCamposCartao;
import les12015.core.impl.negocio.ValidarCamposEndereco;
import les12015.core.impl.negocio.ValidarCamposLogin;
import les12015.core.impl.negocio.ValidarQtdeLivroCarrinho;
import les12015.core.impl.negocio.ValidarTrocaSenha;
import les12015.core.impl.negocio.VerificarCupom;
import les12015.dominio.Cartao;
import les12015.dominio.Cliente;
import les12015.dominio.Compra;
import les12015.dominio.Cupom;
import les12015.dominio.Endereco;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Fornecedor;
import les12015.dominio.ItemCompra;
import les12015.dominio.Login;

public class Fachada implements IFachada {

	/** 
	 * Mapa de DAOS, ser� indexado pelo nome da entidade 
	 * O valor � uma inst�ncia do DAO para uma dada entidade; 
	 */
	private Map<String, IDAO> daos;
	
	/**
	 * Mapa para conter as regras de neg�cio de todas opera��es por entidade;
	 * O valor � um mapa que de regras de neg�cio indexado pela opera��o
	 */
	private Map<String, Map<String, List<IStrategy>>> rns;
	
	private Resultado resultado;
	
	
	public Fachada(){
		/* Int�nciando o Map de DAOS */
		daos = new HashMap<String, IDAO>();
		/* Int�nciando o Map de Regras de Neg�cio */
		rns = new HashMap<String, Map<String, List<IStrategy>>>();
		
		/* Criando inst�ncias dos DAOs a serem utilizados*/
		FornecedorDAO forDAO = new FornecedorDAO();
		
		ClienteDAO clienteDAO  = new ClienteDAO();
		CartaoDAO cartaoDAO = new CartaoDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		LoginDAO loginCliDAO = new LoginDAO();
		CupomDAO cupomDAO = new CupomDAO();
		CompraDAO compraDAO = new CompraDAO();
		TesteCarrinhoDAO testeCarrinhoDAO = new TesteCarrinhoDAO();

		
		/* Adicionando cada dao no MAP indexando pelo nome da classe */
		daos.put(Fornecedor.class.getName(), forDAO);		
		daos.put(Cliente.class.getName(), clienteDAO);		
		daos.put(Endereco.class.getName() , enderecoDAO);	
		daos.put(Cartao.class.getName(), cartaoDAO);
		daos.put(Login.class.getName(), loginCliDAO);
		daos.put(Cupom.class.getName(), cupomDAO);
		daos.put(Compra.class.getName(), compraDAO);
		daos.put(ItemCompra.class.getName(), testeCarrinhoDAO);//*****************************************************************
		
		
		/* Criando inst�ncias de regras de neg�cio a serem utilizados*/		
		ValidarCamposCadastroCliente validarCadastroCliente = new ValidarCamposCadastroCliente();
		ValidarCadastroEndereco validarCadastroEnd = new ValidarCadastroEndereco();
		ValidarCamposEndereco validarCampoEnd = new ValidarCamposEndereco();
		ValidarCadastroCartao validarCartao = new ValidarCadastroCartao();
		ValidarCamposCartao valCamposCartao = new ValidarCamposCartao();
		ValidarCamposLogin validarLogin = new ValidarCamposLogin();
		ValidarTrocaSenha validarTrocaSenha = new ValidarTrocaSenha();
		VerificarCupom verificarCupom = new VerificarCupom();
		ValidarQtdeLivroCarrinho valQtdeCarrinho = new ValidarQtdeLivroCarrinho();
		
		
		
		
		//Criar  as listas com regras de negocio/
		List<IStrategy> rnsSalvarCliente = new ArrayList<IStrategy>();
		rnsSalvarCliente.add(validarCadastroCliente);
		List<IStrategy> rnsExcluirCliente = new ArrayList<IStrategy>();//Nao fizemos Ainda
		List<IStrategy> rnsAlterarCliente = new ArrayList<IStrategy>();//Nao fizemos Ainda
		List<IStrategy> rnsConsultarCliente = new ArrayList<IStrategy>();//Nao fizemos Ainda
		
		List<IStrategy> rnsSalvarLogin = new ArrayList<IStrategy>();
		List<IStrategy> rnsAlterarLogin = new ArrayList<IStrategy>();
		rnsAlterarLogin.add(validarTrocaSenha);
		List<IStrategy> rnsExcluirLogin = new ArrayList<IStrategy>();
		List<IStrategy> rnsConsultarLogin = new ArrayList<IStrategy>();
		rnsConsultarLogin.add(validarLogin);

		List<IStrategy> rnsSalvarCartao = new ArrayList<IStrategy>();
		rnsSalvarCartao.add(validarCartao);
		rnsSalvarCartao.add(valCamposCartao);
		List<IStrategy> rnsAlterarCartao = new ArrayList<IStrategy>();
		List<IStrategy> rnsConsultarCartao = new ArrayList<IStrategy>();
		List<IStrategy> rnsExcluirCartao = new ArrayList<IStrategy>();
		
		List<IStrategy> rnsSalvarEndereco = new ArrayList<IStrategy>();
		rnsSalvarEndereco.add(validarCadastroEnd);
		rnsSalvarEndereco.add(validarCampoEnd);
		List<IStrategy> rnsAlterarEndereco = new ArrayList<IStrategy>();
		List<IStrategy> rnsConsultarEndereco = new ArrayList<IStrategy>();
		List<IStrategy> rnsExcluirEndereco = new ArrayList<IStrategy>();
		
		List<IStrategy> rnsSalvarCupom = new ArrayList<IStrategy>();
		List<IStrategy> rnsAlterarCupom = new ArrayList<IStrategy>();
		List<IStrategy> rnsConsultarCupom = new ArrayList<IStrategy>();
		rnsConsultarCupom.add(verificarCupom);
		List<IStrategy> rnsExcluirCupom = new ArrayList<IStrategy>();
		
		List<IStrategy> rnsSalvarCompra = new ArrayList<IStrategy>();
		rnsSalvarCompra.add(valQtdeCarrinho);
		List<IStrategy> rnsAlterarCompra = new ArrayList<IStrategy>();
		List<IStrategy> rnsConsultarCompra = new ArrayList<IStrategy>();
		List<IStrategy> rnsExcluirCompra = new ArrayList<IStrategy>();
		
		//Criar o HashMap de cada classe com as listas(com regra de negocio) indexado pela opera��o
		
		
		
		Map<String, List<IStrategy>> rnsCliente = new HashMap<String, List<IStrategy>>();
		rnsCliente.put("SALVAR", rnsSalvarCliente);
		rnsCliente.put("ALTERAR", rnsAlterarCliente);
		rnsCliente.put("EXCLUIR", rnsExcluirCliente);
		rnsCliente.put("CONSULTAR", rnsConsultarCliente);
		
		Map<String, List<IStrategy>> rnsCartao = new HashMap<String, List<IStrategy>>();
		rnsCartao.put("SALVAR", rnsSalvarCartao);
		rnsCartao.put("ALTERAR", rnsAlterarCartao);
		rnsCartao.put("EXCLUIR", rnsExcluirCartao);
		rnsCartao.put("CONSULTAR", rnsConsultarCartao);
		
		Map<String, List<IStrategy>> rnsEndereco = new HashMap<String, List<IStrategy>>();
		rnsEndereco.put("SALVAR", rnsSalvarEndereco);
		rnsEndereco.put("ALTERAR", rnsAlterarEndereco);
		rnsEndereco.put("EXCLUIR", rnsExcluirEndereco);
		rnsEndereco.put("CONSULTAR", rnsConsultarEndereco);
		
		Map<String, List<IStrategy>> rnsLogin = new HashMap<String, List<IStrategy>>();
		rnsLogin.put("SALVAR", rnsSalvarLogin);
		rnsLogin.put("ALTERAR", rnsAlterarLogin);
		rnsLogin.put("EXCLUIR", rnsExcluirLogin);
		rnsLogin.put("CONSULTAR", rnsConsultarLogin);
		
		Map<String, List<IStrategy>> rnsCupom = new HashMap<String, List<IStrategy>>();
		rnsCupom.put("SALVAR", rnsSalvarCupom);
		rnsCupom.put("ALTERAR", rnsAlterarCupom);
		rnsCupom.put("EXCLUIR", rnsExcluirCupom);
		rnsCupom.put("CONSULTAR", rnsConsultarCupom);
		
		Map<String, List<IStrategy>> rnsCompra = new HashMap<String, List<IStrategy>>();
		rnsCompra.put("SALVAR", rnsSalvarCompra);
		rnsCompra.put("ALTERAR", rnsAlterarCompra);
		rnsCompra.put("EXCLUIR", rnsExcluirCompra);
		rnsCompra.put("CONSULTAR", rnsConsultarCompra);
		
		Map<String, List<IStrategy>> rnsCarrinho = new HashMap<String, List<IStrategy>>();//***************************************
		List<IStrategy> rnsSalvarCarrinho = new ArrayList<IStrategy>();
		List<IStrategy> rnsAlterarCarrinho = new ArrayList<IStrategy>();
		List<IStrategy> rnsExcluirCarrinho = new ArrayList<IStrategy>();
		List<IStrategy> rnsConsultarCarrinho = new ArrayList<IStrategy>();
		rnsCarrinho.put("SALVAR", rnsSalvarCarrinho);
		rnsCarrinho.put("ALTERAR", rnsAlterarCarrinho);
		rnsCarrinho.put("EXCLUIR", rnsExcluirCarrinho);
		rnsCarrinho.put("CONSULTAR", rnsConsultarCarrinho);
		
		/*Colocar os HashMaps criados no HashMap rns indexado pelo nome de cada classe
			Resumindo: Uma lista(rn) dentro de um hashmap(rn indexado pela opera��o) 
			dentro de um hashmap (hashmap Anterior indexado pelo nome da classe)*/
		
		
		rns.put(Cliente.class.getName(), rnsCliente);
		rns.put(Cartao.class.getName(), rnsCartao);
		rns.put(Endereco.class.getName(), rnsEndereco);
		rns.put(Login.class.getName(), rnsLogin);
		rns.put(Cupom.class.getName(), rnsCupom);
		rns.put(Compra.class.getName(), rnsCompra);
		rns.put(ItemCompra.class.getName(), rnsCarrinho);//*************************************************************************
		
		
	}
	
	
	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "SALVAR");
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.salvar(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("N�o foi poss�vel realizar o registro!");
				
			}
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "ALTERAR");
	
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.alterar(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("N�o foi poss�vel realizar o registro!");
				
			}
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;

	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "EXCLUIR");
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.excluir(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("N�o foi poss�vel realizar o registro!");
				
			}
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;

	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "CONSULTAR");
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				
				resultado.setEntidades(dao.consultar(entidade));
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("N�o foi poss�vel realizar a consulta!");
				
			}
		}else{
			resultado.setMsg(msg);
			
		}
		
		return resultado;

	}
	
	@Override
	public Resultado visualizar(EntidadeDominio entidade) {
		resultado = new Resultado();
		resultado.setEntidades(new ArrayList<EntidadeDominio>(1));
		resultado.getEntidades().add(entidade);		
		return resultado;

	}

	
	private String executarRegras(EntidadeDominio entidade, String operacao){
		String nmClasse = entidade.getClass().getName();		
		StringBuilder msg = new StringBuilder();
		
		Map<String, List<IStrategy>> regrasOperacao = rns.get(nmClasse);
		
		
		if(regrasOperacao != null){
			List<IStrategy> regras = regrasOperacao.get(operacao);
			
			if(regras != null){
				for(IStrategy s: regras){			
					String m = s.processar(entidade);			
					
					if(m != null){
						msg.append(m);
						msg.append("\n");
					}			
				}	
			}			
			
		}
		
		if(msg.length()>0)
			return msg.toString();
		else
			return null;
	}
}
