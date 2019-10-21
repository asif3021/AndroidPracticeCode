package com.example.asifahmed.fragmentbackstack;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn);
        textView = findViewById(R.id.tvID);

        fragmentManager = getSupportFragmentManager();
        textView.setText("Fragment count in back stack " + fragmentManager.getBackStackEntryCount());

        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                textView.setText("Fragment count in back stack " + fragmentManager.getBackStackEntryCount());
            }
        });

//        Log.i(TAG,"Initial BackStackEntryCount: " + fragmentManager.getBackStackEntryCount());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment();
            }
        });


    }


    private void addFragment(){
        Fragment fragment;
        switch (fragmentManager.getBackStackEntryCount()){
            case 0: fragment = new SampleFragment(); break;
            case 1: fragment = new FragmentTwo(); break;
            case 2: fragment = new FragmentThree(); break;
            default: fragment = new SampleFragment(); break;
        }
        fragmentTransaction = fragmentManager.beginTransaction();
//        SampleFragment sampleFragment = new SampleFragment();
        fragmentTransaction.add(R.id.fragmentContainer,fragment,"Demo Fragment");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
