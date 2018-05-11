package les12015.dominio;

public class Cartao extends EntidadeDominio{
	
	private String titular;
	private String numero;
	private String codSeguranca;
	private String dataVenc;			//String?!
	private boolean preferencial;
	private int idCliente;
	
	public String getTitular() {
		return titular;
	}
	public void setTitular(String titular) {
		this.titular = titular;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCodSeguranca() {
		return codSeguranca;
	}
	public void setCodSeguranca(String codSeguranca) {
		this.codSeguranca = codSeguranca;
	}
	public String getDataVenc() {
		return dataVenc;
	}
	public void setDataVenc(String dataVenc) {
		this.dataVenc = dataVenc;
	}
	public boolean isPreferencial() {
		return preferencial;
	}
	public void setPreferencial(boolean preferencial) {
		this.preferencial = preferencial;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
}
