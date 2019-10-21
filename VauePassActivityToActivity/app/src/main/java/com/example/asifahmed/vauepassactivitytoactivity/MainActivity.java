package com.example.asifahmed.vauepassactivitytoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText1);
        button = findViewById(R.id.button1);

        button.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String string = editText.getText().toString();
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("str",string);
        startActivity(intent);
    }
}
