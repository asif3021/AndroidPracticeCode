package com.example.asifahmed.switchdemo;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Switch aSwitch;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aSwitch = findViewById(R.id.switchId);
        imageView = findViewById(R.id.iv_id1);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    imageView.setImageResource(R.drawable.wifi_on);
                    Toast.makeText(MainActivity.this,"Wifi On",Toast.LENGTH_SHORT).show();
                }
                else{
                    imageView.setImageResource(R.drawable.wifi_off);
                    Toast.makeText(MainActivity.this,"Wifi Off",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
