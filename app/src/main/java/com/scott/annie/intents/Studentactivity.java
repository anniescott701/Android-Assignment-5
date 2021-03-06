package com.scott.annie.intents;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Studentactivity extends AppCompatActivity {

    Button pbtn,gbtn;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentactivity);

        Toast.makeText(this,"Welcome Student",Toast.LENGTH_SHORT).show();

        pbtn=(Button) findViewById(R.id.uploadpicture);
        gbtn=(Button) findViewById(R.id.googlebtn);

        img=(ImageView)findViewById(R.id.imageView);

        pbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takepictureintent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takepictureintent,101);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==101)
        {
            if (resultCode==RESULT_OK){
                Bundle extrabundle= data.getExtras();
                Bitmap imagebitmap=(Bitmap)extrabundle.get("data");
                img.setImageBitmap(imagebitmap);
            } else if (resultCode==RESULT_CANCELED){
                Toast.makeText(this,"User cancelled the operation",Toast.LENGTH_SHORT).show();
            }

        }
        gbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "+91123456789"));
                startActivity(intent);
            }

            });
        }
    }

