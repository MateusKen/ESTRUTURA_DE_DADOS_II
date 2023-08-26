
public class Operario extends Empregado{
	private float valorProducao;
	private float comissao;
	
	public Operario() {
		super();
		valorProducao = 0;
		comissao = 0;
	}
	
	public Operario(String nome, String endereco, String telefone, int codigoSetor, float salarioBase, float imposto,float valorProducao, float comissao) {
		super(nome, endereco, telefone, codigoSetor, salarioBase, imposto);
		this.valorProducao = valorProducao;
		this.comissao = comissao;
	}
	
	public float getValorProducao() {
		return valorProducao;
	}
	
	public void setValorProducao(float valorProducao) {
		this.valorProducao = valorProducao;
	}
	
	public float getComissao() {
		return comissao;
	}
	
	public void setComissao(float comissao) {
		this.comissao = comissao;
	}
	
	public float calcularSalario() {
		return super.calcularSalario()+(comissao*valorProducao);
	}
	
	public String toString() {
		return super.toString()+", Valor Produção: "+getValorProducao()+", Comissão: "+getComissao();
	}

}
