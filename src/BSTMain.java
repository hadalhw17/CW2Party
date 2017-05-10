/**
 * Created by geron on 22.04.2017.
 */
public class BSTMain {

    public static void main(String[] args) {
        String[] interests = {"Sit", "Eat", "Sleep", "Play Games", "Have a cool life"};
        Profile boris = new Profile("Boris", 17, 6, 1997, "Novosibirsk", "Russia", "Russian", interests);
        Profile vladimir = new Profile("Vladimir", 17, 6, 1997, "Novosibirsk", "Russia", "Russian", interests);
        Profile nikolai = new Profile("Nikolai", 17, 6, 1997, "Novosibirsk", "Russia", "Russian", interests);
        BST newBt = new BST();

        newBt.insertProfile(boris);
        newBt.insertProfile(vladimir);
        newBt.insertProfile(nikolai);

        newBt.printAlphabetical();
    }
}
