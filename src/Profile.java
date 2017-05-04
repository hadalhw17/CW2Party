import java.util.ArrayList;

/**
 * Created by geron on 22.04.2017.
 */
public class Profile {

    private String name;
    private int day;
    private int month;
    private int year;
    private String town;
    private String country;
    private String nationality;
    private String[] interests;

    public ArrayList<Profile> friends = new ArrayList<Profile>();

    public Profile(String name, int day, int month, int year, String town, String country, String nationality, String[] interests) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.town = town;
        this.country = country;
        this.nationality = nationality;
        this.interests = interests;

    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String[] getInterests() {
        return interests;
    }

    public void setInterests(String[] interests) {
        this.interests = interests;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return day + "/" + month + "/" + year;
    }

    public void addFriend(Profile p) {
        friends.add(p);
    }

    public Profile getFriend(int i) {
        return friends.get(i);
    }

    public int getNumOfFriends() {
        return friends.size();
    }

    public String toString() {
        String msg;
        msg = "Name: " + name;
        msg += "\nAge" + getDateOfBirth();
        msg += "\nFrom: " + town + "," + country;
        msg += "\nLikes: ";
        for (String interest : interests) {
            msg += interest + "\n";
        }
        return msg;
    }
}
