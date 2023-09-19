package atvBST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    private BTNode root;

    public BinaryTree() {
        this(null);
    }

    public BinaryTree(BTNode root) {
        this.root = root;
    }

    public BTNode getRoot() {
        return root;
    }

    public void setRoot(BTNode root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int getDegree() {
        return getDegreeHelper(root);
    }

    private int getDegreeHelper(BTNode node) {
        if (node == null || node.isLeaf()) {
            return 0;
        }

        int degree = node.getDegree();
        if (node.hasLeftChild()) {
            degree = Math.max(degree, getDegreeHelper(node.getLeft()));
        }
        if (node.hasRightChild()) {
            degree = Math.max(degree, getDegreeHelper(node.getRight()));
        }
        return degree;
    }

    public int getHeight() {
        if (isEmpty()) {
            return -1;
        }

        return root.getHeight();
    }

    public List<Funcionario> inOrderTraversal() {
        List<Funcionario> funcionarios = new ArrayList<>();
        inOrderTraversalHelper(root, funcionarios);
        return funcionarios;
    }

    private void inOrderTraversalHelper(BTNode node, List<Funcionario> funcionarios) {
        if (node == null) {
            return;
        }

        //Percorre a subarvore esquerda
        inOrderTraversalHelper(node.getLeft(), funcionarios);
        
        //Visita o nó atual e add o funcionario a lista
        Funcionario funcionario = (Funcionario) node.getData();
        funcionarios.add(funcionario);
        
        //Percorre a subárvore direita
        inOrderTraversalHelper(node.getRight(), funcionarios);
    }
    
    public float calculateSalaries() {
        return calculateSalariesHelper(root);
    }

    private float calculateSalariesHelper(BTNode node) {
        if (node == null) {
            return 0;
        }

        float leftSum = calculateSalariesHelper(node.getLeft());
        float rightSum = calculateSalariesHelper(node.getRight());

        return leftSum + rightSum + node.getData().getSalario();
    }
    public String preOrderTraversal() {
        return preOrderTraversalHelper(root);
    }

    private String preOrderTraversalHelper(BTNode node) {
        if (node == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        sb.append(node.getData() + " ");
        sb.append(preOrderTraversalHelper(node.getLeft()));
        sb.append(preOrderTraversalHelper(node.getRight()));

        return sb.toString();
    }

    public String postOrderTraversal() {
        return postOrderTraversalHelper(root);
    }

    private String postOrderTraversalHelper(BTNode node) {
        if (node == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        sb.append(postOrderTraversalHelper(node.getLeft()));
        sb.append(postOrderTraversalHelper(node.getRight()));
        sb.append(node.getData() + " ");

        return sb.toString();
    }

    public String levelOrderTraversal() {
        return levelOrderTraversalHelper(root);
    }

    private String levelOrderTraversalHelper(BTNode node) {
        if (node == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Queue<BTNode> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            BTNode visited = queue.remove();
            sb.append(visited.getData() + " ");

            if (visited.hasLeftChild()) {
                queue.add(visited.getLeft());
            }
            if (visited.hasRightChild()) {
                queue.add(visited.getRight());
            }
        }

        return sb.toString();
    }

    public int countNodes() {
        return countNodesRec(root);
    }

    private int countNodesRec(BTNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodesRec(node.getLeft()) + countNodesRec(node.getRight());
    }

    @Override
    public String toString() {
        return "BinaryTree - isEmpty(): " + isEmpty()
                + ", getDegree(): " + getDegree()
                + ", getHeight(): " + getHeight()
                + ", root => { " + root + " }";
    }
}
