package les12015.controle.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import les12015.controle.web.command.ICommand;
import les12015.controle.web.command.impl.AlterarCommand;
import les12015.controle.web.command.impl.ConsultarCommand;
import les12015.controle.web.command.impl.ExcluirCommand;
import les12015.controle.web.command.impl.SalvarCommand;
import les12015.controle.web.command.impl.VisualizarCommand;
import les12015.controle.web.vh.IViewHelper;
import les12015.controle.web.vh.impl.CarrinhoViewHelper;
import les12015.controle.web.vh.impl.CartaoViewHelper;
import les12015.controle.web.vh.impl.ClienteViewHelper;
import les12015.controle.web.vh.impl.CompraViewHelper;
import les12015.controle.web.vh.impl.CupomViewHelper;
import les12015.controle.web.vh.impl.EnderecoViewHelper;
import les12015.controle.web.vh.impl.LivroViewHelper;
import les12015.controle.web.vh.impl.LoginViewHelper;
import les12015.core.aplicacao.Resultado;
import les12015.dominio.EntidadeDominio;
import sun.util.resources.cldr.rn.CalendarData_rn_BI;

/**
 * Servlet implementation class Servlet
 */

public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static Map<String, ICommand> commands;
	private static Map<String, IViewHelper> vhs;
	
	
    /**
     * Default constructor. 
     */
    public Servlet() {
    	System.out.println("Construtor Servlet 2.0");
    	
    	/* Utilizando o command para chamar a fachada e indexando cada command 
    	 * pela opera��o garantimos que esta servelt atender� qualquer opera��o */
    	commands = new HashMap<String, ICommand>();

    	commands.put("SALVAR", new SalvarCommand());
    	commands.put("EXCLUIR", new ExcluirCommand());
    	commands.put("CONSULTAR", new ConsultarCommand());
    	commands.put("VISUALIZAR", new VisualizarCommand());
    	commands.put("ALTERAR", new AlterarCommand());
    	
    	
    	/* Utilizando o ViewHelper para tratar especifica��es de qualquer tela e indexando 
    	 * cada viewhelper pela url em que esta servlet � chamada no form
    	 * garantimos que esta servelt atender� qualquer entidade */
    	
    	vhs = new HashMap<String, IViewHelper>();
    	/*A chave do mapa � o mapeamento da servlet para cada form que 
    	 * est� configurado no web.xml e sendo utilizada no action do html
    	 */
    	
    	vhs.put("/les12015-web/SalvarLivro", new LivroViewHelper());
    	vhs.put("/les12015-web/ExcluirLivro", new LivroViewHelper());
    	vhs.put("/les12015-web/AlterarLivro", new LivroViewHelper());
    	vhs.put("/les12015-web/ConsultarLivro", new LivroViewHelper());
    	
    	vhs.put("/les12015-web/SalvarCliente", new ClienteViewHelper());
    	vhs.put("/les12015-web/ExcluirCliente", new ClienteViewHelper());
    	vhs.put("/les12015-web/AlterarCliente", new ClienteViewHelper());
    	vhs.put("/les12015-web/ConsultarCliente", new ClienteViewHelper());
    	
    	vhs.put("/les12015-web/SalvarCartao", new CartaoViewHelper());
    	vhs.put("/les12015-web/SalvarCartaoCompra", new CartaoViewHelper());
    	vhs.put("/les12015-web/ExcluirCartao", new CartaoViewHelper());
    	vhs.put("/les12015-web/AlterarCartao", new CartaoViewHelper());
    	vhs.put("/les12015-web/ConsultarCartao", new CartaoViewHelper());
    	
    	vhs.put("/les12015-web/SalvarEndereco", new EnderecoViewHelper());
    	vhs.put("/les12015-web/SalvarEnderecoCompra", new EnderecoViewHelper());
    	vhs.put("/les12015-web/ExcluirEndereco", new EnderecoViewHelper());
    	vhs.put("/les12015-web/AlterarEndereco", new EnderecoViewHelper());
    	vhs.put("/les12015-web/ConsultarEndereco", new EnderecoViewHelper());
    	
    	vhs.put("/les12015-web/SalvarCupom", new CupomViewHelper());
    	vhs.put("/les12015-web/ExcluirCupom", new CupomViewHelper());
    	vhs.put("/les12015-web/AlterarCupom", new CupomViewHelper());
    	vhs.put("/les12015-web/ConsultarCupomCliente", new CupomViewHelper());
    	vhs.put("/les12015-web/ConsultarCupomCompra", new CupomViewHelper());
 
    	vhs.put("/les12015-web/ConsultarLogin", new LoginViewHelper());
    	vhs.put("/les12015-web/AlterarLogin", new LoginViewHelper());
    	vhs.put("/les12015-web/ExcluirLogin", new LoginViewHelper());
    	
    	vhs.put("/les12015-web/SalvarCompra", new CompraViewHelper());
    	vhs.put("/les12015-web/ExcluirCompra", new CompraViewHelper());
    	vhs.put("/les12015-web/AlterarCompra", new CompraViewHelper());
    	vhs.put("/les12015-web/ConsultarCompra", new CompraViewHelper());
    	
    	vhs.put("/les12015-web/SalvarCarrinho", new CarrinhoViewHelper());
    	vhs.put("/les12015-web/AlterarCarrinho", new CarrinhoViewHelper());
    	vhs.put("/les12015-web/ExcluirCarrinho", new CarrinhoViewHelper());
    			vhs.put("/les12015-web/Teste", new CarrinhoViewHelper());
    	
    	
    	
    }
    
    
    /** 
     * TODO Descri��o do M�todo
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
    		IOException {
    	doProcessRequest(request, response);
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcessRequest(request, response);
	}
	
	
	protected void doProcessRequest(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
		//Obt�m a uri que invocou esta servlet (O que foi definido no methdo do form html)
		String uri = request.getRequestURI();
		
		
		//Obt�m a opera��o executada
		String operacao = request.getParameter("operacao");
		
		//Obt�m um viewhelper indexado pela uri que invocou esta servlet
		IViewHelper vh = vhs.get(uri);
		
		//O viewhelper retorna a entidade especifica para a tela que chamou esta servlet
		EntidadeDominio entidade =  vh.getEntidade(request);

		//Obt�m o command para executar a respectiva opera��o
		
		ICommand command = commands.get(operacao);
		
		
		/*Executa o command que chamar� a fachada para executar a opera��o requisitada
		 * o retorno � uma inst�ncia da classe resultado que pode conter mensagens derro 
		 * ou entidades de retorno
		 */
		System.out.println("Servlet... Uri: " + uri + "   View: " + vh + "   Entidade: " + entidade.getClass().getName());
		Resultado resultado = command.execute(entidade);
		
		/*
		 * Executa o m�todo setView do view helper espec�fico para definir como dever� ser apresentado 
		 * o resultado para o usu�rio
		 */
		vh.setView(resultado, request, response);
	
	}
}
