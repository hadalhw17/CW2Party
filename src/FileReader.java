import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by geron on 22.04.2017.
 */
public class FileReader {

    public static BST readProfiles(String filename) {

        File inFile = new File(filename);

        Scanner in = null;
        try {
            in = new Scanner(inFile);
        } catch (FileNotFoundException e) {

            System.out.print("The file you are trying to open does not exist!\nThy opening another file.");
        }
        return FileReader.readData(in);
    }

    public static Graph readFriends(String filename, BST bt) {
        File inFile = new File(filename);

        Scanner in = null;
        try {
            in = new Scanner(inFile);
        } catch (FileNotFoundException e) {

            System.out.print("The file you are trying to open does not exist!\nThy opening another file.");
        }
        return readData(filename, in, bt);
    }

    private static Graph readData(String filename, Scanner in, BST bt) {

        String line = null;
        while (in.hasNextLine()) {
            line = in.nextLine();
            Scanner lineSc = new Scanner(line);
            createConnection(lineSc, bt);
        }
        Graph g = new Graph(filename, bt);
        return g;
    }

    private static void createConnection(Scanner in, BST bt) {
        String nameOne, nameTwo;
        nameOne = in.next();
        nameTwo = in.next();
        if (bt.find(nameOne) != null && bt.find(nameTwo) != null) {
            bt.find(nameOne).getProfile().addFriend(bt.find(nameTwo).getProfile());
            bt.find(nameTwo).getProfile().addFriend(bt.find(nameOne).getProfile());
        } else System.out.println("cannot find a name");

    }

    private static BST readData(Scanner in) {
        BST bt = new BST();
        String line = null;
        while (in.hasNextLine()) {
            line = in.nextLine();
            Scanner lineSc = new Scanner(line);
            bt.insertProfile(createProfile(lineSc));
        }
        return bt;
    }

    public static Profile createProfile(Scanner line) {
        String name, town, country, nationality;
        int day, month, year; // Variables representing date(dd/mm/yyyy)
        line.useDelimiter(",");
        String[] interests;

        name = line.next();
        day = Integer.parseInt(line.next());
        month = Integer.parseInt(line.next());
        year = Integer.parseInt(line.next());
        town = line.next();
        country = line.next();
        nationality = line.next();
        interests = groupInterests(line);
        Profile p = new Profile(name, day, month, year, town, country, nationality, interests);
        return p;
    }

    private static String[] groupInterests(Scanner in) {
        int intCounter = 3;
        String[] interests = new String[3];
        in.useDelimiter(",;");
        interests = new String[intCounter];
        in.useDelimiter(";|,");
        for (int i = 0; i < interests.length; i++) {
            interests[i] = in.next();
        }
        return interests;
    }

}
