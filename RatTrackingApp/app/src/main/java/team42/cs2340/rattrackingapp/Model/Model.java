package team42.cs2340.rattrackingapp.Model;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Orestis Markozanes on 10/2/2017.
 */

public class Model {
    private static final Model instance = new Model();
    public static Model getInstance() { return instance; }

    private List<User> users;
    private List<RatSightingData> rats;
    Context csv;

    /**
     * No-arg constructor that creates an ArrayList of Users
     */
    private Model() {
        users = new ArrayList<>();
        addUser(new User("a", "a"));
        rats = new ArrayList<RatSightingData>();
    }

    /**
     * Getter for ArrayList of Users
     * @return ArrayList of Users
     */
    public List<User> getUsers() { return users; }

    public List<RatSightingData> getRats() {return rats; }

    /**
     * Method to add a User to the ArrayList
     * @param tempUser the User to be added to the ArrayList
     * @return whether or not the User was successfully added
     */
    public boolean addUser(User tempUser) {
        for (User c : users ) {
            if (c.getUsername().equals(tempUser.getUsername())) return false;
        }
        users.add(tempUser);
        return true;
    }

    /**
     * Method to add a User to the ArrayList
     * @param newRat the User to be added to the ArrayList
     * @return whether or not the Rat was successfully added
     */
    public boolean addRat(RatSightingData newRat) {
        for (RatSightingData r : rats) {
            if (r.getUniqueKey().equals(newRat.getUniqueKey())) return false;
        }
        rats.add(newRat);
        return true;
    }
}