package com.asifahmed.customlistadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listAdapterDemoId);


        //Transaction title = new Transaction("Amount","Txn Type","Txn Purpose","Date","Time", "Desc");
        Transaction t1 = new Transaction("100","Deposit","Office","11-Dec-18","12:12:12","Transport cost on wednesday at day");
        Transaction t2 = new Transaction("100","Expense","Transport","11-Dec-18","12:12:12","SMM transport");
        Transaction t3 = new Transaction("100","Deposit","Personal","11-Dec-18","12:12:12","RAOWA transport cost on wednesday at day");
        Transaction t4 = new Transaction("50","Deposit","Office","11-Dec-18","12:12:12","RAOWA and SMM transport cost on wednesday at day");
        Transaction t5 = new Transaction("100","Expense","Food","11-Dec-18","12:12:12","SMM transport cost on wednesday at day");
        Transaction t6 = new Transaction("20","Expense","Transport","11-Dec-18","12:12:12","RAOWA transport");
        Transaction t7 = new Transaction("100","Expense","Transport","11-Dec-18","12:12:12","RAOWA and SMM transport cost on wednesday at day");
        Transaction t8 = new Transaction("300","Deposit","Personal","11-Dec-18","12:12:12","RAOWA transport cost on wednesday at day");
        Transaction t9 = new Transaction("100","Deposit","Office","11-Dec-18","12:12:12","RAOWA and SMM transport cost on wednesday at day");
        Transaction t10 = new Transaction("100","Expense","Food","11-Dec-18","12:12:12","RAOWA transport cost on wednesday at day");
        Transaction t11 = new Transaction("100","Deposit","Personal","11-Dec-18","12:12:12","RAOWA transport cost");
        Transaction t12 = new Transaction("50","Expense","Transport","11-Dec-18","12:12:12","RAOWA and SMM transport cost on wednesday at day");
        Transaction t13 = new Transaction("100","Deposit","Personal","11-Dec-18","12:12:12","RAOWA and SMM transport cost on wednesday at day");
        Transaction t14 = new Transaction("100","Deposit","Office","11-Dec-18","12:12:12","RAOWA day");
        Transaction t15 = new Transaction("100","Expense","Transport","11-Dec-18","12:12:12","RAOWA and SMM transport cost on wednesday at day");
        Transaction t16 = new Transaction("50","Expense","Food","11-Dec-18","12:12:12","SMM transport cost on wednesday at day");
        Transaction t17 = new Transaction("100","Expense","Transport","11-Dec-18","12:12:12","Transport cost on wednesday at day");
        Transaction t18 = new Transaction("50","Expense","Food","11-Dec-18","12:12:12","RAOWA and SMM transport cost on wednesday at day");
        Transaction t19 = new Transaction("100","Deposit","Office","11-Dec-18","12:12:12","Transport cost on wednesday at day");
        Transaction t20 = new Transaction("150","Deposit","Personal","11-Dec-18","12:12:12","Transport cost on wednesday at day");


        ArrayList<Transaction> transactionsList = new ArrayList<>();
        //transactionsList.add(title);
        transactionsList.add(t1);
        transactionsList.add(t2);
        transactionsList.add(t3);
        transactionsList.add(t4);
        transactionsList.add(t5);
        transactionsList.add(t6);
        transactionsList.add(t7);
        transactionsList.add(t8);
        transactionsList.add(t9);
        transactionsList.add(t10);
        transactionsList.add(t11);
        transactionsList.add(t12);
        transactionsList.add(t13);
        transactionsList.add(t14);
        transactionsList.add(t15);
        transactionsList.add(t16);
        transactionsList.add(t17);
        transactionsList.add(t18);
        transactionsList.add(t19);
        transactionsList.add(t20);


        TransactionListAdapter adapter = new TransactionListAdapter(this,R.layout.list_adapter_design,transactionsList);
        listView.setAdapter(adapter);





    }
}
