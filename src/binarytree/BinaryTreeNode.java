package binarytree;

/**
 * .
 *
 * @author Initial: amark
 * @version 1.0
 */
public class BinaryTreeNode {

    private String value;

    private BinaryTreeNode left;

    private BinaryTreeNode right;

    public BinaryTreeNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "value='" + value + '\'' +
                '}';
    }
}
