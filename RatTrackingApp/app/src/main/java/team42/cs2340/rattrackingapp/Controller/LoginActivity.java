package team42.cs2340.rattrackingapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import team42.cs2340.rattrackingapp.R;

/**
 * Created by Orestis Markozanes on 10/25/2017.
 */

public class LoginActivity extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private Button bLogin;
    private EditText emailField;
    private EditText passwordField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        emailField = (EditText) findViewById(R.id.email);
        passwordField = (EditText) findViewById(R.id.password);
        bLogin = (Button) findViewById(R.id.loginBtn);
        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToLaunchScreen();
            }
        });
    }

    public void goToLaunchScreen() {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }
}
