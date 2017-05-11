/**
 * Created by geron on 11.05.2017.
 * Main class for BSTNode.java
 */
public class BSTNodeMain {

    public static void main(String[] args) {

        String[] interests = {"Sit", "Eat", "Sleep", "Play Games", "Have a cool life"};
        Profile boris = new Profile("Boris", 17, 6, 1997, "Novosibirsk", "Russia", "Russian", interests);

        BSTNode node = new BSTNode(boris);

        System.out.print("Adding node to the left of node...\n");
        node.setLeft(node);
        System.out.println("Node added...\nExpected profile name is Boris.\nChecking name...");
        System.out.print("The name of the profile in the left node of node is "
                + node.getLeft().getProfile().getName());
        System.out.println("Correct.");
        System.out.println("Dude to similarity of other methods to getLeft()\n" +
                "setLeft() and getProfile, others are not tested.");
    }
}
