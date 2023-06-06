package com.example.call;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity{
    Button oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn;
    Button sixBtn, sevenBtn, eightBtn, nineBtn, zeroBtn;
    Button starBtn, hashBtn;
    Button delBtn, callBtn, saveBtn;
    EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oneBtn = (Button) findViewById(R.id.one_btn_id);

        twoBtn = (Button) findViewById(R.id.two_btn_id);


        threeBtn = (Button) findViewById(R.id.three_btn_id);


        fourBtn = (Button) findViewById(R.id.four_btn_id);


        fiveBtn = (Button) findViewById(R.id.five_btn_id);


        sixBtn = (Button) findViewById(R.id.six_btn_id);


        sevenBtn = (Button) findViewById(R.id.seven_btn_id);


        eightBtn = (Button) findViewById(R.id.eight_btn_id);


        nineBtn = (Button) findViewById(R.id.nine_btn_id);


        zeroBtn = (Button) findViewById(R.id.zero_btn_id);

        delBtn = (Button) findViewById(R.id.delete_btn_id);


        callBtn = (Button) findViewById(R.id.call_btn_id);


        saveBtn = (Button) findViewById(R.id.save_btn_id);


        starBtn = (Button) findViewById(R.id.star_btn_id);


        hashBtn = (Button) findViewById(R.id.hash_btn_id);


        phoneNumber = findViewById(R.id.phone_number_id);
        phoneNumber.setText("");
    }


    public void clicker(View view) {
        Button btn = (Button)view;
        if(view.equals(delBtn)) {
            String phoneNum = phoneNumber.getText().toString();
            if (phoneNum.length() > 0) {
                phoneNumber.setText(phoneNum.substring(0, phoneNum.length()-1));
            } else {
                phoneNumber.setText("");
            }
            phoneNumber.setSelection(phoneNumber.getText().toString().length());
        } else if(view.equals(callBtn)) {
            System.out.print("Call Button Pressed");
            String phoneNum = phoneNumber.getText().toString();
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:"+phoneNum));
            startActivity(intent);
        } else if(view.equals(saveBtn)) {
            System.out.print("Save Button Pressed");
            String phoneNum = phoneNumber.getText().toString();
            Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
            intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
            intent.putExtra(ContactsContract.Intents.Insert.NAME, "Unknown");
            intent.putExtra(ContactsContract.Intents.Insert.PHONE, phoneNum);
            startActivity(intent);
        } else {
            phoneNumber.append(btn.getText());
        }
    }
}
