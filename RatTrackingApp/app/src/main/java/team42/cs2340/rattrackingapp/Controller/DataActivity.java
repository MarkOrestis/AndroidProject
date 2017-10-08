package team42.cs2340.rattrackingapp.Controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import team42.cs2340.rattrackingapp.R;

/**
 * Created by King Jay on 10/8/2017.
 */

public class DataActivity extends Activity{
    CSVAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        ListView mList = (ListView)findViewById(R.id.mList);

        mAdapter = new CSVAdapter(this, -1);

        mList.setAdapter(mAdapter);

        mList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos,long id) {
                Toast.makeText(v.getContext(), mAdapter.getItem(pos).getCreatedDate(), Toast.LENGTH_LONG).show();
                Toast.makeText(v.getContext(), mAdapter.getItem(pos).getUniqueKey(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
