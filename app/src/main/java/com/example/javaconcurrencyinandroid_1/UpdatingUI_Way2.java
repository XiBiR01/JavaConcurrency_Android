package com.example.javaconcurrencyinandroid_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class UpdatingUI_Way2 extends AppCompatActivity {
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updating_u_i__way2);
        textView2=findViewById(R.id.textView2);
//        Create the Task and its Thread + UI updating method()-->Handler()
        Runnable run = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(9000);
                    Handler handler=new Handler(getMainLooper());
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            textView2.setText("Task Finished after 9 seconds");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread=new Thread(run);
        thread.start();
    }
}