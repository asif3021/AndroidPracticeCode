package com.example.asifahmed.sqlitedatabasedemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText text_Name,text_Age,text_Gender;
    private Button button, button1, dataDisplayActivity;
    private TextView textView;


    DatabaseHelperClass databaseHelperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text_Name = findViewById(R.id.name_id);
        text_Age = findViewById(R.id.age_id);
        text_Gender = findViewById(R.id.gender_id);
        textView = findViewById(R.id.textDisplay);

        button = findViewById(R.id.btn_save);
        button1 = findViewById(R.id.btn_allData);
        dataDisplayActivity = findViewById(R.id.display_activity);

        databaseHelperClass = new DatabaseHelperClass(this);

        SQLiteDatabase sqLiteDatabase = databaseHelperClass.getWritableDatabase();

        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        dataDisplayActivity.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String name = text_Name.getText().toString();
        String age = text_Age.getText().toString();
        String gender = text_Gender.getText().toString();

        if (v.getId() == button.getId() && !name.equals("") && !age.equals("") && !gender.equals("")){
            long rowId = databaseHelperClass.insertData(name, age, gender);

            if (rowId == -1){
                Toast.makeText(getApplicationContext(),"Data not inserted",Toast.LENGTH_LONG).show();
            }
             else {
                Toast.makeText(getApplicationContext(),"Data inserted successfully for id : "+rowId,Toast.LENGTH_LONG).show();
                text_Name.setText("");
                text_Age.setText("");
                text_Gender.setText("");
            }
        }

        else if (v.getId() == button1.getId()){
            Cursor cursor = databaseHelperClass.displayData();
            if (cursor.getCount() == 0){
                // Not data is in table
/*                showData("Error", "No data");
                return;*/
                Toast.makeText(getApplicationContext(),"No data",Toast.LENGTH_LONG).show();
            }
            else {
                StringBuffer stringBuffer = new StringBuffer();
                while(cursor.moveToNext()){
                    stringBuffer.append("ID : " + cursor.getString(0) + "\n");
                    stringBuffer.append("Name : " + cursor.getString(1) + "\n");
                    stringBuffer.append("Age : " + cursor.getString(2) + "\n");
                    stringBuffer.append("Gender : " + cursor.getString(3) + "\n\n");
                }
                showData("Student Details", stringBuffer.toString());
//                textView.setText(stringBuffer);
            }
        }

        else if (v.getId() == dataDisplayActivity.getId()){
            Intent intent = new Intent(MainActivity.this, StudentDetails.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(MainActivity.this,"Please enter data",Toast.LENGTH_SHORT).show();
        }
    }

    public void showData(String title, String data){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(data);
        builder.setCancelable(true);
        builder.show();
//        textView.setText("Title : " + title + "\n\n" + data);

    }

}
