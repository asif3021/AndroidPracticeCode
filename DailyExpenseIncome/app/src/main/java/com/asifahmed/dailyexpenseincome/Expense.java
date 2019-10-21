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

public class Expense extends AppCompatActivity {
    private Spinner spinner;
    String[] expenseHeads;
    private Button button;
    private EditText expenseAmount, expenseDescription;



    DatabaseHelperClass databaseHelperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);
        this.setTitle("Expense");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        //Expense head spinner add
        spinner = findViewById(R.id.expenseHeadSpinner);
        expenseHeads = getResources().getStringArray(R.array.expense_head);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Expense.this,R.layout.expense_head_spinner_design,R.id.countryNameId,expenseHeads);
        spinner.setAdapter(adapter);

        button = findViewById(R.id.expenseSubmit);
        expenseAmount = findViewById(R.id.expenseAmount);
        expenseDescription = findViewById(R.id.expenseDesc);


        databaseHelperClass = new DatabaseHelperClass(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    String exp_amount = expenseAmount.getText().toString();
                    String exp_desc = expenseDescription.getText().toString();
                    String transaction_type = "Expense";
                    String transaction_purpose = spinner.getSelectedItem().toString();
                    String date_time = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

                    if (v.getId()==R.id.expenseSubmit){
                        long rowId = databaseHelperClass.insertTransaction(exp_amount, exp_desc, transaction_type, transaction_purpose, date_time);

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



/*    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            Intent intent = new Intent(Expense.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }*/

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Expense.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
