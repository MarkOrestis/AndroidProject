package team42.cs2340.rattrackingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


/**
 * Created by King Jay on 9/24/2017.
 */

public class RatActivity extends Activity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rat);
    }

    public void onLogoutClick(View v) {
        if (v.getId() == R.id.bLogout) {
            Intent i = new Intent(RatActivity.this, MainActivity.class);
            startActivity(i);
        }
    }

}
