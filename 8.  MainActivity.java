package com.example.phone;

import static java.util.jar.Attributes.Name.CONTENT_TYPE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button call;
    Button save;
    EditText display;
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call=findViewById(R.id.bcall);
        save=findViewById(R.id.bsave);
        display=findViewById(R.id.etext);
        clear=findViewById(R.id.bclear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                display.setText("");
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myint;
                Uri phone;
                phone=Uri.parse("tel:"+display.getText().toString());

                myint=new Intent(Intent.ACTION_DIAL,phone);
                startActivity(myint);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num=display.getText().toString();
                Intent intent=new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
                intent.putExtra(ContactsContract.Intents.Insert.PHONE,num);
                startActivity(intent);
            }
        });
    }

    public void type(View view) {
        Button btn=(Button)view;
        display.setText(display.getText().toString()+btn.getText().toString());
    }
}
