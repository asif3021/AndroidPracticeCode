package com.example.asifahmed.zoomcontroldemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ZoomControls zoomControls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.iv_id);
        zoomControls = findViewById(R.id.zc_id);

        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = imageView.getScaleX();
                float y = imageView.getScaleY();

                if (x<=5 &&y<=5) {
                    imageView.setScaleX((float) (x+0.5));
                    imageView.setScaleY((float) (y+0.5));
                }
                else {
                    Toast.makeText(MainActivity.this,"Out of zoom in.",Toast.LENGTH_LONG).show();
                }
            }
        });
        zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = imageView.getScaleX();
                float y = imageView.getScaleY();

                if (x>1 &&y>1) {
                    imageView.setScaleX((float) (x-0.5));
                    imageView.setScaleY((float) (y-0.5));
                }
                else {
                    Toast.makeText(MainActivity.this,"Out of zoom out.",Toast.LENGTH_LONG).show();
                }
            }
        });




    }
}
