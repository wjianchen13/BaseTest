package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * TextView滚动
 */
public class MarqueeActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marquee);
        tvTest = findViewById(R.id.tv_test);
        tvTest.requestFocus();
    }


    /**
     *
     * @param v
     */
    public void onTest2(View v) {

    }

    
}