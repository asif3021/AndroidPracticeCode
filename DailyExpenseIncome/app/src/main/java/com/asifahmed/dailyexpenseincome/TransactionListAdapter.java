package com.asifahmed.dailyexpenseincome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TransactionListAdapter extends ArrayAdapter<Transaction> {

    private Context context;
    private int resource;


    public TransactionListAdapter(Context context, int resource, ArrayList<Transaction> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }




    public View getView(int position, View convertView, ViewGroup parent) {

        String amount = getItem(position).getAmount();
        String txn_type = getItem(position).getTxn_type();
        String txn_purpose = getItem(position).getTxn_purpose();
        String date = getItem(position).getDate();
        String time = getItem(position).getTime();
        String desc = getItem(position).getDesc();

        Transaction transaction = new Transaction(amount,txn_type,txn_purpose,date,time,desc);
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource,parent,false);


        TextView textView1 = convertView.findViewById(R.id.listDesign_amount);
        TextView textView2 = convertView.findViewById(R.id.listDesign_txnType);
        TextView textView3 = convertView.findViewById(R.id.listDesign_txnPurpose);
        TextView textView4 = convertView.findViewById(R.id.listDesign_date);
        TextView textView5 = convertView.findViewById(R.id.listDesign_time);
        TextView textView6 = convertView.findViewById(R.id.listDesign_desc);

        textView1.setText(amount);
        textView2.setText(txn_type);
        textView3.setText(txn_purpose);
        textView4.setText(date);
        textView5.setText(time);
        textView6.setText(desc);

        return convertView;


    }




}
