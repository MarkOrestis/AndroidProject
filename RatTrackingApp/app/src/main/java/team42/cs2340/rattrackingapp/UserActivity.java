package team42.cs2340.rattrackingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
}
