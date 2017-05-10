/**
 * Created by geron on 23.04.2017.
 */
public class GraphMain {

    public static void main(String[] args) {

        BST bt = FileReader.readProfiles("profiles.txt");
        Graph g = FileReader.readFriends("friends.txt", bt);

        g.commonFriends(bt.find("Freddie Mercury"),
                bt.find("Friendly Ghost Casper")).printAlphabetical();
    }
}
