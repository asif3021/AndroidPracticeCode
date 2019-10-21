package com.example.asifahmed.alertdialogdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;

    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_id);
         button.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        alertDialogBuilder = new AlertDialog.Builder(this);//this indicates current activity like MainActivity.this
//        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);//this indicates current activity like MainActivity.this

        alertDialogBuilder.setTitle(R.string.alert_title);

        alertDialogBuilder.setMessage(R.string.alert_message);

        alertDialogBuilder.setIcon(R.drawable.warning);

        alertDialogBuilder.setCancelable(false);

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

        alertDialogBuilder.setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"Negative button is clicked",Toast.LENGTH_LONG).show();
            }
        });

        //show alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
