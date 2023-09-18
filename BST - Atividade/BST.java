package atvBST;

public class BST extends BinaryTree {

    public BST() {
        super();
    }

    public BST(BTNode root) {
        super(root);
    }

    public BTNode search(int identificacao) {
        return searchHelper(super.getRoot(), identificacao);
    }

    private BTNode searchHelper(BTNode node, int identificacao) {
        if (node == null) {
            return null;
        }

        int diff = identificacao - ((Funcionario) node.getData()).getId();

        if (diff < 0) {
            return searchHelper(node.getLeft(), identificacao);
        } else if (diff > 0) {
            return searchHelper(node.getRight(), identificacao);
        } else {
            return node;
        }
    }

    public void insert(Funcionario funcionario) {
        super.setRoot(insertHelper(super.getRoot(), null, funcionario));
    }

    private BTNode insertHelper(BTNode node, BTNode parent, Funcionario funcionario) {
        if (node == null) {
            return new BTNode(funcionario, parent);
        }

        int diff = funcionario.getId() - ((Funcionario) node.getData()).getId();

        if (diff < 0) {
            node.setLeft(insertHelper(node.getLeft(), node, funcionario));
        } else if (diff > 0) {
            node.setRight(insertHelper(node.getRight(), node, funcionario));
        } else {
            // Nessa implementação, não é permitida a inserção de duplicatas na BST.
        }

        return node;
    }

 // ...

    public void remove(int identificacao) {
        super.setRoot(removeHelper(super.getRoot(), identificacao));
    }

    private BTNode removeHelper(BTNode node, int identificacao) {
        if (node == null) {
            return null;
        }

        int diff = identificacao - ((Funcionario) node.getData()).getId();

        if (diff < 0) {
            node.setLeft(removeHelper(node.getLeft(), identificacao));
        } else if (diff > 0) {
            node.setRight(removeHelper(node.getRight(), identificacao));
        } else {
            node = removeNode(node);
        }

        return node;
    }

    private BTNode removeNode(BTNode node) {
        if (node.isLeaf()) {
            return null;
        }

        if (!node.hasLeftChild()) {
            return node.getRight();
        } else if (!node.hasRightChild()) {
            return node.getLeft();
        } else {
            BTNode predecessor = findMaxHelper(node.getLeft());
            node.setData(predecessor.getData());
            node.setLeft(removeHelper(node.getLeft(), ((Funcionario) predecessor.getData()).getId()));
        }

        return node;
    }

    public Funcionario findMin() {
        BTNode minNode = findMinHelper(super.getRoot());
        return minNode != null ? (Funcionario) minNode.getData() : null;
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

    public Funcionario findMax() {
        BTNode maxNode = findMaxHelper(super.getRoot());
        return maxNode != null ? (Funcionario) maxNode.getData() : null;
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

    public Funcionario findPredecessor(int identificacao) {
        BTNode node = search(identificacao);
        BTNode predecessorNode = predecessor(node);
        return predecessorNode != null ? (Funcionario) predecessorNode.getData() : null;
    }

    private BTNode predecessor(BTNode node) {
        if (node == null) {
            return null;
        }

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

    public Funcionario findSuccessor(int identificacao) {
        BTNode node = search(identificacao);
        BTNode successorNode = successor(node);
        return successorNode != null ? (Funcionario) successorNode.getData() : null;
    }

    private BTNode successor(BTNode node) {
        if (node == null) {
            return null;
        }

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

   

    @Override
    public String toString() {
        return "BST - isEmpty(): " + isEmpty()
                + ", getDegree(): " + getDegree()
                + ", getHeight(): " + getHeight()
                + ", root => { " + ((Funcionario) super.getRoot().getData()).getNome() + " }";
    }
}
