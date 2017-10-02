package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import team42.cs2340.rattrackingapp.Model.UserBase;
import team42.cs2340.rattrackingapp.Model.Users;
import team42.cs2340.rattrackingapp.R;

/**
 * Created by CS2340 Team 42 -- Answer to Life
 */

public class LoginActivity extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void onCancelClick(View v) {
        if (v.getId() == R.id.bCancel) {
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(i);
        }
    }

    public void onLoginClick2(View v) {
        if (v.getId() == R.id.bLogin2) {
            EditText username = (EditText) findViewById(R.id.usernameText);
            EditText password = (EditText) findViewById(R.id.passwordText);
            String usernameString = username.getText().toString();
            String passwordString = password.getText().toString();
            ArrayList<Users> dummy = new UserBase().getUsers();

            for (int i = 0; i < dummy.size(); i++) {
                if (usernameString.equals(dummy.get(i).getUsername())
                        && passwordString.equals(dummy.get(i).getPassword())) {
                    Intent j = new Intent(LoginActivity.this, RatActivity.class);
                    startActivity(j);
                }
            }
            AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);

            dlgAlert.setMessage("Wrong password or username, please try again.");
            dlgAlert.setTitle("Error Message ...");
            dlgAlert.setPositiveButton("OK", null);
            dlgAlert.setCancelable(true);
            dlgAlert.create().show();

            dlgAlert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

        }
    }
}
