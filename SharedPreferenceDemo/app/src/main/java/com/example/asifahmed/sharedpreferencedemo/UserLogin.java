package com.example.asifahmed.sharedpreferencedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.asifahmed.sharedpreferencedemo.RegistrationActivity.MyPREFERENCES;

public class UserLogin extends AppCompatActivity {

    SharedPreferences sharedpreferences;

    private EditText username, password;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);


        username = findViewById(R.id.userEmail);
        password = findViewById(R.id.userPassword);
        button = findViewById(R.id.login_btn);

/*
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String shared_username = sharedpreferences.getString("email","");
        String shared_password = sharedpreferences.getString("password","");*/
/*
        textView1.setText("Name: " + sharedpreferences.getString("nameKey", ""));
        textView2.setText("Phone: " + sharedpreferences.getString("phoneKey", ""));
        */

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

                String shared_username = sharedpreferences.getString("email","");
                String shared_password = sharedpreferences.getString("password","");


                if ((username.getText().toString()).equals(shared_username) && (password.getText().toString()).equals(shared_password)){
                    Intent intent = new Intent(UserLogin.this,Homepage.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(UserLogin.this,"Please enter correct email and password",Toast.LENGTH_LONG).show();
                }
            }
        });






    }
}
