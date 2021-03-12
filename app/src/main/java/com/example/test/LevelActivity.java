package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * level-list 测试
 */
public class LevelActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        tvTest = findViewById(R.id.tv_test);
    }

    /**
     * lambda表达式测试
     * @param v
     */
    public void onTest1(View v) {
        tvTest.getBackground().setLevel(0);
    }

    public void onTest2(View v) {
        tvTest.getBackground().setLevel(1);
    }

    public void onTest3(View v) {
        tvTest.getBackground().setLevel(2);
    }

    public void onTest4(View v) {
        tvTest.getBackground().setLevel(3);
    }

    public void onTest5(View v) {
        tvTest.getBackground().setLevel(4);
        boolean isFans = true;
        int type = 3;
        int result = getItemType(isFans, type);
        System.out.println("=================> result: " + result);
    }

    /**
     * 显示itemtype
     * @param isFans
     * @param viptype
     * @return
     */
    private int getItemType(boolean isFans, int viptype) {
        return isFans ?  5
                : viptype == 3 ? 3
                : viptype == 2 ? 2
                : viptype == 1 ? 1
                : 0;
    }
    
}
