public class Juri {
	private String nome;
	private String nomeArtista;
	private String generoMusical;
	
	public Juri() {
		nome = new String("Nenhum-nome");
		nomeArtista = new String("Nenhum-nome-artísitco");
		generoMusical = new String("Nenhum-genero-musical");
	}
	
	public Juri(String nome, String nomeArtista, String generoMusical) {
		this.nome = nome;
		this.nomeArtista = nomeArtista;
		this.generoMusical = generoMusical;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNomeArtista() {
		return nomeArtista;
	}
	
	public void setNomeArtista(String nomeArtista) {
		this.nomeArtista = nomeArtista;
	}

	public String getGeneroMusical() {
		return generoMusical;
	}
	
	public void setGeneroMusical(String generoMusical) {
		this.generoMusical = generoMusical;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome: ")
			.append(nome)
		.append("\nNome artístico: ")
			.append(nomeArtista)
		.append("\nGênero musical: ")
			.append(generoMusical);
		
		return sb.toString();
	}
}
