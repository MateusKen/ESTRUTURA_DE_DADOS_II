import java.util.Scanner;

class Teste {
  public static void main(String[] args) {
    Avaliacao.notafinal = 10;
    Scanner input = new Scanner(System.in);
 
    System.out.println("Forneça o nome da avaliação: ");
    String nome = input.nextLine();
    System.out.println("Forneça o tipo da avaliação: ");
    String tipo = input.nextLine();
    System.out.println("Forneça a nota da avaliação: ");
    float nota = input.nextFloat();
    
    Avaliacao x = new Avaliacao(nome, tipo, nota);
    System.out.println("Avaliação Final: " + Avaliacao.notafinal);
    System.out.println(x);
    //fechar o scanner
    input.close();
  }
}
