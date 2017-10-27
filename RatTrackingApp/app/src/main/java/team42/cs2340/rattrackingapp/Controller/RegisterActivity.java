package team42.cs2340.rattrackingapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import team42.cs2340.rattrackingapp.R;

/**
 * Created by Orestis Markozanes on 10/26/2017.
 */

public class RegisterActivity extends AppCompatActivity{
    private Button bSignup;
    private Button bBack;
    private EditText emailField;
    private EditText passwordField;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();


        bBack = (Button) findViewById(R.id.backBtn);
        bSignup = (Button) findViewById(R.id.signupBtn);

        emailField = (EditText) findViewById(R.id.etName);
        passwordField = (EditText) findViewById(R.id.etPassword);

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
                startActivity(intent);
            }
        });

        bSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSignUp();
            }
        });
    }

    public void goToSignUp() {
        String email = emailField.getText().toString().trim();
        String password = passwordField.getText().toString().trim();

        HashMap<String, String> dataMap = new HashMap<>();
        dataMap.put("Email", email);
        dataMap.put("Password", password);

        mDatabase.push().setValue(dataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "User successfully registered", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
