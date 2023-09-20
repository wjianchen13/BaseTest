package com.example.test.exception;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.vertical.MarqueeTextView;

/**
 * 异常模拟
 */
public class ExceptionActivity extends AppCompatActivity {
    
    private MarqueeTextView tvTest;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exception);
        tvTest = findViewById(R.id.tv_test);
        
    }

    public void onTest1(View v) {
        tvTest.setContent("hello");

    }

    /**
     * 
     * @param v
     */
    public void onTest2(View v) {

    }


    
}
