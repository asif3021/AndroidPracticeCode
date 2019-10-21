package com.example.asifahmed.toastdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button1, button2;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.btn_1);
        button2 = findViewById(R.id.btn_2);
        textView = findViewById(R.id.txtView_1);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        textView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_1){
            //textView.setText("Hey, I am toast message.");
            Toast.makeText(MainActivity.this,"Click Me button is clicked",Toast.LENGTH_LONG).show();
        }
        else if(v.getId()==R.id.btn_2){
            //textView.setText("");
            Toast toast = Toast.makeText(MainActivity.this,"Empty button is clicked",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,-500);
            toast.show();
        }
    }
}
