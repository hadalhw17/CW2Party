import java.util.ArrayList;
import java.util.List;

/**
 * Created by geron on 22.04.2017.
 */
public class Graph {

    /**
     * Name of file.
     */
    private String filename;

    /**
     * Binary search tree where all profiles gonna be added.
     */
    private BST bt;

    /**
     * Edges of a graph(relations between profiles).
     */
    private List<Profile> edges = new ArrayList<Profile>();

    /**
     * Constructor.
     * @param fileName name of file
     * @param tree bst with all profiles
     */
    public Graph(final String fileName, final BST tree) {
        this.filename = fileName;
        this.bt = tree;
    }

    /**
     * Fill in the graph.
     * @param focusNode root node of a binary search tree with profiles
     */
    public void addProfiles(final BSTNode focusNode) {
        if (focusNode.getLeft() != null) {
            edges.add(focusNode.getProfile());
            addProfiles(focusNode.getLeft());
        } else if (focusNode.getRight() != null) {
            edges.add(focusNode.getProfile());
            addProfiles(focusNode.getRight());
        }
    }

    /**
     * Finds all common friends of a and b including a and b.
     * @param a profile 1
     * @param b profile 2
     * @return bst with common friends if there are some, null otherwise
     */
    public BST commonFriends(final Profile a, final Profile b) {
        BST friend = new BST();
        for (int i = 0; i < a.getNumOfFriends(); i++) {
            for (int n = 0; n < b.getNumOfFriends(); n++) {
                if (bt.find(a.getName()).getProfile().getFriend(i).getName().
                        equals(bt.find(b.getName()).getProfile().getFriend(n).
                                getName())) {
                    friend.insertProfile(bt.find(b.getName()).getProfile()
                            .getFriend(n));
                }
            }
            if (bt.find(a.getName()).getProfile().getFriend(i).getName().
                    equals(bt.find(b.getName()).getProfile().getName())) {
                friend.insertProfile(a);
                friend.insertProfile(b);
            }
        }
        return friend;
    }


}
