package com.example.asifahmed.datepickerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Button button;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tv_id);
        button = findViewById(R.id.btn_id);
        datePicker = findViewById(R.id.datePick_id);

        textView.setText("Current date: " + currentDate());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Current date: " + currentDate());
            }
        });

    }

    String currentDate(){
        StringBuilder sb = new StringBuilder();

        sb.append(datePicker.getDayOfMonth()+"/");
        sb.append((datePicker.getMonth()+1)+"/");//month return from 0; so 1 should add with month
        sb.append(datePicker.getYear());

        return sb.toString();
    }
}
