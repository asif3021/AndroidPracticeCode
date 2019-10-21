package com.example.asifahmed.ratingbardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RatingBar ratingBar;
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBarId);
        textView = findViewById(R.id.textViewId);
        button = findViewById(R.id.sendUsBtnId);


        textView.setText("Rating value: " + (int)ratingBar.getProgress());

        button.setOnClickListener(this);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textView.setText("Rating value: " +  (int)rating);
            }
        });

/*        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int value = ratingBar.getProgress();
                Intent intent = new Intent(MainActivity.this,RatingView.class);
                intent.putExtra("str",value);
                startActivity(intent);
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        int value = ratingBar.getProgress();
        Toast.makeText(MainActivity.this,"Thanks for rating us",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,RatingView.class);
        intent.putExtra("value_key",value);
        startActivity(intent);
    }
}
