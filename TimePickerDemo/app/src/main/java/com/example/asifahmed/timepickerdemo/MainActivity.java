package com.example.asifahmed.timepickerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    private TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timePicker = findViewById(R.id.timePicker_Id);
        timePicker.setIs24HourView(true);
        button = findViewById(R.id.btn_Id);
        textView = findViewById(R.id.tv_Id);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = timePicker.getCurrentHour()+":"+timePicker.getCurrentMinute();
                textView.setText(time);
            }
        });


    }
}
