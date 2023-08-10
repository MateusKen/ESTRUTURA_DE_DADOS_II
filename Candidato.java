
public class Candidato {
	private int nCandidato;
	private int cpf;
	private String nome;
	private int idade;
	private Character sexo;
	private String mainGenero;
	
	public Candidato() {
		nCandidato = 0;
		cpf = 0;
		nome = new String("Nenhum-nome");
		idade = 0;
		sexo = 'N';
		mainGenero = new String("Nenhum-generopincipal");
	}
	
	public Candidato(int nCandidato, int cpf, String nome, int idade, Character sexo, String mainGenero) {
		this.nCandidato = nCandidato;
		this.cpf = cpf;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.mainGenero = mainGenero;
	}
	
	public int getNCandidato() {
		return nCandidato;
	}
	
	public void setNCandidato(int nCandidato) {
		this.nCandidato = nCandidato;
	}
	public int cpf() {
		return cpf;
	}
	
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Character getSexo() {
		return sexo;
	}
	
	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}
	
	public String getMainGenero() {
		return mainGenero;
	}
	
	public void setMainGenero(String mainGenero) {
		this.mainGenero = mainGenero;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Número Candidato: ")
			.append(nCandidato)
		.append("\nCPF: ")
			.append(cpf)
		.append("\nNome: ")
			.append(nome)
		.append("\nIdade: ")
			.append(idade)
		.append("\nSexo: ")
			.append(sexo)
		.append("Gênero musical principal: ")
			.append(mainGenero);
		
		return sb.toString();
	}
}
