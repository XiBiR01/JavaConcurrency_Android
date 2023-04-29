package com.example.javaconcurrencyinandroid_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        btn=findViewById(R.id.btn);
//        Creating Task(Runnable) Thread(custom/worker thread) and UI updating method->runOnUiThread()
        Runnable run = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);

//                    Run Something on the UI thread from this Worker Thread
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Task Completed", Toast.LENGTH_SHORT).show();
                            textView.setText("Task Finished after 5 seconds");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread extraThread=new Thread(run);
        extraThread.start();
//Next Activity
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,UpdatingUI_Way2.class);
                startActivity(intent);
            }
        });

    }

}