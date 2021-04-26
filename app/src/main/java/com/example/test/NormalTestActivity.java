package com.example.test;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 普通测试
 */
public class NormalTestActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_test);

    }

    /**
     * 
     * @param v
     */
    public void onTest1(View v) {
        StringBuilder sb = new StringBuilder("111");
        sb.append("222");
        String c = sb + "";
        System.out.println("===========================> c: " + (sb + ""));
        
        
        
    }
    
}
