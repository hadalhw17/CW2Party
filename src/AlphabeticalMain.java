/**
 * Created by geron on 22.04.2017.
 */
public class AlphabeticalMain {

    public static void main(String[] args){

        BST bt = FileReader.readProfiles("test.txt");
        bt.printAlphabetical(bt.root);
    }
}
