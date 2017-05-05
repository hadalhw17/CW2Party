/**
 * Created by geron on 23.04.2017.
 */
public class GraphMain {

    public static void main(String[] args) {

        BST bt = FileReader.readProfiles("profiles.txt");
        Graph g = FileReader.readFriends("friends.txt", bt);
        g.addProfiles(bt.getRoot());
        //g.toString();

        //if(bt.find("name"))
        g.commonFriends(bt.find("Jane Doe").getProfile(),
                bt.find("Archibald Smith").getProfile()).printAlphabetical(
                        g.commonFriends(bt.find("Jane Doe").getProfile(),
                        bt.find("Archibald Smith").getProfile()).getRoot());
    }
}
