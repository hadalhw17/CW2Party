import javax.xml.soap.Node;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by geron on 22.04.2017.
 */
public class Graph {

    String filename;
    BST bt;

    public Graph(String fileName, BST bt){
        this.filename = fileName;
        this.bt = bt;
    }

    List<Profile> edges  = new ArrayList<Profile>();


    public void addProfiles(BSTNode focusNode){
        if (focusNode.getLeft() != null) {
            edges.add(focusNode.getProfile());
            addProfiles(focusNode.getLeft());
        }else if(focusNode.getRight() != null){
            edges.add(focusNode.getProfile());
            addProfiles(focusNode.getRight());
        }
    }

    public  String toString(){
        String msg = "";
        for(Profile prof: edges){
            if(edges.size() == 0) {
                //return null;
            }
                msg += prof.getName() + " ";
                msg += prof.getNumOfFriends() + " amount of friends ";
                //System.out.println(prof.getName());

            }
            //msg+=" "+ edges.size();
        System.out.print(msg);
        return msg;
    }

    public BST commonFriends(Profile a, Profile b){
        BST friend = new BST();
       // bt.find(a.getName());

        for(int i = 0;i<a.getNumOfFriends();i++){
            for(int n = 0; n<b.getNumOfFriends(); n++){
                if(bt.find(a.getName()).getProfile().getFriend(i).getName().equals(bt.find(b.getName()).getProfile().getFriend(n).getName())){
                    friend.insertProfile(bt.find(b.getName()).getProfile().getFriend(n));
                    System.out.println(bt.find(b.getName()).getProfile().getFriend(n).getName());
                }
            }
            if(bt.find(a.getName()).getProfile().getFriend(i).getName().equals(bt.find(b.getName()).getProfile().getName())){
                friend.insertProfile(a);
                friend.insertProfile(b);
                System.out.println(a.getName());
                System.out.println(b.getName());
            }
        }
         return friend;
    }


}
