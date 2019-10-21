package com.example.asifahmed.textviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewName, ageTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewName = findViewById(R.id.nameTextView);
        textViewName.setText("Ahmed Asif");

        ageTextView = findViewById(R.id.ageTextView);
        ageTextView.setText("25 years old.");
    }
}
