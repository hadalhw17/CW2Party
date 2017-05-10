/**
 * This class represents a binary search tree.
 * @author Slobodov Aleksandr
 * @version 1.0
 */
public class BST {

    /**
     * Root node of a binary search tree.
     */
    private BSTNode root;

    /**
     * Constructor which set root to null.
     */
    public BST() {
        this.root = null;
    }

    /**
     * This method calls private method insertProfile.
     * @param p A profile which is needed to be added
     */
    public void insertProfile(final Profile p) {
        root = insertProfile(root, new BSTNode(p));
    }

    /**
     * This method adds new profile to binary search tree.
     * @param currentParent root node of binary search tree
     * @param newNode a node with new profile created in it
     * @return final node with profile added either to the right or left
     */
    private BSTNode insertProfile(final BSTNode currentParent,
                                  final BSTNode newNode) {
        int compareResult;
        BSTNode newParent = null;
        if (currentParent == null) {
            return newNode;
        }
        compareResult = currentParent.getProfile().getName().
                compareTo(newNode.getProfile().getName());
        if (compareResult > 0) {
            newParent = currentParent.getLeft();
            currentParent.setLeft(insertProfile(newParent, newNode));
        } else if (compareResult < 0) {
            newParent = currentParent.getRight();
            currentParent.setRight(insertProfile(newParent, newNode));
        }
        return currentParent;
    }

    /**
     * This method calls a private method printAlphabetical.
     * It is done not to access root from outside of this class.
     */
    public void printAlphabetical() {
        printAlphabetical(root);
    }
    /**
     * Inorder traverse for binary search tree.
     * @param focusNode a starting point for inorder traverse
     */
    private void printAlphabetical(final BSTNode focusNode) {
        // Traverse the left node
        if (focusNode.getLeft() != null) {
            printAlphabetical(focusNode.getLeft());
        }
        System.out.println(focusNode.getProfile().getName());
        // Traverse the right node
        if (focusNode.getRight() != null) {
            printAlphabetical(focusNode.getRight());
        }
    }

    /**
     * This method finds node by profile name.
     * @param name name of a profile which is needed to find
     * @return node with profile required
     */
    public Profile find(final String name) {
        BSTNode current = root;
        while (current != null) {
            if (current.getProfile().getName().compareTo(name) == 0) {
                return current.getProfile();
            } else if (current.getProfile().getName().compareTo(name) > 0) {
                current = current.getLeft();
            } else if (current.getProfile().getName().compareTo(name) < 0) {
                current = current.getRight();
            }
        }
        return current.getProfile();
    }
}
