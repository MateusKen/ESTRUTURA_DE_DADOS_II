package atvBST;

import java.util.List;
import java.util.ArrayList;

import java.util.Scanner;


public class BST_Test {
		//--------------- Métodos implementados -------------------
    
	//Gastos - salários dos funcionários
	
	//Total de funcionários de um determinado sexo
	public static int contSexo(BST bst, char escolhaSexo) {
		int contSexo = 0;
		List<Funcionario> todosFuncionarios = bst.inOrderTraversal();
        for (Funcionario funcionario : todosFuncionarios) {
        	if (funcionario.getSexo() == escolhaSexo){
        		contSexo++;
        	}
        }
        return contSexo;
	}
	//Total de funcionários de uma determinada categoria
	public static int contCategoria(BST bst, char escolhaCategoria) {
		int contCategoria = 0;
		List<Funcionario> todosFuncionarios = bst.inOrderTraversal();
        for (Funcionario funcionario : todosFuncionarios) {
        	if (funcionario.getCategoria() == escolhaCategoria){
        		contCategoria++;
        	}
        }
        return contCategoria;
	}

	//Mostrar os dados dos funcionários com idade superior a uma determinada idade
	public static ArrayList<Funcionario> contIdade(BST bst, int escolhaIdade) {
	    ArrayList<Funcionario> funcIdade = new ArrayList<>();
	    List<Funcionario> todosFuncionarios = bst.inOrderTraversal();
	    for (Funcionario funcionario : todosFuncionarios) {
	        if (funcionario.getIdade() > escolhaIdade) {
	            funcIdade.add(funcionario);
	        }
	    }
	    
	    return funcIdade;
	}


	
	//main
    public static void main(String[] args) {
    	//Criar uma BST
        BST bst = new BST();
        Scanner scanner = new Scanner(System.in);
        
        
        
        //-------------- Valores de entrada ----------------
        //Criar funcionários
        Funcionario func1 = new Funcionario(1, 20, 'P', 'M', "Joao", "Desenvolvedor", 5000);
        Funcionario func2 = new Funcionario(2, 24, 'O', 'F', "Fabiana", "Consultora", 3000);
        Funcionario func3 = new Funcionario(3, 74, 'H', 'M', "Paulo", "Analista", 8000);
        
        //-------------- Inserir os funcionarios na arvore --------------
        bst.insert(func1);
        bst.insert(func2);
        bst.insert(func3);
        
        //-------------- Menu de opções ---------------------
        
        int opcao = 0;
        
        do {
        	
        	System.out.println("Menu de opções da BST: ");
            System.out.println("1. Mostrar resultado dos gastos com os salários dos funcionários");
            System.out.println("2. Mostrar o total de funcionários de um determinado sexo.");
            System.out.println("3. Mostrar o total de funcionários de uma determinada categoria.");
            System.out.println("4. Mostrar os dados dos funcionários com idade superior a uma determinada idade informada.");
            System.out.println("5. Encerrar o programa e o menu de opções.");
            System.out.print("Digite sua opção: ");
            	
            opcao = scanner.nextInt();
            switch(opcao) {
            case 1:
            	 float SalarioTotal = bst.calculateSalaries();
            	 System.out.println("Total salary expenses: " + SalarioTotal);
            	 break;
            case 2:
            	System.out.println("Você deseja saber a quantidade de funcionários do sexo:");
            	System.out.println("Masculino - tecle M \nFeminino - tecle F");
            	char escolhaSexo = scanner.next().charAt(0);
            	int qntFuncionarios = contSexo(bst, escolhaSexo);
            	System.out.println("Número de funcionários do sexo " + escolhaSexo + ": " + qntFuncionarios);
            	System.out.println("\n");
            	break;
            case 3:
            	System.out.println("Você deseja saber a quantidade de funcionários da categoria:");
            	System.out.println("Presencial - tecle P \nHome Office - tecle O \nHíbrido - tecle H");
            	char escolhaCategoria = scanner.next().charAt(0);
            	qntFuncionarios = contCategoria(bst, escolhaCategoria);
            	System.out.println("Número de funcionários da Categoria " + escolhaCategoria + ": " + qntFuncionarios);
            	System.out.println("\n");
            	break;
            case 4:
            	System.out.println("Você deseja saber os dados dos funcionários com idade superior a:");
            	System.out.println("Digite a idade:");
            	int escolhaIdade = scanner.nextInt();
            	System.out.println("Funcionários com idade maior que " + escolhaIdade+ ": \n");
            	ArrayList<Funcionario> funcionarios = contIdade(bst, escolhaIdade);
            	if (funcionarios.isEmpty()) {
            		System.out.println("Nenhum funcionário com idade maior que " + escolhaIdade+ "\n");
            	} else {
            		for (Funcionario funcionario : funcionarios) {
            		  System.out.println(funcionario.toString());
            	  }
            	}
            	System.out.println("\n");
            	break;
            case 5:
            	System.out.println("Programa encerrado");
            	scanner.close();
            	break;	
            } // fim do switch
        }while (opcao != 5);
   }
} // Fim da classe BST_Test.java
