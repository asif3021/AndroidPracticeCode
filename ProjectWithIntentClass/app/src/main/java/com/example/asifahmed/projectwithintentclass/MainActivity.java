package com.example.asifahmed.projectwithintentclass;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button1, button2, button3, button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.country_1);
        button2 = findViewById(R.id.country_2);
        button3 = findViewById(R.id.country_3);
        button4 = findViewById(R.id.country_4);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,CountryFlugWithDescription.class);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Bitmap bmp;


        if (v.getId()==button1.getId()){
            intent.putExtra("about_country",getString(R.string.about_bangladesh));// send description string
            intent.putExtra("country_title",button1.getText().toString());
            // Get image from resource and convert it to byte
            bmp = BitmapFactory.decodeResource(getResources(), R.drawable.bangladesh);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            intent.putExtra("picture", byteArray);
        }

        else if (v.getId()==button2.getId()){
            intent.putExtra("about_country",getString(R.string.about_australia));// send description string
            intent.putExtra("country_title",button2.getText().toString());
            // Get image from resource and convert it to byte
            bmp = BitmapFactory.decodeResource(getResources(), R.drawable.australia);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            intent.putExtra("picture", byteArray);
        }

        else if (v.getId()==button3.getId()){
            intent.putExtra("about_country",getString(R.string.about_brazil));// send description string
            intent.putExtra("country_title",button3.getText().toString());
            // Get image from resource and convert it to byte
            bmp = BitmapFactory.decodeResource(getResources(), R.drawable.brazil);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            intent.putExtra("picture", byteArray);
        }

        else if (v.getId()==button4.getId()){
            intent.putExtra("about_country",getString(R.string.about_uk));// send description string
            intent.putExtra("country_title",button4.getText().toString());
            // Get image from resource and convert it to byte
            bmp = BitmapFactory.decodeResource(getResources(), R.drawable.united_kingdom);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();
            intent.putExtra("picture", byteArray);
        }

        startActivity(intent);
        finish();

    }
}
