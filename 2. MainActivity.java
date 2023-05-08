package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText display;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0;
//    Button b2;
//    Button b3;
//    Button b4;
//    Button b5;
//    Button b6;
//    Button b7;
//    Button b8;
//    Button b9;
//    Button b0;
    Button bp;
    Button bm;
    Button bmu;
    Button bd;
    Button be;
    Button bc;
    double result=0;
    int flag=0;
    int sym=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display=findViewById(R.id.eText);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);
        b0=findViewById(R.id.b0);
        bp=findViewById(R.id.bplus);
        bm=findViewById(R.id.bminus);
        bmu=findViewById(R.id.bmul);
        bd=findViewById(R.id.bdiv);
        be=findViewById(R.id.bres);
        bc=findViewById(R.id.bclear);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copy();
                display.setText(display.getText().toString()+b1.getText().toString());
            }

        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copy();
                display.setText(display.getText().toString()+b2.getText().toString());
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copy();
                display.setText(display.getText().toString()+b3.getText().toString());
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copy();
                display.setText(display.getText().toString()+b4.getText().toString());
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copy();
                display.setText(display.getText().toString()+b5.getText().toString());
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copy();
                display.setText(display.getText().toString()+b6.getText().toString());
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copy();
                display.setText(display.getText().toString()+b7.getText().toString());
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copy();
                display.setText(display.getText().toString()+b8.getText().toString());
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copy();
                display.setText(display.getText().toString()+b9.getText().toString());
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                copy();
                display.setText(display.getText().toString()+b0.getText().toString());
            }
        });
        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    display.setText("");
                    result=0;
                    flag=0;
                    sym=-1;
            }
        });

        be.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                sym=-1;
            }
        });

        bp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                sym=2;
            }
        });
        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                sym=3;
            }
        });
        bmu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                sym=1;
            }
        });
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                sym=0;
            }
        });

    }

    private void compute() {
        double value=Double.valueOf(display.getText().toString());
            switch (sym){
                case 0 :    result /= value;
                    break;
                case 1 :    result *= value;
                    break;
                case 2 :    result += value;
                    break;
                case 3 :    result -= value;
                    break;
            }
        display.setText(""+result);
        flag=1;
        }
    
    private void copy() {

        if(flag==1) {
            result = Double.valueOf(display.getText().toString());
            display.setText("");
            flag=0;
        }
    }
}
