package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
<<<<<<< HEAD
import android.widget.EditText;
import android.widget.RadioGroup;
=======
import android.widget.RadioButton;
>>>>>>> 5f52ae6049c2fa94db3282440df1c453cb27681c
import team42.cs2340.rattrackingapp.Model.Users;
import team42.cs2340.rattrackingapp.R;

/**
 * Created by Orestis Markozanes on 9/27/2017.
 */

public class UserActivity extends Activity {

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
<<<<<<< HEAD
















    

    public void onConfirmClick(View v) {
        EditText username = (EditText)findViewById(R.id.usernameUser);
        EditText email = (EditText)findViewById(R.id.emailUser);
        EditText password = (EditText)findViewById(R.id.passwordUser);

        RadioGroup typeRadio = findViewById(R.id.rbAdmin);
        String userType = typeRadio.toString();
        String usernameString = username.getText().toString();
        String emailString = email.getText().toString();
        String passwordString = password.getText().toString();
        Users  = new Users(passwordString, emailString, userType);
=======
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.rbUser:
                if (checked)
                    break;
            case R.id.rbAdmin:
                if (checked)
                    // Ninjas rule
                    break;
        }
>>>>>>> 5f52ae6049c2fa94db3282440df1c453cb27681c
    }
}
