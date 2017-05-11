import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is a file reader to read files needed for Binary Search Tree and Graph
 * @author Slobodov Aleksandr
 * @version 1.0
 */
public class FileReader {

    /**
     * Max amount of interests allowed.
     */
    private static final int INT_COUNTER = 10;
    /**
     * Default day/year/month in case of wrong output
     */
    private static final int DEFAULT_DATE = 1;
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
            if (line.length() > 1) {
                Scanner lineSc = new Scanner(line);
                createConnection(lineSc, bt);
            }
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
            bt.find(nameOne).addFriend(bt.find(nameTwo));
            bt.find(nameTwo).addFriend(bt.find(nameOne));
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
            if (line.length() > 1) {
                Scanner lineSc = new Scanner(line);
                bt.insertProfile(createProfile(lineSc));
            }
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
        String tmp;
        line.useDelimiter(",");
        String[] interests;

        name = line.next();
        try {
            day = Integer.parseInt(line.next());
        } catch (NumberFormatException e) {
            System.out.println("One of the DoB inputs is not an integer. "
                    + "In this case as day is not a number it is automatically"
                    + " set to " + DEFAULT_DATE);
            day = DEFAULT_DATE;
        }
        try {
            month = Integer.parseInt(line.next());
        } catch (NumberFormatException e) {
            System.out.println("One of the DoB inputs is not an integer. "
                    + "In this case as month is not a number it is "
                    + "automatically set to " + DEFAULT_DATE);
            month = DEFAULT_DATE;
        }
            try {
                year = Integer.parseInt(line.next());
            } catch (NumberFormatException e) {
                System.out.println("One of the DoB inputs is not an integer. In"
                        + " this case as year is not a number it is "
                        + "automatically set to " + DEFAULT_DATE);
                year = DEFAULT_DATE;
            }
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
