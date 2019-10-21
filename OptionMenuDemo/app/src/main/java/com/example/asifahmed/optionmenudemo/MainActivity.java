package com.example.asifahmed.optionmenudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_layout,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.settingsId){
            Toast.makeText(this, "Setting option is selected.", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.shareId){
            Toast.makeText(this, "Share option is selected.", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.feedbackId){
            Toast.makeText(this, "Feedback option is selected.", Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.aboutId){
            Toast.makeText(this, "About Us option is selected.", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }
}
