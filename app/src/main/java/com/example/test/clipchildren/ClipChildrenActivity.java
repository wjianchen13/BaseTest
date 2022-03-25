package com.example.test.clipchildren;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

/**
 * ClipChildren测试
 */
public class ClipChildrenActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);
    }


    /**
     * 常规测试
     * @param v
     */
    public void onTest1(View v) {
        String str = getResources().getString(R.string.test1);
        System.out.println("========================> str == null: " + (str == null));
        System.out.println("========================> str.equals(): " + str.equals(""));
    }

    
}