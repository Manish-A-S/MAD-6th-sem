package com.example.calculator;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText tv;
    Button clear;
    int num1,num2;
    String sym;
    String text="";
    int result;
    String[] num ={};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.editTextText);
        clear=findViewById(R.id.button11);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("");
                String[] num ={};
                int result=0;
                text="";
                sym="";
            }
        });
    }


    public void calculate(View view){


        switch(sym){
            case "a": num= text.split("a");
                break;

            case "-":   num= text.split("-");
                break;

            case "/": num= text.split("/");
                break;

            case "m":  num= text.split("m");
                break;
        }

        num1= parseInt(num[0]);
        num2= parseInt(num[1]);



        switch(sym){
            case "a":   result=num1+num2;
                        tv.append("="+result);
                        break;

            case "-":   result=num1-num2;
                        tv.append("="+result);
                        break;

            case "/":   result=num1/num2;
                        tv.append("="+result);
                        break;

            case "m":   result=num1*num2;
                        tv.append("="+result);
                        break;
        }
    }

    public void enter(View view){
        Button btn=(Button)view;
        String value = btn.getText().toString();
        tv.append(value);
        text=text.concat(value);

    }
    public void symbols(View view){
        Button btn=(Button)view;
        sym=btn.getText().toString();
        tv.append(sym);
        switch(sym){
            case "+": sym="a";
                        break;
            case "*": sym="m";
                        break;
        }
        text=text.concat(sym);
    }
}
