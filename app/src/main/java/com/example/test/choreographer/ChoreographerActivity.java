package com.example.test.choreographer;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

/**
 * Choreographer 测试
 */
public class ChoreographerActivity extends AppCompatActivity {
    
    private TextView tvTest;
    private long mLastFrameTime;
    private int mFrameCount;
    
    private int width;
    private int x = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choreographer);
        tvTest = findViewById(R.id.tv_test);
    }

    public void onTest1(View v) {
        width = tvTest.getWidth();
//        ObjectAnimator animator = ObjectAnimator.ofFloat(tvTest, "translationX", width, -width).setDuration(2000);
//        animator.setRepeatCount(ValueAnimator.INFINITE);
//        animator.setRepeatMode(ValueAnimator.RESTART);
//        animator.start();
        Toast.makeText(this, "test", Toast.LENGTH_SHORT).show();
    }

    public void onTest2(View v) {
        width = tvTest.getWidth();

        testChoreographer();
    }
    
    private void testChoreographer() {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            @Override
            public void doFrame(long frameTimeNanos) {
                if (mLastFrameTime == 0) {
                    mLastFrameTime = frameTimeNanos;
                }
                transView();
                float diff = (frameTimeNanos - mLastFrameTime) / 1000000.0f;//得到毫秒，正常是 16.66 ms
                if (diff > 1000) {
                    double fps = (((double) (mFrameCount * 1000L)) / diff);
                    mFrameCount = 0;
                    mLastFrameTime = 0;
//                    System.out.println("============================> doFrame fps: " + fps);
                } else {
                    ++mFrameCount;
                }
                Choreographer.getInstance().postFrameCallback(this);
            }
        });
    }
    
    private void transView() {
        if(x == 0) {
            x = width;
        }
        tvTest.setTranslationX(x);
        x -= 5 ;
        System.out.println("============================> transView x: " + x);
    }
    
    
    

}
