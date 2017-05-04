/**
 * Created by geron on 22.04.2017.
 */
public class BSTMain {

    public static void main(String[] args) {
        String[] interests = {"wank", "jerk", "drink vodka"};
        Profile Bors = new Profile("Boris", 17, 6, 1997, "Novosibirsk", "Russia", "Russian", interests);
        Profile Vladimir = new Profile("Vladimir", 17, 6, 1997, "Novosibirsk", "Russia", "Russian", interests);
        Profile Nikolai = new Profile("Nikolai", 17, 6, 1997, "Novosibirsk", "Russia", "Russian", interests);
        BST bt = FileReader.readProfiles("test.txt");
        // BSTNode root = new BSTNode();

        //bt.preorderTraverseTree(bt.root);
        System.out.print(bt.root.getLeft().getProfile().toString());
    }
}
