package com.example.asifahmed.firstandroidproject;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CreateAnAccount extends AppCompatActivity implements View.OnClickListener{

    private EditText editText1, editText2, editText3, editText4;
    private RadioButton radioButton;
    private CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_an_account);

        editText1 = findViewById(R.id.fname);
        editText2 = findViewById(R.id.lname);
        editText3 = findViewById(R.id.emp_id);
        editText4 = findViewById(R.id.emp_email);
        RadioGroup radioGroup = findViewById(R.id.radioGroupID);
        checkBox = findViewById(R.id.cb_id);
        Button button = findViewById(R.id.submit_btn);

        radioButton = findViewById(radioGroup.getCheckedRadioButtonId());


/*        Intent intent=new Intent(getApplicationContext(),DisplayInfo.class);
        startActivity(intent);*/

        button.setOnClickListener(this);

       /* button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!checkBox.isChecked()){
                    Toast.makeText(CreateAnAccount.this,"Please select agreement",Toast.LENGTH_LONG).show();
                }
                else {
                    String string1 = editText1.getText().toString();
                    String string2 = editText2.getText().toString();
                    String string3 = editText3.getText().toString();
                    String string4 = editText4.getText().toString();
                    String string5 = radioButton.getText().toString();
                    Intent intent = new Intent(CreateAnAccount.this,DisplayInfo.class);
                    intent.putExtra("str1",string1);
                    intent.putExtra("str2",string2);
                    intent.putExtra("str3",string3);
                    intent.putExtra("str4",string4);
                    intent.putExtra("str5",string5);
                    startActivity(intent);
                }
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        if (!checkBox.isChecked()){
            Toast.makeText(CreateAnAccount.this,"Please select agreement",Toast.LENGTH_LONG).show();
        }
        else {
            String string1 = editText1.getText().toString();
            String string2 = editText2.getText().toString();
            String string3 = editText3.getText().toString();
            String string4 = editText4.getText().toString();
            String string5 = radioButton.getText().toString();
            Intent intent = new Intent(CreateAnAccount.this,UserInfo.class);
            intent.putExtra("str1",string1);
            intent.putExtra("str2",string2);
            intent.putExtra("str3",string3);
            intent.putExtra("str4",string4);
            intent.putExtra("str5",string5);


        if( editText1.getText().toString().length() == 0 ){
            editText1.setError( "First name is required!" );
            }
            else {
            startActivity(intent);
            finish();
        }


        }
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
