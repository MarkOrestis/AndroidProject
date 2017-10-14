package team42.cs2340.rattrackingapp.Model;

/**
 * An admin class that sets a user apart from if they are a simple user or an admin.
 */

public class Admin extends User {
    /**
     * 2-arg constructor that creates a Admin with an username and password
     *
     * @param newUsername Admin's username
     * @param newPassword Admin's password
     */
    public Admin(String newUsername, String newPassword) {
        super(newUsername, newPassword);
    }

    /**
     * toString method used to visualize the Admin's username and password
     * @return a String containing the Admin's username and password
     */
    @Override
    public String toString() { return "Admin: " + getUsername() + " | " + getPassword(); }
}
