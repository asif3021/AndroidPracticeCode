package com.example.asifahmed.ratingbardemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class RatingView extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rating_display);

        textView = findViewById(R.id.viewRatingId);
        button = findViewById(R.id.backId);


        int valueOfRating = getIntent().getIntExtra("value_key",0);
        textView.setText("Rating value: " + valueOfRating);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);// New activity
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
