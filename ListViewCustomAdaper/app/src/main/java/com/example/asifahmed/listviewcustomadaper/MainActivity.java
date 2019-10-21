package com.example.asifahmed.listviewcustomadaper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private String[] countryAllNames;
    private int[] flagId = {R.drawable.argentina, R.drawable.australia, R.drawable.bangladesh,
                            R.drawable.brazil, R.drawable.england, R.drawable.germany,
                            R.drawable.hawaii, R.drawable.jamaica, R.drawable.japan,
                            R.drawable.nepal, R.drawable.netherlands, R.drawable.new_zealand,
                            R.drawable.scotland, R.drawable.united_nations, R.drawable.united_states };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countryAllNames = getResources().getStringArray(R.array.country_names);

        listView = findViewById(R.id.listViewId);

        CustomAdapter customAdapter = new CustomAdapter(this,countryAllNames,flagId);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, countryAllNames[position] + " is selected.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
