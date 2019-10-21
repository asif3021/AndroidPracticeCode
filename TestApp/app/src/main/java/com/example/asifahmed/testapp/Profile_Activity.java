package com.example.asifahmed.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Profile_Activity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_);
        textView=findViewById(R.id.tv_id);

        Bundle bundle=getIntent().getExtras();
        String value=bundle.getString("s1");
        String value2=bundle.getString("s2");
        String value3=bundle.getString("s3");
        textView.setText(value+"\n"+value2+"\n"+value3);
    }
}
