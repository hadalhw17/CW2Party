/**
 * Created by geron on 22.04.2017.
 */
public class BSTNode {

    private Profile data;
    private BSTNode left;
    private BSTNode right;

    public BSTNode(Profile data){this.data = data;}

    public Profile getProfile() {
        return data;
    }

    public BSTNode getLeft() { return left; }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getRight() {
        return right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }
}
