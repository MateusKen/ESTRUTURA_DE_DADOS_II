public class Automovel{

  //Atributos 
  private String placa;
  private String marca;
  private int ano;
  private float preco;
  
  //Operacoes

  //Getters
  public String getPlaca(){
    return placa;
  }
  
  public String getMarca(){
    return marca;
  }

  public int getAno(){
    return ano;
  }

  public float getPreco(){
    return preco;
  }

  //Setters
  public void setPlaca(String p){
    placa = p;
  }

  public void setMarca(String m){
    marca = m;
  }

  public void setAno(int a){
    ano = a;
  }

  public void setPreco(float pr){
    preco = pr;
  }
  
  public Automovel(){
    placa = new String ("nenhuma placa");
    marca = new String ("nenhuma marca");
    ano = 0;
    preco  = 0;
  }

  public Automovel(String placa, String marca, int ano, float preco){
    this.placa = placa;
    this.marca = marca;
    this.ano = ano;
    this.preco = preco;
  }
  
  public String toString(){
    String dados = "";
   dados = "placa: "+ this.placa +", marca: " + this.marca + ", ano: "+ this.ano +", preço:"+ this.preco;
    
    return dados;
  }
    
  
  }
