package com.example.asifahmed.logoutputdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn1);
        textView = findViewById(R.id.textViewLog);

        button.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn1){
            Log.d("msg","I am LogOutput in debug");

        }
    }
}
