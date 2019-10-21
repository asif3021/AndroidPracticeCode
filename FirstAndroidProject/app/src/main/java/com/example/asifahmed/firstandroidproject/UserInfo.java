package com.example.asifahmed.firstandroidproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserInfo extends AppCompatActivity implements View.OnClickListener {

    private TextView textView, textView1, textView2, textView3, textView4;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        textView = findViewById(R.id.userInfo_id);
        textView1 = findViewById(R.id.userInfo_id1);
        textView2 = findViewById(R.id.userInfo_id2);
        textView3 = findViewById(R.id.userInfo_id3);
        textView4 = findViewById(R.id.userInfo_id4);

        button = findViewById(R.id.userInfo_btn);

        textView.setText("Congratulation " + getIntent().getStringExtra("str1"));
        textView1.setText("Name : " + getIntent().getStringExtra("str1") + " " + getIntent().getStringExtra("str2"));
        if (getIntent().getStringExtra("str3").matches("")){
            textView2.setText("Employee id : " + getIntent().getStringExtra("str3"));
        }
        else {
            textView2.setText("Employee id : Expo" + getIntent().getStringExtra("str3"));
        }
        textView3.setText("Email : " + getIntent().getStringExtra("str4"));
        textView4.setText("Gender : " + getIntent().getStringExtra("str5"));

        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
//        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Double tap to exit", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }


}
