package Objetos;

public class ProdutoDetalhes {
	
	private int codigo;
	private String codigoBarras;
	private String nome;
	private int fornecedor;
	private Double precovenda;
	private Double precocompra;
	private String desc;
	private int Status;
	private int estmin;
	private String dtIncl;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCodigoBarras() {
		return codigoBarras;
	}
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPrecovenda() {
		return precovenda;
	}
	public void setPrecovenda(Double precovenda) {
		this.precovenda = precovenda;
	}
	public Double getPrecocompra() {
		return precocompra;
	}
	public void setPrecocompra(Double precocompra) {
		this.precocompra = precocompra;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public int getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(int fornecedor) {
		this.fornecedor = fornecedor;
	}
	public int getEstmin() {
		return estmin;
	}
	public void setEstmin(int estmin) {
		this.estmin = estmin;
	}
	public String getDtIncl() {
		return dtIncl;
	}
	public void setDtIncl(String dtIncl) {
		this.dtIncl = dtIncl;
	}
	
}
