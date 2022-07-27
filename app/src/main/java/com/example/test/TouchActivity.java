package com.example.test;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Touch触发一些事件
 */
public class TouchActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener{
    
    private static final int MSG_TEST = 1;
    
    private TextView tvTest;
    
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == MSG_TEST) {
                System.out.println("======================> onToast");
                if(tvTest != null && tvTest.isPressed())
                    sendEmptyMessageDelayed(MSG_TEST, 200);
            }
        }
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);
        tvTest = findViewById(R.id.tv_test);
        tvTest.setOnClickListener(this);
        tvTest.setOnLongClickListener(this);
        tvTest.setOnTouchListener(this);

    }

    @Override
    public void onClick(View v) {
        System.out.println("======================> onClick");
    }

    @Override
    public boolean onLongClick(View v) {
        System.out.println("======================> onLongClick");
        if(mHandler != null) {
            mHandler.sendEmptyMessage(MSG_TEST);
        }
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("======================> onTouch ACTION_DOWN: " + tvTest.isInTouchMode() + "  isPressed: " + tvTest.isPressed());
                break;
                
            case MotionEvent.ACTION_MOVE:
                System.out.println("======================> onTouch ACTION_MOVE: " + tvTest.isInTouchMode() + "  isPressed: " + tvTest.isPressed());
                break;

            case MotionEvent.ACTION_UP:
                System.out.println("======================> onTouch ACTION_UP: " + tvTest.isInTouchMode() + "  isPressed: " + tvTest.isPressed());
                break;
                
            case MotionEvent.ACTION_CANCEL:
                System.out.println("======================> onTouch ACTION_CANCEL: " + tvTest.isInTouchMode() + "  isPressed: " + tvTest.isPressed());
                break; 
        }
        
        return false;
    }

    public void onTest1(View v) {
        System.out.println("======================> isPressed: " + tvTest.isPressed());
    }

    public void onTest2(View v) {

    }

    public void onTest3(View v) {

    }



}
