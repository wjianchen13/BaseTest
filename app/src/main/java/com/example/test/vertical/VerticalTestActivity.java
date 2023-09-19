package com.example.test.vertical;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

/**
 * 普通测试
 * 全局符号静态变量符号$&改成%!（可提交）
 */
public class VerticalTestActivity extends AppCompatActivity {
    
    private MarqueeTextView tvTest;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vertical_test);
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
