class Pessoa{
  private String nome;
  private String endereco;
  private String telefone;

  public Pessoa(){
    nome = new String("no-name");
    endereco = new String("no-address");
    telefone = new String("no-telephone");
  }

  public Pessoa(String nome, String endereco, String telefone){
    this.nome = nome;
    this.endereco = endereco;
    this.telefone = telefone;
  }

  public Pessoa(String nome){
    this.nome = nome;
    endereco = new String("no-address");
    telefone = new String("no-telephone");
  }

  public String getNome(){
    return nome;
  }

  public void setNome(String nome){
    this.nome = nome;
  }

  public String getEndereco(){
    return endereco;
  }

  public void setEndereco(String endereco){
    this.endereco = endereco;
  }

  public String getTelefone(){
    return telefone;
  }

  public void setTelefone(String telefone){
    this.telefone = telefone;
  }

  @Override
  public String toString(){
    String texto = ""; 
    texto = "Nome: "+getNome()+" , Endereço: "+getEndereco()+" , Telefone: "+getTelefone();
    return texto;
  }
}
