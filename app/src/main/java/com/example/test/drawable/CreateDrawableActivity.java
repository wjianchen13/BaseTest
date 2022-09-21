package com.example.test.drawable;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

/**
 * 动态生成drawable
 */
public class CreateDrawableActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_drawable);
        tvTest = findViewById(R.id.tv_test);
    }

    /**
     * lambda表达式测试
     * @param v
     */
    public void onTest1(View v) {
        tvTest.setBackground(DrawableUtils.createDrawable(Color.argb(50, 255, 0, 0), Color.argb(255, 255, 0, 0), 10));
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
