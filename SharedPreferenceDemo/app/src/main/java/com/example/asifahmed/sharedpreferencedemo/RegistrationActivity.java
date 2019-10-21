package com.example.asifahmed.sharedpreferencedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String Phone = "phoneKey";
    public static final String Email = "emailKey";

    SharedPreferences sharedpreferences;

    private EditText firstName, lastName, email, address, mobile, dob, religion, nid, password;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        email = findViewById(R.id.email);
        address = findViewById(R.id.address);
        mobile = findViewById(R.id.mobile);
        dob = findViewById(R.id.dob);
        religion = findViewById(R.id.religion);
        nid = findViewById(R.id.nid);
        password = findViewById(R.id.password);

        button = findViewById(R.id.save_btn);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname  = firstName.getText().toString();
                String lname  = lastName.getText().toString();
                String uEmail  = email.getText().toString();
                String uAddress  = address.getText().toString();
                String uMobile  = mobile.getText().toString();
                String uDob  = dob.getText().toString();
                String uReligion  = religion.getText().toString();
                String uNid  = nid.getText().toString();
                String uPassword  = password.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();

                editor.putString("fname", fname);
                editor.putString("lname", lname);
                editor.putString("email", uEmail);
                editor.putString("address", uAddress);
                editor.putString("mobile", uMobile);
                editor.putString("dob", uDob);
                editor.putString("religion", uReligion);
                editor.putString("nid", uNid);
                editor.putString("password", uPassword);
                editor.commit();
                Toast.makeText(RegistrationActivity.this,"Thanks for registration",Toast.LENGTH_LONG).show();
            }
        });




    }
}
