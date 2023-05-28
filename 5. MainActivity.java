package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button start,reset;
    TextView time;
    int count=0;
    Handler myhandler=new Handler();
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start=findViewById(R.id.start);
        reset=findViewById(R.id.reset);
        time=findViewById(R.id.time);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myhandler.postDelayed(timer,0);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myhandler.removeCallbacks(timer);
                count=0;
                time.setText(""+count);
            }
        });
    }
    Runnable timer=new Runnable(){
        @Override
        public void run(){
            count+=1;
            myhandler.postDelayed(this,1000);
            time.setText(""+count);
        }
    };
}
