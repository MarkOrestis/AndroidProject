package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import team42.cs2340.rattrackingapp.R;

import static android.content.ContentValues.TAG;

/**
 * Created by Beatrice on 10/30/17.
 */

public class SearchDataActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchdata);

        Button searchByDateButton = (Button) findViewById(R.id.searchdatebtn);

        searchByDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Pressed");
                goToSearchDateScreen();
            }
        });
    }

    public void goToSearchDateScreen() {
        Intent intent = new Intent(this, SearchDateActivity.class);
        startActivity(intent);
    }
}