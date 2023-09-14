package atvBST;
import java.util.Scanner;

public class BST_Test {

	public static void main(String[] args) {		

		BST bst = new BST();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			
			System.out.println("\n\n\nBinary Search Tree Test Menu:");
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Search");
			System.out.println("4. Inorder Traversal");	
			System.out.println("5. Number of Nodes");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			
			String choiceStr = scanner.nextLine();
			int choice = Integer.parseInt(choiceStr);
			String data = "";
			switch (choice) {
			case 1:
				System.out.print("Enter data to insert: ");
				data = scanner.nextLine();
				bst.insert(data);
				break;
			case 2:
				System.out.print("Enter data to delete: ");
				data = scanner.nextLine();
				bst.remove(data);
				break;
			case 3:
				System.out.print("Enter data to search: ");
				data = scanner.nextLine();
				boolean found = 
						(bst.search(data) != null) ? true: false;
				System.out.println("Value " + data + " found: " + found);
				break;
			case 4:
				System.out.println("InOrder Traversal:");
				String resultado = bst.inOrderTraversal();
				System.out.println(resultado);
				break;
			case 5:
				System.out.println("Number of nodes:"+bst.countNodes());
				break;				
			case 6:
				System.out.println("Exiting...");
				scanner.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
	}
}
