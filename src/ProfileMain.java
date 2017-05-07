/**
 * Created by geron on 07.05.2017.
 */
public class ProfileMain {

    public static void main(String[] args){

        String[] interests = {"Sit", "Eat", "Sleep", "Play Games", "Have a cool life"};
        Profile boris = new Profile("Boris", 17, 6, 1997, "Novosibirsk", "Russia", "Russian", interests);

        System.out.println("Name:" + boris.getName());
        System.out.println("Born on:" + boris.getDateOfBirth());
        System.out.println("Is " + boris.getNationality());
        System.out.print("Overall info: \n" + boris.toString());
    }
}
