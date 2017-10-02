package team42.cs2340.rattrackingapp.Model;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by King Jay on 10/1/2017.
 */

public class UserBase extends Application{
    private ArrayList<Users> users;
    public UserBase() {

    }
    public ArrayList<Users> getUsers() {
        return users;
    }
}
