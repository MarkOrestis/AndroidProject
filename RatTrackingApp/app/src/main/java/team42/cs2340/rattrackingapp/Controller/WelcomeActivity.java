package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import team42.cs2340.rattrackingapp.Model.DatabaseHelper;
import team42.cs2340.rattrackingapp.R;

/**
 * The first activity page that is launched when the user first opens the application.
 */

public class WelcomeActivity extends Activity {
    private DatabaseHelper dbHelper = DatabaseHelper.getInstance(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button loginButton = (Button) findViewById(R.id.loginbtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLoginScreen();
            }
        });
        Button mRegisterButton = (Button) findViewById(R.id.registerbtn);
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToRegisterScreen();
            }
        });
    }

    /**
     * A click listener method that brings the user from the Welcome Activity page to the Login
     * screen.
     */
    public void goToLoginScreen() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    /**
     * A click listener method that bring the user from the Welcome Activity page to the register
     * screen.
     */
    public void goToRegisterScreen() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
