package com.example.user.custom_listview;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdaper extends BaseAdapter {
    Context context;
    String[] names;
    String[] phon_no;
    int[] img;
    int[] img2;


    LayoutInflater inflater;

    public CustomAdaper(Context context, String[] names, String[] phon_no, int[] img, int[] img2) {
        this.context = context;
        this.names = names;
        this.phon_no = phon_no;
        this.img = img;
        this.img2 = img2;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        inflater=(LayoutInflater.from(context));
         view=inflater.inflate(R.layout.custom_layout,null);
         TextView textView=view.findViewById(R.id.text_id);
         ImageView imageView=view.findViewById(R.id.img_id);
         TextView ph_text=view.findViewById(R.id.phone_id);
         ImageView phn_icon=view.findViewById(R.id.phone_call_id);

         textView.setText(names[position]);
         ph_text.setText(phon_no[position]);
         imageView.setImageResource(img[position]);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "txt item is clicked", Toast.LENGTH_SHORT).show();


              AlertDialog.Builder dialog=new AlertDialog.Builder(context);
                dialog.setTitle("list view project");
                //dialog.setMessage(names[position]);
                dialog.setIcon(img[position]);
                dialog.setMessage(phon_no[position]);
                dialog.create();
                dialog.show();
            }
        });



        phn_icon.setImageResource(img2[position]);
        phn_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AlertDialog.Builder builder=new AlertDialog.Builder(context);
               builder.setTitle(names[position]);
               builder.setMessage(phon_no[position]);

               builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       Intent intent=new Intent();
                       intent.setAction(Intent.ACTION_CALL);
                       intent.setData(Uri.parse("tel: "+phon_no[position]));

                       context.startActivity(intent);
                   }
               });
               builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       dialog.dismiss();
                   }
               });
               builder.create();
               builder.show();


                Toast.makeText(context, "phone call touch", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
