package les12015.dominio;

public class Endereco extends EntidadeDominio{

	private String rua;
	private String numero;
	private String cep;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String identificacao;
	private boolean cobranca;
	private boolean pereferencial;
	private int idCliente;
	
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getIdentificacao() {
		return identificacao;
	}
	public void setIdentificacao(String identificacao) {
		this.identificacao = identificacao;
	}
	public boolean isCobranca() {
		return cobranca;
	}
	public void setCobranca(boolean cobranca) {
		this.cobranca = cobranca;
	}
	public boolean isPereferencial() {
		return pereferencial;
	}
	public void setPereferencial(boolean pereferencial) {
		this.pereferencial = pereferencial;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
	
	
}
