/**
 * Created by geron on 22.04.2017.
 */
public class BST {

    BSTNode root;

    public BST() {
        this.root = null;
    }

    public void insertProfile(Profile p) {
        root = insertNode(root, new BSTNode(p));
    }

    private BSTNode insertNode(BSTNode currentParent, BSTNode newNode) {

        if (currentParent == null) {
            return newNode;
        } else if (root.getProfile().getName().compareToIgnoreCase(newNode.getProfile().getName()) > 0) {
            currentParent.setLeft(insertNode(currentParent.getLeft(), newNode));
        } else if (root.getProfile().getName().compareToIgnoreCase(newNode.getProfile().getName()) < 0) {
            currentParent.setRight(insertNode(currentParent.getRight(), newNode));
        }
        return currentParent;
    }

    public void printAlphabetical(BSTNode focusNode) {
        if (focusNode.getLeft() != null) {
            // Traverse the left node
            printAlphabetical(focusNode.getLeft());
        }
        System.out.println(focusNode.getProfile().getName());
        // Traverse the right node
        if (focusNode.getRight() != null) {
            printAlphabetical(focusNode.getRight());
        }
    }

    public BSTNode find(String name) {
        BSTNode current = root;
        while (current != null) {
            if (current.getProfile().getName().compareToIgnoreCase(name) == 0) {
                return current;
            } else if (current.getProfile().getName().compareToIgnoreCase(name) > 0) {
                current = current.getLeft();
            } else if (current.getProfile().getName().compareToIgnoreCase(name) < 0) {

                current = current.getRight();
            }
        }
        return current;
    }
}
