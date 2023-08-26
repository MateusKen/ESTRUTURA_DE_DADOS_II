class Vendedor extends Empregado{
	private float valorVendas;
	private float comissao;
	
	public Vendedor() {
		super();
		valorVendas = 0;
		comissao = 0;
	}
	
	public Vendedor(String nome, String endereco, String telefone, int codigoSetor, float salarioBase, float imposto, float valorVendas, float comissao) {
		super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
		this.valorVendas = valorVendas;
		this.comissao = comissao;
	}
	
	public float getValorVendas() {
		return valorVendas;
	}
	
	public void setValorVendas(float valorVendas) {
		this.valorVendas = valorVendas;
	}
	
	public float getComissao() {
		return comissao;
	}
	
	public void setComissao(float comissao) {
		this.comissao = comissao;
	}
	
	public float calcularSalario() {
		return super.calcularSalario()+(valorVendas*comissao);
	}
	
	public String toString() {
		return super.toString()+", Valor Vendas: "+getValorVendas()+", Comissão: "+getComissao();
	}
}
