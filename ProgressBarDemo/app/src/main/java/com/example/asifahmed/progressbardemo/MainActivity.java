package com.example.asifahmed.progressbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textView;
    int progress, temp = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBarId);
        textView = findViewById(R.id.tvId);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                progressDone();
            }
        });
        thread.start();




    }

    public void doWork(){

        int progressTime = 1000, progressStep = 5;
        for (progress = 0; progress <= 100; progress += 20) {

/*            if (progress == 20){


                progressTime = 100;
                progressStep = 10;
//                progressDone();
            }*/

            try {
                Thread.sleep(progressTime);
                progressBar.setProgress(progress);
/*                if (progress == 100){
                    textView.setText("Progress done !");
                }*/
//                    Toast.makeText(MainActivity.this,"Progress Done",Toast.LENGTH_LONG).show();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }

/*
            if (progress == 100){
                Toast.makeText(MainActivity.this,"Progress Done",Toast.LENGTH_LONG).show();
            }
*/



        }



    }

    public void progressDone(){
        // UI thread / main thread
//        textView.setText(R.string.progress_done);
        Toast.makeText(this, "Progress done !", Toast.LENGTH_SHORT).show();
    }


}
