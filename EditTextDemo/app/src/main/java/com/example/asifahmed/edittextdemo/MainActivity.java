package com.example.asifahmed.edittextdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1, editText2;
    private Button button1, button2, button3, button4, reset;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.et1);
        editText2 = findViewById(R.id.et2);


        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        button3 = findViewById(R.id.btn3);
        button4 = findViewById(R.id.btn4);
        reset = findViewById(R.id.btn5);


        textView = findViewById(R.id.tv1);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        reset.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        try{
            Double num1 = Double.parseDouble(editText1.getText().toString());
            Double num2 = Double.parseDouble(editText2.getText().toString());
            if (v.getId()==R.id.btn1){
                textView.setText("Addition result is "+(num1+num2) );
//                Toast.makeText(MainActivity.this,"Addition result is "+(num1+num2),Toast.LENGTH_LONG);
            }
            else if (v.getId()==R.id.btn2){
                textView.setText("Subtraction result is "+(num1-num2) );
            }
            else if (v.getId()==R.id.btn3){
                textView.setText("Multiplication result is "+(num1*num2) );
            }
            else if (v.getId()==R.id.btn4){
                textView.setText("Division result is "+(num1/num2) );
            }
            else if (v.getId()==R.id.btn5){
                editText1.setText("");
                editText2.setText("");
            }
        }catch (Exception e){
            Toast toast = makeText(MainActivity.this,"Please enter numbers",Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
