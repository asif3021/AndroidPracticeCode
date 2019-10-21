package com.example.asifahmed.spinnerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private TextView textView, date;
    private Button button;
    String[] countryNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinnerId);
        textView = findViewById(R.id.textViewId);
        button = findViewById(R.id.btn_id);
        date = findViewById(R.id.dateTimeId);


        countryNames = getResources().getStringArray(R.array.country_names);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(MainActivity.this,R.layout.layout_design,R.id.countryNameId,countryNames);

        spinner.setAdapter(adapter);

//        Time today = new Time(Time.getCurrentTimezone());
//        Date currentTime = Calendar.getInstance().getTime();?
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);
        String ssss = day + "/" + month + "/" + year;

        int seconds = c.get(Calendar.SECOND);
        int minutes = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR);
        String time = hour + ":" + minutes + ":" + seconds;
        String formattedDate = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

        date.setText(formattedDate);
//        date.setText(ssss + " " + time);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String string = spinner.getSelectedItem().toString();
                Toast.makeText(MainActivity.this, "Country name " + string, Toast.LENGTH_SHORT).show();
                textView.setText("Country name " + string);
            }
        });

    }
}
