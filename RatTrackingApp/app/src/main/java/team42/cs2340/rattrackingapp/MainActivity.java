package team42.cs2340.rattrackingapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onLoginClick(View v) {
        if (v.getId() == R.id.bLogin) {
            Intent i = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(i);
        }
    }

    public void onRegisterClick(View v) {
        if (v.getId() == R.id.bRegister) {
            Intent i = new Intent(MainActivity.this, UserActivity.class);
            startActivity(i);
        }
    }
}
