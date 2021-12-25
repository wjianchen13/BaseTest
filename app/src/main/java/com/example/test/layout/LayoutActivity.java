package com.example.test.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

/**
 *  普通布局测试
 */
public class LayoutActivity extends AppCompatActivity {
    
    private TextView tvTest5;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        tvTest5 = findViewById(R.id.tv_test5);
    }

    public void onTest1(View v) {
        tvTest5.setVisibility(View.VISIBLE);
    }

    public void onTest2(View v) {
        tvTest5.setVisibility(View.GONE);
    }

    public void onTest3(View v) {
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(tvTest5, "translationY", 900, 0).setDuration(5000);
        animator1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                tvTest5.setVisibility(View.VISIBLE);
            }
        });
        animator1.start();
    }

    
}
