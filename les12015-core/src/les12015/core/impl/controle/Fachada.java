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
import les12015.core.impl.dao.EnderecoDAO;
import les12015.core.impl.dao.FornecedorDAO;
import les12015.core.impl.dao.LoginDAO;
import les12015.core.impl.negocio.ValidarCadastroCartao;
import les12015.core.impl.negocio.ValidarCadastroEndereco;
import les12015.core.impl.negocio.ValidarCamposCadastroCliente;
import les12015.core.impl.negocio.ValidarCamposLogin;
import les12015.core.impl.negocio.ValidarTrocaSenha;
import les12015.dominio.Cartao;
import les12015.dominio.Cliente;
import les12015.dominio.Endereco;
import les12015.dominio.EntidadeDominio;
import les12015.dominio.Fornecedor;
import les12015.dominio.Login;

public class Fachada implements IFachada {

	/** 
	 * Mapa de DAOS, será indexado pelo nome da entidade 
	 * O valor é uma instância do DAO para uma dada entidade; 
	 */
	private Map<String, IDAO> daos;
	
	/**
	 * Mapa para conter as regras de negócio de todas operações por entidade;
	 * O valor é um mapa que de regras de negócio indexado pela operação
	 */
	private Map<String, Map<String, List<IStrategy>>> rns;
	
	private Resultado resultado;
	
	
	public Fachada(){
		/* Intânciando o Map de DAOS */
		daos = new HashMap<String, IDAO>();
		/* Intânciando o Map de Regras de Negócio */
		rns = new HashMap<String, Map<String, List<IStrategy>>>();
		
		/* Criando instâncias dos DAOs a serem utilizados*/
		FornecedorDAO forDAO = new FornecedorDAO();
		
		ClienteDAO clienteDAO  = new ClienteDAO();
		CartaoDAO cartaoDAO = new CartaoDAO();
		EnderecoDAO enderecoDAO = new EnderecoDAO();
		LoginDAO loginCliDAO = new LoginDAO();

		
		/* Adicionando cada dao no MAP indexando pelo nome da classe */
		daos.put(Fornecedor.class.getName(), forDAO);		
		daos.put(Cliente.class.getName(), clienteDAO);		
		daos.put(Endereco.class.getName() , enderecoDAO);	
		daos.put(Cartao.class.getName(), cartaoDAO);
		daos.put(Login.class.getName(), loginCliDAO);
		
		
		/* Criando instâncias de regras de negócio a serem utilizados*/		
		ValidarCamposCadastroCliente validarCadastroCliente = new ValidarCamposCadastroCliente();
		ValidarCadastroEndereco validarCadastroEnd = new ValidarCadastroEndereco();
		ValidarCadastroCartao validarCartao = new ValidarCadastroCartao();
		ValidarCamposLogin validarLogin = new ValidarCamposLogin();
		ValidarTrocaSenha validarTrocaSenha = new ValidarTrocaSenha();
		
		
		
		//Criar  as listas com regras de negocio/
		List<IStrategy> rnsSalvarCliente = new ArrayList<IStrategy>();
		rnsSalvarCliente.add(validarCadastroCliente);
		List<IStrategy> rnsExcluirCliente = new ArrayList<IStrategy>();//Nao fizemos Ainda
		List<IStrategy> rnsAlterarCliente = new ArrayList<IStrategy>();//Nao fizemos Ainda
		rnsAlterarCliente.add(validarTrocaSenha);
		List<IStrategy> rnsConsultarCliente = new ArrayList<IStrategy>();//Nao fizemos Ainda
		
		List<IStrategy> rnsSalvarLogin = new ArrayList<IStrategy>();
		List<IStrategy> rnsAlterarLogin = new ArrayList<IStrategy>();
		List<IStrategy> rnsExcluirLogin = new ArrayList<IStrategy>();
		List<IStrategy> rnsConsultarLogin = new ArrayList<IStrategy>();
		rnsConsultarLogin.add(validarLogin);

		List<IStrategy> rnsSalvarCartao = new ArrayList<IStrategy>();
		rnsSalvarCartao.add(validarCartao);
		List<IStrategy> rnsAlterarCartao = new ArrayList<IStrategy>();
		List<IStrategy> rnsConsultarCartao = new ArrayList<IStrategy>();
		List<IStrategy> rnsExcluirCartao = new ArrayList<IStrategy>();
		
		List<IStrategy> rnsSalvarEndereco = new ArrayList<IStrategy>();
		rnsSalvarEndereco.add(validarCadastroEnd);
		List<IStrategy> rnsAlterarEndereco = new ArrayList<IStrategy>();
		List<IStrategy> rnsConsultarEndereco = new ArrayList<IStrategy>();
		List<IStrategy> rnsExcluirEndereco = new ArrayList<IStrategy>();
		
		//Criar o HashMap de cada classe com as listas(com regra de negocio) indexado pela operação
		
		
		
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
		
		
		/*Colocar os HashMaps criados no HashMap rns indexado pelo nome de cada classe
			Resumindo: Uma lista(rn) dentro de um hashmap(rn indexado pela operação) 
			dentro de um hashmap (hashmap Anterior indexado pelo nome da classe)*/
		
		
		rns.put(Cliente.class.getName(), rnsCliente);
		rns.put(Cartao.class.getName(), rnsCartao);
		rns.put(Endereco.class.getName(), rnsEndereco);
		rns.put(Login.class.getName(), rnsLogin);
		
		
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
				Cliente cli = (Cliente) resultado.getEntidades().get(0);
				System.out.println(cli.getNome());
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar o registro!");
				
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
				resultado.setMsg("Não foi possível realizar o registro!");
				
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
				resultado.setMsg("Não foi possível realizar o registro!");
				
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
				resultado.setMsg("Não foi possível realizar a consulta!");
				
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
