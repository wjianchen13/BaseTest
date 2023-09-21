package com.example.test.half;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.vertical.MarqueeTextView;

/**
 * 半屏Activity
 * https://blog.csdn.net/amir_zt/article/details/114922218
 * 这里显示的状态栏是灰色的，如果不需要灰色，需要设置状态栏，项目里面就有设置
 */
public class HalfActivity extends AppCompatActivity {

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_half);
        
    }

    public void onTest1(View v) {
        startActivity(new Intent(this, DialogActivity.class));
    }

    /**
     * 
     * @param v
     */
    public void onTest2(View v) {

    }


    
}
