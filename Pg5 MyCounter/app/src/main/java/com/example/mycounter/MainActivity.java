package com.example.mycounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtCounter;
    Button btnStart, btnStop;
    int cnt;
    boolean running = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCounter = findViewById(R.id.textViewCV);

        btnStart = findViewById(R.id.button_start);
        btnStart.setOnClickListener(this);

        btnStop = findViewById(R.id.button_stop);
        btnStop.setOnClickListener(this);
        btnStop.setEnabled(false);

    }

    @Override
    public void onClick(View v) {
        if(v.equals(btnStart))
        {
            cnt = 0;
            running = true;
            new MyCounter().start();
            btnStart.setEnabled(false);
            btnStop.setEnabled(true);
        }
        else if(v.equals(btnStop))
        {
            running = false;
            btnStart.setEnabled(true);
            btnStop.setEnabled(false);
        }
    }

    Handler handler = new Handler( msg ->
    {
        txtCounter.setText(String.valueOf(msg.what));
        return true;
    });

    class MyCounter extends Thread
    {
        public void run()
        {
            while(running)
            {
                handler.sendEmptyMessage(cnt);
                try {Thread.sleep(1000);}
                catch(Exception e){}
                cnt++;
            }
        }
    }
}