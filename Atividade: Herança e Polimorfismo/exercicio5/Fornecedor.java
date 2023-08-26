class Fornecedor extends Pessoa{
  private float valorCredito;
  private float valorDivida;

  public Fornecedor(){
    super();
    valorCredito = 0;
    valorDivida = 0;
  }

  public Fornecedor(String nome, String endereco, String telefone, float valorCredito, float valorDivida){
    super(nome, endereco, telefone);
    this.valorCredito = valorCredito;
    this.valorDivida = valorDivida;
  }

  public float getValorCredito(){
    return valorCredito;
  }

  public void setValorCredito(float valorCredito){
    this.valorCredito = valorCredito;
  }

public float getValorDivida(){
  return valorDivida;
  }

public void setValorDivida(float valorDivida){
this.valorDivida = valorDivida;
  }

  public float obterSaldo(){
    return valorCredito - valorDivida;
  }

  public String toString(){
    return super.toString()+" , Valor Crédito: "+getValorCredito()+" , Valor Dívida: "+getValorDivida();
  }
}
