import java.util.Objects;

public class BinaryTree {
    protected Node root;

    public BinaryTree(Node root) {
        this.root = root;
    }


    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }

    int calculateHeight(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    static boolean areTreesEquivalent(Node node1, Node node2) {
        if (!Objects.equals(node1, node2)) {
            return false;
        }
        if (node1 != null) {
            if (node1.left != null && node2.left != null) {
                areTreesEquivalent(node1.left, node2.left);
            }
            if (node1.right != null && node2.right != null) {
                areTreesEquivalent(node1.right, node2.right);
            }
        }
        return true;
    }
}

