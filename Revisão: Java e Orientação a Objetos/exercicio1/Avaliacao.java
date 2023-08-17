public class Avaliacao{
  static float notafinal = 0;  //variável global
  private String nome;
  private String tipoavaliacao;
  private float nota;

  //Construtores
  //não precisa colocar notafinal como atributo nos construtores

  public Avaliacao(){
    nome = "";
    tipoavaliacao = "";
    nota = 0;
  }

  public Avaliacao(String nome, String tipoavaliacao, float nota){
    this.nome = nome;
    this.tipoavaliacao = tipoavaliacao;
    this.nota = nota;
  }

  public int percentual(){
    return (int) ((nota/notafinal) * 100); 
  }

  @Override
  public String toString(){
    String aux = "";
    aux = "Nome: " + this.nome + ", Tipo: " + tipoavaliacao + ", Nota: " + String.format("%.2f", this.nota) + " , Percentual: " + percentual();
    return aux;
  }
}