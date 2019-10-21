package com.example.asifahmed.projectwithintentclass;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryFlugWithDescription extends AppCompatActivity {

    private TextView textView, textView1;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_flug_with_description);

        imageView = findViewById(R.id.iv_id1);
        textView = findViewById(R.id.sv_tv_id1);
        textView1 = findViewById(R.id.country_name);




        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("picture");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        imageView.setImageBitmap(bmp);
        textView1.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        textView1.setText(getIntent().getStringExtra("country_title"));
        textView.setText(getIntent().getStringExtra("about_country"));

/*

        String string ;
        string = getIntent().getStringExtra("country_id");

        if (string.contentEquals("bangladesh")){
            imageView.setImageResource(R.drawable.bangladesh);
            textView.setText(getIntent().getStringExtra("about_country"));
        }
        else if (string.contentEquals("australia")){
            imageView.setImageResource(R.drawable.australia);
            textView.setText(getIntent().getStringExtra("about_country"));
        }
        else if (string.contentEquals("brazil")){
            imageView.setImageResource(R.drawable.brazil);
            textView.setText(getIntent().getStringExtra("about_country"));
        }
        else if (string.contentEquals("uk")){
            imageView.setImageResource(R.drawable.united_kingdom);
            textView.setText(getIntent().getStringExtra("about_country"));
        }
*/


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
