package com.example.user.custom_listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CustomAdaper adaper;
    ListView listView;
    String[] phone_no={"01770966452","01553640461","01951279982","01747063955","01951279985"};
    String[] names={"ali hossain","abdul gaffar","shanto ali khan","touhidul islam",
    "naiem ali"};
    int[] img={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
    int[] img2={R.mipmap.phon_call,R.mipmap.phon_call,R.mipmap.phon_call,R.mipmap.phon_call,R.mipmap.phon_call};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=findViewById(R.id.list_id);

       adaper=new CustomAdaper(this,names,phone_no,img,img2);

        listView.setAdapter(adaper);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int pos=listView.getPositionForView(view);
                //Toast.makeText(MainActivity.this, (pos+1)+" is clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }


}
