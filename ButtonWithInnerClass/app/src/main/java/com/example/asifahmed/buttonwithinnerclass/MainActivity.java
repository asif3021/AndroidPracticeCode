package com.example.asifahmed.buttonwithinnerclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button;
    private TextView textView;
    private int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_1);
        textView = findViewById(R.id.textView_1);

        button.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (count%2 == 0){
            textView.setText("I'm displayed !!!");
            button.setText("Hide text");
        }
        else{
            button.setText("Show text");
            textView.setText("");
        }
        count++;
    }
}
