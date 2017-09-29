package team42.cs2340.rattrackingapp.Model;

import java.util.ArrayList;

/**
 * Created by King L0sr on 9/29/2017.
 */
public class Users {
    private String email;
    private String password;
    private String userType;

    public Users(String password, String email, String userType) {
        this.password = password;
        this.email = email;
        this.userType = userType;
    }
}

