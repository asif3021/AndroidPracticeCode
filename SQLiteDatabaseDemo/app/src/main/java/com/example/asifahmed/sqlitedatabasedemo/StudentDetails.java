package com.example.asifahmed.sqlitedatabasedemo;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class StudentDetails extends AppCompatActivity {

    private TextView textView;
    DatabaseHelperClass databaseHelperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        textView = findViewById(R.id.details_display);


        databaseHelperClass = new DatabaseHelperClass(this);

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


    public void showData(String title, String data){
/*        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title);
        builder.setMessage(data);
        builder.setCancelable(true);
        builder.show();*/
        textView.setText(data);
//        textView.setText("Title : " + title + "\n\n" + data);

    }


}
