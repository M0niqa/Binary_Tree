import static org.junit.Assert.*;

import org.junit.Test;


public class BinaryTreeTest {

    @Test
    public void countLeavesWhenEmptyTreeShouldReturnZero() {
        BinaryTree bt = new BinaryTree(null);
        int leavesCount = bt.countLeaves(bt.root);
        assertEquals(0, leavesCount);
    }

    @Test
    public void countLeavesWhenOnlyRootPresentShouldReturnOne() {
        BinaryTree bt = new BinaryTree(new Node(1));
        int leavesCount = bt.countLeaves(bt.root);
        assertEquals(1, leavesCount);
    }

    @Test
    public void shouldCountLeavesOfTreeWithMultipleNodes() {
        BinaryTree bt = new BinaryTree(new Node(1));
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
//                        1
//                      /   \
//                     2     3
//                    / \
//                   4   5
        int leavesCount = bt.countLeaves(bt.root);
        assertEquals(3, leavesCount);
    }

    @Test
    public void calculateHeightWhenEmptyTreeShouldReturnMinusOne() {
        BinaryTree bt = new BinaryTree(null);
        int height = bt.calculateHeight(bt.root);
        assertEquals(-1, height);
    }

    @Test
    public void calculateHeightWhenOnlyRootShouldReturnZero() {
        BinaryTree bt = new BinaryTree(new Node(1));
        int height = bt.calculateHeight(bt.root);
        assertEquals(0, height);
    }

    @Test
    public void shouldCalculateHeightOfTreeWithMultipleNodes() {
        BinaryTree bt = new BinaryTree(new Node(1));
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);
        bt.root.left.right = new Node(5);
//                        1
//                      /   \
//                     2     3
//                    / \
//                   4   5
        int leavesCount = bt.calculateHeight(bt.root);
        assertEquals(2, leavesCount);
    }

    @Test
    public void areTreesEquivalentShouldReturnTrueIfTreesEmpty() {
        BinaryTree bt = new BinaryTree(null);
        BinaryTree bt2 = new BinaryTree(null);
        assertTrue(BinaryTree.areTreesEquivalent(bt.root, bt2.root));
    }

    @Test
    public void areTreesEquivalentShouldReturnTrueIfEqual() {
        BinaryTree bt = new BinaryTree(new Node(1));
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);

        BinaryTree bt2 = new BinaryTree(new Node(1));
        bt2.root.left = new Node(2);
        bt2.root.right = new Node(3);
        bt2.root.left.left = new Node(4);

        assertTrue(BinaryTree.areTreesEquivalent(bt.root, bt2.root));
    }

    @Test
    public void areTreesEquivalentShouldReturnFalseIfNotEqualButSameStructure() {
        BinaryTree bt = new BinaryTree(new Node(1));
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);

        BinaryTree bt2 = new BinaryTree(new Node(1));
        bt2.root.left = new Node(2);
        bt2.root.right = new Node(3);
        bt2.root.left.left = new Node(5);

        assertFalse(BinaryTree.areTreesEquivalent(bt.root, bt2.root));
    }

    @Test
    public void areTreesEquivalentShouldReturnFalseIfNotEqualAndDifferentStructure() {
        BinaryTree bt = new BinaryTree(new Node(1));
        bt.root.left = new Node(2);
        bt.root.right = new Node(3);
        bt.root.left.left = new Node(4);

        BinaryTree bt2 = new BinaryTree(new Node(1));
        bt2.root.left = new Node(2);
        bt2.root.right = new Node(3);

        assertFalse(BinaryTree.areTreesEquivalent(bt.root, bt2.root));
    }
}