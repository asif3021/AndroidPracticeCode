package com.example.asifahmed.radiobuttondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton, maleButton, femaleButton;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroupID);
        button = findViewById(R.id.button_id);
        textView = findViewById(R.id.textView_id);

        maleButton = findViewById(R.id.radioItem1_id);
        femaleButton = findViewById(R.id.radioItem2_id);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedRadioGroupId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectedRadioGroupId);
                textView.setText("You have selected: "+radioButton.getText().toString());
            }
        });

        maleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,maleButton.getText().toString() + " is selected.",Toast.LENGTH_SHORT).show();
//                textView.setText(maleButton.getText().toString() + " is selected.");
            }
        });

        femaleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,femaleButton.getText().toString() + " is selected.",Toast.LENGTH_SHORT).show();
//                textView.setText(femaleButton.getText().toString() + " is selected.");
            }
        });


    }
}
