package com.asifahmed.dailyexpenseincome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Income extends AppCompatActivity {
    private Spinner spinner;
    private EditText incomeAmount, incomeDesc;
    private Button deposit;
    String[] incomeHeads;

    DatabaseHelperClass databaseHelperClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);
        this.setTitle("Income");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Income head spinner add
        spinner = findViewById(R.id.incomeHeadSpinner);
        incomeHeads = getResources().getStringArray(R.array.income_head);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Income.this,R.layout.expense_head_spinner_design,R.id.countryNameId,incomeHeads);
        spinner.setAdapter(adapter);

        //find edit text and get data as input
        incomeAmount = findViewById(R.id.incomeAmount);
        incomeDesc = findViewById(R.id.incomeDesc);
        deposit = findViewById(R.id.incomeSubmit);


        databaseHelperClass = new DatabaseHelperClass(this);



        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inc_amount = incomeAmount.getText().toString();
                String inc_desc = incomeDesc.getText().toString();
                String transaction_type = "Deposit";
                String transaction_purpose = spinner.getSelectedItem().toString();
                String date_time = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

                if (v.getId()==R.id.incomeSubmit){
                    long rowId = databaseHelperClass.insertTransaction(inc_amount, inc_desc, transaction_type, transaction_purpose, date_time);

                    if (rowId == -1){
                        Toast.makeText(getApplicationContext(),"Data not inserted",Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Data inserted successfully",Toast.LENGTH_LONG).show();
/*                        text_Name.setText("");
                        text_Age.setText("");
                        text_Gender.setText("");*/
                    }
                }
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            Intent intent = new Intent(Income.this,MainActivity.class);
            startActivity(intent);
            finish();
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Income.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
