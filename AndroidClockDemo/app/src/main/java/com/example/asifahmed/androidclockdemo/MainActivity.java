package com.example.asifahmed.androidclockdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.DigitalClock;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DigitalClock digitalClock;
    private AnalogClock analogClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        digitalClock = findViewById(R.id.dc_id);
        analogClock = findViewById(R.id.ac_id);

        digitalClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Digital clock clicked",Toast.LENGTH_LONG).show();
            }
        });

        analogClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Analog clock clicked",Toast.LENGTH_LONG).show();
            }
        });

    }
}
