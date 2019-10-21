package com.asifahmed.dailyexpenseincome;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView expenseCardView, depositCardView, settingsCardView, statementCardViewId;
    private TextView currentBalance,  currentExpense ;


    DatabaseHelperClass databaseHelperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expenseCardView = findViewById(R.id.expenseCardViewId);
        depositCardView = findViewById(R.id.depositCardViewId);
        settingsCardView = findViewById(R.id.settingsCardViewId);
        statementCardViewId = findViewById(R.id.statementCardViewId);
        currentBalance = findViewById(R.id.currentBalanceId);
        currentExpense = findViewById(R.id.currentExpenseId);

        expenseCardView.setOnClickListener(this);
        depositCardView.setOnClickListener(this);
        settingsCardView.setOnClickListener(this);
        statementCardViewId.setOnClickListener(this);


        databaseHelperClass = new DatabaseHelperClass(this);



        Cursor cursor = databaseHelperClass.currentBalance();
            StringBuffer stringBuffer = new StringBuffer();
            while(cursor.moveToNext()){
                stringBuffer.append(cursor.getString(0));
            }
            int balance = Integer.parseInt(stringBuffer.toString());

        cursor = databaseHelperClass.currentExpense();
        StringBuffer currentExp = new StringBuffer();
        while(cursor.moveToNext()){
            currentExp.append(cursor.getString(0));
        }
        balance = balance - Integer.parseInt(currentExp.toString());
        currentBalance.setText(balance + " tk");
        currentExpense.setText(currentExp + " tk");





    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.expenseCardViewId){
            Intent intent = new Intent(MainActivity.this,Expense.class);
            startActivity(intent);
//            finish();

            //Toast.makeText(this, "Expense cardView is clicked.", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.depositCardViewId){
            Intent intent = new Intent(MainActivity.this,Income.class);
            startActivity(intent);
            finish();

            //Toast.makeText(this, "Deposit cardView is clicked.", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.settingsCardViewId){
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
        }
        else if (v.getId() == R.id.statementCardViewId){
//            Toast.makeText(this, "Statement cardView is clicked.", Toast.LENGTH_SHORT).show();


            Intent intent = new Intent(MainActivity.this,TransactionActivity.class);
            startActivity(intent);
            finish();
        }


    }

}
