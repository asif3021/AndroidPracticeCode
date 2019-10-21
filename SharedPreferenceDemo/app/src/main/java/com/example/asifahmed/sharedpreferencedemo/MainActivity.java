package com.example.asifahmed.sharedpreferencedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private Button reg_btn, viewInfo_btn, button_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reg_btn = findViewById(R.id.reg_btn_id);
        viewInfo_btn = findViewById(R.id.viewInfo_btn_id);
        button_login = findViewById(R.id.loginPage);

        reg_btn.setOnClickListener(this);
        viewInfo_btn.setOnClickListener(this);
        button_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==reg_btn.getId()){
            Intent intent = new Intent(MainActivity.this,RegistrationActivity.class);
            startActivity(intent);
        }
        else if (v.getId()==viewInfo_btn.getId()){
            Intent intent = new Intent(MainActivity.this,UserDetails.class);
            startActivity(intent);
        }
        else if (v.getId() == button_login.getId()){
            Intent intent = new Intent(MainActivity.this,UserLogin.class);
            startActivity(intent);
        }

    }
}
