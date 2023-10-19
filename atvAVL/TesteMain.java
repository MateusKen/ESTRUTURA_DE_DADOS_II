package atvAVL;

/*
Seja uma AVL inicialmente vazia, depois de inserir, na ordem a seguir, os objetos:
John, Ed, Albert, Gilbert, Steve, Zoe , Beth, Steward, Lois, Anne.

Modificar o programa de teste para inserir os valores indicados e 
realizar os percursos em ordem simétrica, pré-ordem, pós-ordem e em nível.
*/


public class TesteMain {
	public static void main(String [] args){
	   AVL a = new AVL();
	   //inserção dos dados
	   a.insereAVL("John");
	   a.insereAVL("Ed");
	   a.insereAVL("Albert");
	   a.insereAVL("Gilbert");
	   a.insereAVL("Steve");
	   a.insereAVL("Zoe");
	   a.insereAVL("Beth");
	   a.insereAVL("Steward");
	   a.insereAVL("Lois");
	   a.insereAVL("Anne");
	   
	   System.out.println("Percurso em nível: ");
	   String emNivel = a.levelOrderTraversal();
	   System.out.println(emNivel);
	   System.out.print("\n");
	   
	   System.out.println("Percurso em ordem: ");
	   String emOrdem = a.inOrderTraversal();
	   System.out.println(emOrdem);
	   System.out.print("\n");
	   
	   System.out.println("Percurso pre ordem: ");
	   String preOrdem = a.preOrderTraversal();
	   System.out.println(preOrdem);
	   System.out.print("\n");
	   
	   System.out.println("Percurso pos ordem: ");
	   String posOrdem = a.postOrderTraversal();
	   System.out.println(posOrdem);
	   System.out.print("\n");
	}
}
