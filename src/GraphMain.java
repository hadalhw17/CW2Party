/**
 * Created by geron on 23.04.2017.
 */
public class GraphMain {

    public static void main(String[] args) {

        BST bt = FileReader.readProfiles("profiles.txt");
        Graph g = FileReader.readFriends("friends.txt", bt);

        System.out.println("Common friends of Freddie Mercury and Friendly" +
                " Ghost Casper are: ");
        g.commonFriends(bt.find("Freddie Mercury"),
                bt.find("Friendly Ghost Casper")).printAlphabetical();
        System.out.println("-------------------------------------------------");
        System.out.println("Common friends of Andy Warhol and Friendly" +
                " Ghost Casper are: ");
        g.commonFriends(bt.find("Andy Warhol"),
                bt.find("Friendly Ghost Casper")).printAlphabetical();
    }
}
