package com.example.test;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Button状态同步
 */
public class StateActivity extends AppCompatActivity {

    View btnTest1 = null;
    View btnTest2 = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);
        btnTest1 = findViewById(R.id.btn_test1);
        btnTest2 = findViewById(R.id.btn_test2);
        btnTest2.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
//                        btnTest1.setPressed(true);
                        break;

                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
//                        btnTest1.setPressed(false);
                        break;
                }

                return false;
            }
        });
        btnTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(StateActivity.this, "hello", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /**
     * 常规测试
     * @param v
     */
    public void onTest2(View v) {
        btnTest1.setPressed(true);
        btnTest1.setPressed(false);
    }

    
}