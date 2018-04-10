package com.scott.annie.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    Button b1, b2;
    TextView username,password;
    EditText user, pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.submit);
        b2 = (Button) findViewById(R.id.reset);

        username = (TextView) findViewById(R.id.username);
        password = (TextView) findViewById(R.id.reset);

        user = (EditText) findViewById(R.id.usernameedt);
        pwd = (EditText) findViewById(R.id.pwdedt);



        b1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.submit){
            String un= user.getText().toString();
            String pw= pwd.getText().toString();
            if (un.equalsIgnoreCase("Ann") && pw.equals("Annie")){

                Intent intent= new Intent(MainActivity.this,Instructoractivity.class);
                startActivity(intent);

            }else if (un.equals("student")&& pw.equals("student")) {
                Intent intent2 = new Intent(MainActivity.this, Studentactivity.class);
                startActivity(intent2);
            }







        }
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setText("");
                pwd.setText("");
            }

        });
    }
}
