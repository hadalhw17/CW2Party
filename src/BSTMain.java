/**
 * Created by geron on 22.04.2017.
 */
public class BSTMain {

    public static void main(String[] args) {
        String[] interests = {"wank", "jerk", "drink vodka"};
        Profile bors = new Profile("Boris", 17, 6, 1997, "Novosibirsk", "Russia", "Russian", interests);
        Profile vladimir = new Profile("Vladimir", 17, 6, 1997, "Novosibirsk", "Russia", "Russian", interests);
        Profile nikolai = new Profile("Nikolai", 17, 6, 1997, "Novosibirsk", "Russia", "Russian", interests);
        BST bt = FileReader.readProfiles("profiles.txt");

        bt.printAlphabetical(bt.getRoot());
    }
}
