package com.example.bs058.threadsynchonization;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public TextView txtThreadView;
    String[] texts = {"Text :1", "Text :2", "Text :3", "Text :4", "Text :5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtThreadView = (TextView) findViewById(R.id.txtThreadText);
    }

    @Override
    protected void onResume() {
        super.onResume();
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            int i =0;
            @Override
            public void run() {
                //Do something after 100ms
               txtThreadView.setText(texts[(i++) % texts.length]);
                handler.postDelayed(this, 2000);
            }
        }, 1500);
    }
}
