/**
 * Created by geron on 22.04.2017.
 * Testing class for printAlphabetical method.
 */
public class AlphabeticalMain {

    public static void main(String[] args){

        BST bt = FileReader.readProfiles("profiles.txt");
        System.out.println("Printing names in alphabetical order...");
        bt.printAlphabetical();
    }
}
