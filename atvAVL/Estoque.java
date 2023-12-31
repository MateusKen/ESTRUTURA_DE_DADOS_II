package atvAVL;

public class Estoque {
	private int codigoProduto;
	private String nome;
	private int qtde;
	private float valorUnitario;
	
	//Construtor
	public Estoque (int codigoProduto, String nome, int qtde, float valorUnitario) {
		this.codigoProduto = codigoProduto;
		this.nome = nome;
		this.qtde = qtde;
		this.valorUnitario = valorUnitario;
	}
	
	//Metodos getters e setters
	public int getCodigoProduto() {
		return codigoProduto;
	}
	public String getNome() {
		return nome;
	}
	public int getQtde() {
		return qtde;
	}
	public float getValorUnitario() {
		return valorUnitario;
	}
	
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public void setValorUnitario(float valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public int compareToIgnoreCase(Estoque estoque) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int compareTo(Estoque estoque) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		return "Código: " + this.codigoProduto + ", Nome: " + this.nome + ", Quantidade: " + this.qtde + ", Valor Unitário: " + this.valorUnitario + "\n";
	}
}
