import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //a)
    int MAX_CARROS = 100;
    Automovel vet[] = new Automovel[MAX_CARROS];

    //b)
    Scanner sc1 = new Scanner(System.in);
    System.out.println("Digite o numero de carros:");
    int num_carros = sc1.nextInt();
    int cont = 0;
    
    while (cont<num_carros){
      vet[cont]  = new Automovel();
      
      System.out.printf("\nCarro %d%nDigite a placa:", cont+1);
      vet[cont].setPlaca(sc1.next());
      System.out.print("Digite a marca:");
      vet[cont].setMarca(sc1.next());
      System.out.print("Digite o ano:");
      vet[cont].setAno(sc1.nextInt());
      System.out.println("Digite o preco:");
      vet[cont].setPreco(sc1.nextFloat());
      cont++;
     }
    
    //c)
    cont = 0;
    while(cont<num_carros){
        System.out.printf("\nCarro %d%n%s%n", cont+1, vet[cont].toString());
      cont++;
    }

    //d)
    cont = 0;
    int cont2 = 0;
    System.out.println("\nDigite o nome de uma marca:");
    String filtro_marca = sc1.next();
    System.out.println("\nCarros dessa marca:");
    while (cont < num_carros) {
      if (vet[cont].getMarca().equalsIgnoreCase(filtro_marca)) {
        cont2++;
        System.out.printf("\n %d.%s%n", cont2, vet[cont].toString());
    }
    cont++;
    }
    if (cont2 == 0) 
      System.out.println("Nenhum carro dessa marca");
    

    //e)
    cont = 0;
    float soma_preco = 0;
    while (cont < num_carros) {
      soma_preco+=vet[cont].getPreco();
      cont++;     
    }
    float media = soma_preco/cont;
    System.out.printf("\nMédia de preço de todos os carros: %.2f%n", media);

    //f)
    cont = 0;
    cont2 = 0;
    System.out.println("\nDigite um ano:");
    int filtro_ano = sc1.nextInt();
    System.out.println("\nCarros fabricados depois desse ano:");
    while (cont < num_carros) {
      if (vet[cont].getAno()>filtro_ano) {
        cont2++;
        System.out.printf("\n %d.%s%n", cont2, vet[cont].toString());
    }
    cont++;
    }
    if (cont2 == 0) 
      System.out.println("Nenhum carro fabricado depois do ano fornecido.");
    else
      System.out.printf("\nQuantidade de carros fabricados depois do ano fornecido:%d",cont2);

    //g)
    cont = 0;
    cont2 = 0;
    soma_preco = 0;
    System.out.println("\n\nDigite um periodo");
    System.out.println("Ano inicial do periodo:");
    int ano_inicio = sc1.nextInt();
    System.out.println("Ano final do periodo:");
    int ano_final = sc1.nextInt();
    while (cont < num_carros) {
      if (vet[cont].getAno() >= ano_inicio && vet[cont].getAno() <= ano_final){
        cont2++;
        soma_preco+=vet[cont].getPreco();
      }
      cont++;
    }
    
    media = soma_preco/cont2;
    if (cont2 == 0) 
      System.out.println("Nenhum carro fabricado durante o periodo fornecido.");
    else
      System.out.printf("\nMédia de preço dos carros fabricados durante o periodo: %.2f%n", media);
    
  }
}