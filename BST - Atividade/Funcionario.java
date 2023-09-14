package atvBST;

public class Funcionario {
	private int id, idade;
	private char categoria, sexo;
	private String nome, cargo;
	private float salario;
	
	public Funcionario() {
		id = 0;
		idade = 0;
		categoria = 'X';
		sexo = 'X';
		nome = "sem-nome";
		cargo = "sem-cargo";
		salario = 0;
	}
	
	public Funcionario(int id, int idade, char categoria, char sexo, String nome, String cargo, float salario) {
		this.id = id;
		this.idade = idade;
		this.categoria = categoria;
		this.sexo = sexo;
		this.nome = nome;
		this.cargo = cargo;
		this.salario = salario;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public char getCategoria() {
		return categoria;
	}
	
	public void setCategoria(char categoria) {
		this.categoria = categoria;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public float getSalario() {
		return salario;
	}
	
	public void setSalario(float salario) {
		this.salario = salario;
	}
}
