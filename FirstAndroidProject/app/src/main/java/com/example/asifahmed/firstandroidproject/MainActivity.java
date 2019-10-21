package com.example.asifahmed.firstandroidproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private Button create_account, place_your_comment;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create_account = findViewById(R.id.create_an_account);
        place_your_comment = findViewById(R.id.make_complain);

        create_account.setOnClickListener(this);
        place_your_comment.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId()==create_account.getId()){
            Intent intent = new Intent(MainActivity.this,CreateAnAccount.class);
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(MainActivity.this,"Under construction",Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onBackPressed() {
        alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle(R.string.alert_title);

        alertDialogBuilder.setMessage(R.string.alert_message);

        alertDialogBuilder.setIcon(R.drawable.android);

        alertDialogBuilder.setCancelable(false); //cancel alert dialog by using touch

        //set positive button action
        alertDialogBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(MainActivity.this,"Negative button is clicked",Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
/*
        alertDialogBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast.makeText(MainActivity.this,"Negative button is clicked",Toast.LENGTH_LONG).show();
                dialog.cancel();
            }
        });
*/


        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();



    }
}
