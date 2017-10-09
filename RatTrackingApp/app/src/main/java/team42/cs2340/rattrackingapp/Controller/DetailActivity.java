package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import team42.cs2340.rattrackingapp.R;

/**
 * Created by Orestis Markozanes on 10/9/2017.
 */

public class DetailActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        TextView ratDetailView = (TextView) findViewById(R.id.ratDetail);
//        Intent intent = getIntent();
//        Bundle bd = intent.getExtras();

        TextView tv = ((TextView) findViewById(R.id.ratDetail));
        tv.setText("Rat Detail\n" + getIntent().getStringExtra("Detail"));
    }
}
