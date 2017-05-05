import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by geron on 22.04.2017.
 */
public class FileReader {

    /**
     * Max amount of interests allowed.
     */
    private static final int INT_COUNTER = 10;
    /**
     * Scans file with profiles.
     * @param filename name of file
     * @return bst with profiles
     */
    public static BST readProfiles(final String filename) {

        File inFile = new File(filename);

        Scanner in = null;
        try {
            in = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            System.out.print("The file you are trying to open does not exist!"
                    + "\nThy opening another file.");
        }
        return FileReader.readData(in);
    }

    /**
     * Scans file with friendships.
     * @param filename name of file
     * @param bt bst with all profiles
     * @return constructed graph with friend connections created
     */
    public static Graph readFriends(final String filename, final BST bt) {
        File inFile = new File(filename);

        Scanner in = null;
        try {
            in = new Scanner(inFile);
        } catch (FileNotFoundException e) {
            System.out.print("The file you are trying to open does not exist!"
                    + "\nThy opening another file.");
        }
        return readData(filename, in, bt);
    }

    /**
     * Constructs a graph with friendships.
     * @param filename name of file
     * @param in scanner with file data
     * @param bt binary search tree with all profiles
     * @return graph with friends connections
     */
    private static Graph readData(final String filename, final Scanner in,
                                  final BST bt) {
        in.useDelimiter(",");
        String line = null;
        while (in.hasNextLine()) {
            line = in.nextLine();
            Scanner lineSc = new Scanner(line);
            createConnection(lineSc, bt);
        }
        Graph g = new Graph(filename, bt);
        return g;
    }

    /**
     * Creates connection between profiles.
     * @param in scanner with friendships
     * @param bt bst with all profiles
     */
    private static void createConnection(final Scanner in, final BST bt) {
        in.useDelimiter(",");
        String nameOne, nameTwo;
        nameOne = in.next();
        nameTwo = in.next();
        if (bt.find(nameOne) != null && bt.find(nameTwo) != null) {
            bt.find(nameOne).getProfile().addFriend(bt.find(nameTwo).
                    getProfile());
            bt.find(nameTwo).getProfile().addFriend(bt.find(nameOne).
                    getProfile());
        } else {
            System.out.println("cannot find a name");
        }
    }

    /**
     * Constructs bst with profiles.
     * @param in scanner with profile data
     * @return constructed bst
     */
    private static BST readData(final Scanner in) {
        BST bt = new BST();
        String line = null;
        while (in.hasNextLine()) {
            line = in.nextLine();
            Scanner lineSc = new Scanner(line);
            bt.insertProfile(createProfile(lineSc));
        }
        return bt;
    }

    /**
     * Take all data from file, splits it on variables and creates profile.
     * @param line scanner with one line from file
     * @return profile object
     */
    public static Profile createProfile(final Scanner line) {
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
        Profile p = new Profile(name, day, month, year, town, country,
                nationality, interests);
        return p;
    }

    /**
     * Creates an array of interests.
     * @param in scanner with interests for one profile only
     * @return array of interests
     */
    private static String[] groupInterests(final Scanner in) {
        String[] interests = new String[INT_COUNTER];
        in.useDelimiter(";|,");
        for (int i = 0; i < interests.length && in.hasNext(); i++) {
            interests[i] = in.next();
        }
        return interests;
    }

}
