package com.asifahmed.dailyexpenseincome;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TransactionActivity extends AppCompatActivity {


    private ListView listView;


    DatabaseHelperClass databaseHelperClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        listView = findViewById(R.id.listAdapterDemoId);

        databaseHelperClass = new DatabaseHelperClass(this);

        Cursor cursor = databaseHelperClass.displayTransaction();


        ArrayList<Transaction> transactionsList = new ArrayList<>();
        while (cursor.moveToNext()){
            String amount = cursor.getString(0);
            String txnType = cursor.getString(2);
            String txnPurpose = cursor.getString(3);
            String[] dateTime = cursor.getString(4).split(" ");
            String date = dateTime[0];
            String time =  dateTime[1];
            String desc = cursor.getString(1);
//            Log.d("customLog", "amount: "+amount);


            System.out.println("Amount : " + amount);
            transactionsList.add(new Transaction(amount,txnType,txnPurpose,date,time,desc));
        }


        TransactionListAdapter adapter = new TransactionListAdapter(this,R.layout.list_adapter_design,transactionsList);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            Intent intent = new Intent(TransactionActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(TransactionActivity.this,MainActivity.class);
        startActivity(intent);
        finish();
    }




}
