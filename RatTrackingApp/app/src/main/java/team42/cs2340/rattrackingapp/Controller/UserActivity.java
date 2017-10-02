package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;

import java.util.ArrayList;

import team42.cs2340.rattrackingapp.Model.UserBase;
import team42.cs2340.rattrackingapp.Model.Users;
import team42.cs2340.rattrackingapp.R;

/**
 * Created by Orestis Markozanes on 9/27/2017.
 */

public class UserActivity extends Activity {
    private RadioButton radioUserButton;
    private ArrayList<Users> userBase = new UserBase().getUsers();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }
    public void onCancelUserClick(View v) {
        if (v.getId() == R.id.bCancelUser) {
            Intent i = new Intent(UserActivity.this, MainActivity.class);
            startActivity(i);
        }
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbUser:
                if (checked)
                    radioUserButton = findViewById(R.id.rbUser);
                    break;
            case R.id.rbAdmin:
                if (checked)
                    radioUserButton = findViewById(R.id.rbAdmin);
                    break;
        }
    }

    public void onConfirmClick(View v) {
        EditText username = (EditText)findViewById(R.id.usernameUser);
        EditText email = (EditText)findViewById(R.id.emailUser);
        EditText password = (EditText)findViewById(R.id.passwordUser);
        RadioGroup typeRadio = findViewById(R.id.rbAdmin);
        String userType = radioUserButton.toString();
        String usernameString = username.getText().toString();
        String emailString = email.getText().toString();
        String passwordString = password.getText().toString();
        userBase.add(new Users(usernameString, passwordString, emailString, userType));

    }
}
