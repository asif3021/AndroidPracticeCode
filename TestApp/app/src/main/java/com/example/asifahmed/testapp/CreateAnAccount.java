package com.example.asifahmed.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAnAccount extends AppCompatActivity {
    EditText nameEditext,emailEditText,passEditext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_an_account);
        nameEditext=findViewById(R.id.name_id);
        emailEditText=findViewById(R.id.email_id);
        passEditext=findViewById(R.id.pass_id);
    }

    public void submit(View view) {
        String name=nameEditext.getText().toString();
        String email=emailEditText.getText().toString();
        String pass=passEditext.getText().toString();
        if (name.isEmpty()||email.isEmpty()||pass.isEmpty()){
            Toast.makeText(this, "enter name", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent=new Intent(getApplicationContext(),Profile_Activity.class);
            intent.putExtra("s1",name);
            intent.putExtra("s2",email);
            intent.putExtra("s3",pass);
            startActivity(intent);
        }
    }
}
