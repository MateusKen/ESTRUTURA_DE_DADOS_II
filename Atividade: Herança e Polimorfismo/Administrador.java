
class Empregado extends Pessoa{
	private int codigoSetor;
	private float salarioBase;
	private float imposto;
	
	public Empregado() {
		super();
		codigoSetor = 0;
		salarioBase = 0;
		imposto = 0;
	}
	
	public Empregado(String nome, String endereco, String telefone, int codigoSetor, float salarioBase, float imposto) {
		super(nome, endereco, telefone);
		this.codigoSetor = codigoSetor;
		this.salarioBase = salarioBase;
		this.imposto = imposto;	
	}
	
	public int getCodigoSetor() {
		return codigoSetor;
	}
	
	public void setCodigoSetor(int codigoSetor) {
		this.codigoSetor = codigoSetor;
	}
	
	public float getSalarioBase() {
		return salarioBase;
	}
	
	public void setSalarioBase(float salarioBase) {
		this.salarioBase = salarioBase;
	}
	
	public float getImposto() {
		return imposto;
	}
	
	public void setImposto(float imposto) {
		this.imposto = imposto;
	}
	
	public float calcularSalario() {
		return salarioBase - (salarioBase*imposto);
	}
	
	public String toString() {
		return super.toString()+", Código Setor: "+getCodigoSetor()+", Salário Base: "+getSalarioBase()+", Imposto: "+getImposto();
	}
}
