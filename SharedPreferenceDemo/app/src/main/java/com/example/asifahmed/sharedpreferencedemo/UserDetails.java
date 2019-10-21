package com.example.asifahmed.sharedpreferencedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class UserDetails extends AppCompatActivity {
    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedpreferences;

    private TextView textView1, textView2, textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        textView1 = findViewById(R.id.user_details_tv1);
        textView2 = findViewById(R.id.user_details_tv2);
        textView3 = findViewById(R.id.user_details_tv3);

        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        textView1.setText("Name: " + sharedpreferences.getString("nameKey", ""));
        textView2.setText("Phone: " + sharedpreferences.getString("phoneKey", ""));
        textView3.setText("Email: " + sharedpreferences.getString("emailKey", ""));




    }
}
