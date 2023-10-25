package atvAVL;

public class BST extends BinaryTree {

	public BST() {
		super();
	}

	public BST(BTNode root) {
		super(root);
	}

	public BTNode search(Estoque data) {
		return search(data, false);
	}

	public BTNode searchIgnoreCase(Estoque data) {
		return search(data, true);
	}

	private BTNode search(Estoque data, boolean ignoreCase) {
		return searchHelper(super.getRoot(), data, ignoreCase);
	}
	
	private BTNode searchHelper(BTNode node, Estoque data, boolean ignoreCase) {
		if (node == null) {
			return null;
		}
		
		int diff = diffCompare(data, node.getData(), ignoreCase);

		if (diff < 0) {
			return searchHelper(node.getLeft(), data, ignoreCase);
		} else if (diff > 0) {
			return searchHelper(node.getRight(), data, ignoreCase);
		} else {
			return node;
		}
	}
	
	public void insert(Estoque data) {
		insert(data, false);
	}
	
	public void insertIgnoreCase(Estoque data) {
		insert(data, true);
	}
	
	private void insert(Estoque data, boolean ignoreCase) {
		super.setRoot(insertHelper(super.getRoot(), null, data, ignoreCase));
	}
	
	private BTNode insertHelper(BTNode node, BTNode parent, Estoque data, boolean ignoreCase) {
		if (node == null) {
			return new BTNode(data, parent);
		}

		int diff = diffCompare(data, node.getData(), ignoreCase);
		
		if (diff < 0) {
			node.setLeft(insertHelper(node.getLeft(), node, data, ignoreCase));
		} else if (diff > 0) {
			node.setRight(insertHelper(node.getRight(), node, data, ignoreCase));
		} else {
			// Nessa implementação, não é permitida a inserção de duplicatas na BST.
		}
		
		return node;
	}
	
	public void remove(Estoque data) {
		remove(data, false);
	}
	
	public void removeIgnoreCase(Estoque data) {
		remove(data, true);
	}
	
	private void remove(Estoque data, boolean ignoreCase) {
		super.setRoot(removeHelper(super.getRoot(), data, ignoreCase));
	}
	
	private BTNode removeHelper(BTNode node, Estoque data, boolean ignoreCase) {
		if (node == null) {
			return null;
		}
		
		int diff = diffCompare(data, node.getData(), ignoreCase);
				
		if (diff < 0) {
			node.setLeft(removeHelper(node.getLeft(), data, ignoreCase));
		} else if (diff > 0) {
			node.setRight(removeHelper(node.getRight(), data, ignoreCase));
		} else {
			node = removeNode(node, ignoreCase);
		}
		
		return node;		
	}
	
	private BTNode removeNode(BTNode node, boolean ignoreCase) {
		if (node.isLeaf()) {
			return null;
		}
		
		if (!node.hasLeftChild()) {
			return node.getRight();
		} else if (!node.hasRightChild()) {
			return node.getLeft();
		} else {
			BTNode predecessor = predecessor(node.getData(), ignoreCase);
			node.setData(predecessor.getData());
			node.setLeft(removeHelper(node.getLeft(), predecessor.getData(), ignoreCase));
		}
		
		return node;		
	}
	
	public BTNode findMin() {
		return findMinHelper(super.getRoot());
	}
	
	private BTNode findMinHelper(BTNode node) {
		if (node == null) {
			return null;
		} else {
			while (node.hasLeftChild()) {
				node = node.getLeft();
			}
			return node;
		}
	}
	
	public BTNode findMax() {
		return findMaxHelper(super.getRoot());
	}
	
	private BTNode findMaxHelper(BTNode node) {
		if (node == null) {
			return null;
		} else {
			while (node.hasRightChild()) {
				node = node.getRight();
			}
			return node;
		}
	}
	
	public BTNode findPredecessor(Estoque data) {
		return predecessor(data, false);
	}
	
	public BTNode findPredecessorIgnoreCase(Estoque data) {
		return predecessor(data, true);
	}

	private BTNode predecessor(Estoque data, boolean ignoreCase) {
		BTNode node = search(data, ignoreCase);
		return node == null ? null : predecessorHelper(node, ignoreCase);
	}
	
	private BTNode predecessorHelper(BTNode node, boolean ignoreCase) {
		if (node.hasLeftChild()) {
			return findMaxHelper(node.getLeft());
		} else {
			BTNode current = node;
			BTNode parent = node.getParent();

			while (parent != null && current == parent.getLeft()) {
				current = parent;
				parent = current.getParent();
			}
			
			return parent;
		}
	}
	
	public BTNode findSuccessor(Estoque data) {
		return successor(data, false);
	}
	
	public BTNode findSuccessorIgnoreCase(Estoque data) {
		return successor(data, true);
	}

	private BTNode successor(Estoque data, boolean ignoreCase) {
		BTNode node = search(data, ignoreCase);
		return node == null ? null : successorHelper(node, ignoreCase);		
	}
	
	private BTNode successorHelper(BTNode node, boolean ignoreCase) {
		if (node.hasRightChild()) {
			return findMinHelper(node.getRight());
		} else {
			BTNode current = node;
			BTNode parent = node.getParent();

			while (parent != null && current == parent.getRight()) {
				current = parent;
				parent = current.getParent();
			}
			
			return parent;
		}
	}

	private int diffCompare(Estoque estoque1, Estoque estoque2, boolean ignoreCase) {
		if (ignoreCase) {
			String codigoProduto1 = String.valueOf(estoque1.getCodigoProduto());
			String codigoProduto2 = String.valueOf(estoque2.getCodigoProduto());
			return codigoProduto1.compareToIgnoreCase(codigoProduto2);
		} else { 
			return Integer.compare(estoque1.getCodigoProduto(), estoque2.getCodigoProduto());
		}
	}
	
	public String toEstoque() {
		return "BST - isEmpty(): " + isEmpty()
				+ ", getDegree(): " + getDegree()
				+ ", getHeight(): " + getHeight()
				+ ", root => { " + super.getRoot().getData() + " }";				
	}

}
