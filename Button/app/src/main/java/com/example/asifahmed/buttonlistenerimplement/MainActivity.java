package com.example.asifahmed.buttonlistenerimplement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginButton, logoutButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.login_btn);
        logoutButton = findViewById(R.id.logout_btn);
        textView = findViewById(R.id.textString);

        loginButton.setOnClickListener(this);
        logoutButton.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.login_btn){
            textView.setText("Login button is clicked");
        }
        else if (v.getId()==R.id.logout_btn){
            textView.setText("Logout button is clicked");
        }
    }
}
