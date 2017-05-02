/**
 * Created by geron on 23.04.2017.
 */
public class GraphMain {

    public static void main(String[] args){

        BST bt = FileReader.readProfiles("test.txt");
        Graph g = FileReader.readFriends("test_graph.txt", bt);
        g.addProfiles(bt.root);
        //g.toString();

        //if(bt.find("name"))
        g.commonFriends(bt.find("name").getProfile(), bt.find("zame").getProfile());
    }
}
