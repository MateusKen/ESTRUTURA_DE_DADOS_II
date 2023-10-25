package atvAVL;

import java.util.Scanner;

public class MainEstoque {
	public static void main(String [] args){
		Scanner scanner = new Scanner(System.in);
		
		
		//Menu de opções
		int opcao = 0;
        do {
        	System.out.println("Menu de opções: ");
            System.out.println("1. Ler dados de um produto do estoque.");
            System.out.println("2. Apresentar todos os produtos do estoque (ordem crescente).");
            System.out.println("3. Calcular valor em R$ de um determinado produto em estoque.");
            System.out.println("4. Calcular valor total do estoque.");
            System.out.println("5. Mostrar produtos que possuem quantidade no estoque inferoires a um determinado valor.");
            System.out.println("6. Finalizar programa.");
            System.out.print("Digite sua opção: ");
            	
            opcao = scanner.nextInt();
            switch(opcao) {
            case 1:
            	//implementar
            	break;
            case 2:
            	//implementar
            	break;
            case 3:
            	//implementar
            	break;
            case 4:
            	//implementar
            	break;
            case 5:
            	//implementar
            	break;	
            case 6:
            	System.out.println("Programa encerrado");
            	scanner.close();
            	break;
            } // fim do switch
        }while (opcao != 6);
	}
	
}//Fim da classe MainEstoque.java
