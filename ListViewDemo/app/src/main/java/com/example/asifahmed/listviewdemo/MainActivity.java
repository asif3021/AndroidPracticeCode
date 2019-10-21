package com.example.asifahmed.listviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewId);

        String[] countryNames = getResources().getStringArray(R.array.country_name);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(CURRENT ACTIVITY,DESIGN OF LISTVIEW,STRING ARRAY LIST OF xml);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.sample_view,R.id.textViewId,countryNames);

        listView.setAdapter(adapter);

    }
}
