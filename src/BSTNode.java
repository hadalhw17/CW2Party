/**
 * Class representing a node of a binary search tree.
 * @author Slobodov Aleksandr
 * @version 1.0
 */
public class BSTNode {

    /**
     * Profile inserted into node.
     */
    private Profile data;
    /**
     * Left node.
     */
    private BSTNode left;
    /**
     * Right node.
     */
    private BSTNode right;

    /**
     * Constructor.
     *
     * @param profile profile contained into this node
     */
    public BSTNode(final Profile profile) {
        this.data = profile;
    }

    /**
     * Getter for profile.
     *
     * @return profile
     */
    public Profile getProfile() {
        return data;
    }

    /**
     * Getter for left node.
     *
     * @return left node
     */
    public BSTNode getLeft() {
        return left;
    }

    /**
     * Setter for left node.
     *
     * @param leftNode node which is needed to be inserted to the left
     */
    public void setLeft(final BSTNode leftNode) {
        this.left = leftNode;
    }

    /**
     * Getter for right node.
     *
     * @return right node
     */
    public BSTNode getRight() {
        return right;
    }

    /**
     * Setter for right node.
     *
     * @param rightNode node which is needed to be inserted to the right
     */
    public void setRight(final BSTNode rightNode) {
        this.right = rightNode;
    }
}
