package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 时间统计， selector动态生成
 */
public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 时间时长
     * @param v
     */
    public void onTime(View v) {
        startActivity(new Intent(this, TimeActivity.class));
    }

    /**
     * 
     * @param v
     */
    public void onLambda(View v) {
        startActivity(new Intent(this, LambdaActivity.class));
    }

    /**
     *
     * @param v
     */
    public void onLevelList(View v) {
        startActivity(new Intent(this, LevelActivity.class));
    }

    /**
     * 动态生成drawable
     * @param v
     */
    public void onCreateDrawable(View v) {
        startActivity(new Intent(this, DrawableActivity.class));
    }
}