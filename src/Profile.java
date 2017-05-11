import java.util.ArrayList;

/**
 * This class represents profile
 * @author Slobodov Aleksandr
 * @version 1.0
 */
public class Profile {

    /**
     * Name of user.
     */
    private String name;

    /**
     * A day when user was born.
     */
    private int day;

    /**
     * Month when user was born.
     */
    private int month;

    /**
     * Year when user was born.
     */
    private int year;

    /**
     * Town where user was born.
     */
    private String town;

    /**
     * Country when user was born.
     */
    private String country;

    /**
     * Nationality of user.
     */
    private String nationality;

    /**
     * Interests of user.
     */
    private String[] interests;

    /**
     * Friends of user.
     */
    private ArrayList<Profile> friends = new ArrayList<Profile>();

    /**
     * Constructor.
     * @param name Name of a user
     * @param day Day of birthday
     * @param month Month of birthday
     * @param year Year of birth
     * @param town Town of birth
     * @param country Country of birth
     * @param nationality Nationality of user
     * @param interests Interests of user
     */
    public Profile(final String name, final int day, final int month,
                   final int year, final String town, final String country,
                   final String nationality, final String[] interests) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.town = town;
        this.country = country;
        this.nationality = nationality;
        this.interests = interests;

    }

    /**
     * Getter for town.
     * @return town of birth
     */
    public String getTown() {
        return town;
    }

    /**
     * Setter for town.
     * @param town of birth
     */
    public void setTown(final String town) {
        this.town = town;
    }

    /**
     * Getter for country.
     * @return country of birth
     */
    public String getCountry() {
        return country;
    }

    /**
     * Setter for country.
     * @param country of birth
     */
    public void setCountry(final String country) {
        this.country = country;
    }

    /**
     * Getter for nationality.
     * @return nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Setter for nationality.
     * @param nationality of user
     */
    public void setNationality(final String nationality) {
        this.nationality = nationality;
    }

    /**
     * Getter for interests.
     * @return interests
     */
    public String[] getInterests() {
        return interests;
    }

    /**
     * Setter for interests.
     * @param interests of user
     */
    public void setInterests(final String[] interests) {
        this.interests = interests;
    }

    /**
     * Getter for name.
     * @return name of user
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for DoB.
     * @return date of birth in dd/mm/yyyy format
     */
    public String getDateOfBirth() {
        return day + "/" + month + "/" + year;
    }

    /**
     * Adds friend to array list.
     * @param p friend
     */
    public void addFriend(final Profile p) {
        friends.add(p);
    }

    /**
     * Getter for a friend on position i.
     * @param i number of a friend in array list
     * @return friend on position i
     */
    public Profile getFriend(final int i) {
        return friends.get(i);
    }

    /**
     * Returns number of friends.
     * @return number of friends
     */
    public int getNumOfFriends() {
        return friends.size();
    }

    /**
     * Prints profile in nice format.
     * @return message with formatted info about profile
     */
    public String toString() {
        String msg;
        msg = "Name: " + name;
        msg += "\nAge" + getDateOfBirth();
        msg += "\nFrom: " + town + "," + country;
        msg += "\nLikes: \n";
        for (String interest : interests) {
            msg += interest + "\n";
        }
        msg += "Has " + getNumOfFriends() + " friends.";
        return msg;
    }
}
