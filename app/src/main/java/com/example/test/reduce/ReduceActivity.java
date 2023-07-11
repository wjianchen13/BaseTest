package com.example.test.reduce;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.TouchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 减小控件的点击区域
 */
public class ReduceActivity extends AppCompatActivity implements View.OnClickListener{
    
    private Button btnTest;
    private Button btnTest1;
    
    private List<Integer> mList = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reduce);
        btnTest = findViewById(R.id.btn_test);
        btnTest1 = findViewById(R.id.btn_test1);
//        btnTest.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                switch (motionEvent.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        float x = motionEvent.getX();
//                        float y = motionEvent.getY();
//                        if(x < btnTest.getX() + 50 || x > btnTest.getWidth() - 50)
//                            return true;
//
//                        break;
//
//                    case MotionEvent.ACTION_UP:
//                    case MotionEvent.ACTION_CANCEL:
//
//                        break;
//                }
//                return false;
//            }
//        });
//        btnTest.setOnClickListener(this);

        btnTest1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_test) {
            Toast.makeText(this, "onClick", Toast.LENGTH_SHORT).show();
        } else if(view.getId() == R.id.btn_test1) {
            Toast.makeText(this, "onClick1", Toast.LENGTH_SHORT).show();
        }
    }
}
