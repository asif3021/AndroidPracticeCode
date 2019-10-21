package com.example.asifahmed.checkboxdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private Button button, button2;
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    private TextView textView;
    CheckedItemList checkedItemList = new CheckedItemList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_id1);
        button2 = findViewById(R.id.btn_id2);

        checkBox1 = findViewById(R.id.cb_id1);
        checkBox2 = findViewById(R.id.cb_id2);
        checkBox3 = findViewById(R.id.cb_id3);
        checkBox4 = findViewById(R.id.cb_id4);

        textView = findViewById(R.id.tv_orderList);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox1.setChecked(false);
                checkBox2.setChecked(false);
                checkBox3.setChecked(false);
                checkBox4.setChecked(false);
                checkedItemList.removeAllItem();
                textView.setText("Please select an item.");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder items = new StringBuilder();

                if (checkBox1.isChecked()) {
                    if (items.length()>0){
                        items.append(", ");
                    }
                    items.append(checkBox1.getText().toString());
                }
                if (checkBox2.isChecked()) {
                    if (items.length()>0){
                        items.append(", ");
                    }
                    items.append(checkBox2.getText().toString());
                }
                if (checkBox3.isChecked()) {
                    if (items.length()>0){
                        items.append(", ");
                    }
                    items.append(checkBox3.getText().toString());
                }
                if (checkBox4.isChecked()) {
                    if (items.length()>0){
                        items.append(", ");
                    }
                    items.append(checkBox4.getText().toString());
                }

                if (items.length()==0){
                    textView.setText("Please select an item.");
                }
                else{
                    textView.setText(items + " is purchased.");
                }


            }
        });

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    checkedItemList.addItem(checkBox1.getText().toString());
                    Toast.makeText(MainActivity.this,checkBox1.getText().toString() + " is checked",Toast.LENGTH_SHORT).show();
                    textView.setText(checkedItemList.displayItems() + " is checked.");
                }
                else{
                    checkedItemList.removeItem(checkBox1.getText().toString());
                    Toast.makeText(MainActivity.this,checkBox1.getText().toString() + " is unchecked.",Toast.LENGTH_SHORT).show();
                    if (checkedItemList.emptyItemList()){
                        textView.setText("Please select an item");
                    }
                    else{
                        textView.setText(checkedItemList.displayItems() + " is checked.");
                    }
                }

            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked()) {
                    checkedItemList.addItem(checkBox2.getText().toString());
                    Toast.makeText(MainActivity.this,checkBox2.getText().toString() + " is checked",Toast.LENGTH_SHORT).show();
                    textView.setText(checkedItemList.displayItems() + " is checked.");
                }
                else{
                    checkedItemList.removeItem(checkBox2.getText().toString());
                    Toast.makeText(MainActivity.this,checkBox2.getText().toString() + " is unchecked.",Toast.LENGTH_SHORT).show();
                    if (checkedItemList.emptyItemList()){
                        textView.setText("Please select an item");
                    }
                    else{
                        textView.setText(checkedItemList.displayItems() + " is checked.");
                    }
                }

            }
        });

        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked()) {
                    checkedItemList.addItem(checkBox3.getText().toString());
                    Toast.makeText(MainActivity.this,checkBox3.getText().toString() + " is checked",Toast.LENGTH_SHORT).show();
                    textView.setText(checkedItemList.displayItems() + " is checked.");
//                    textView.setText(checkBox3.getText().toString()  + " is purchased.");
                }
                else{
                    checkedItemList.removeItem(checkBox3.getText().toString());
                    Toast.makeText(MainActivity.this,checkBox3.getText().toString() + " is unchecked.",Toast.LENGTH_SHORT).show();
                    if (checkedItemList.emptyItemList()){
                        textView.setText("Please select an item");
                    }
                    else{
                        textView.setText(checkedItemList.displayItems() + " is checked.");
                    }
                }
            }
        });

        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked()) {
                    checkedItemList.addItem(checkBox4.getText().toString());
                    Toast.makeText(MainActivity.this,checkBox4.getText().toString() + " is checked",Toast.LENGTH_SHORT).show();
                    textView.setText(checkedItemList.displayItems() + " is checked.");
//                    itemlist.append(" " + checkBox4.getText().toString());
//                    textView.setText(checkBox4.getText().toString()  + " is purchased.");
                }
                else{
                    checkedItemList.removeItem(checkBox4.getText().toString());
                    Toast.makeText(MainActivity.this,checkBox4.getText().toString() + " is unchecked.",Toast.LENGTH_SHORT).show();
                    if (checkedItemList.emptyItemList()){
                        textView.setText("Please select an item");
                    }
                    else{
                        textView.setText(checkedItemList.displayItems() + " is checked.");
                    }
                }
            }
        });
    }
}
