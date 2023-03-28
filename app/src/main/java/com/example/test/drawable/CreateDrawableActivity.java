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
    private RoundRectTextView tvTest2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_drawable);
        tvTest = findViewById(R.id.tv_test);
        tvTest2 = findViewById(R.id.tv_test2);
    }

    /**
     * lambda表达式测试
     * @param v
     */
    public void onTest1(View v) {
        tvTest.setBackground(DrawableUtils.createDrawable(Color.argb(50, 255, 0, 0), Color.argb(255, 255, 0, 0), 10));
    }

    public void onTest2(View v) {
        tvTest2.initBackground("#ff0000");
        tvTest2.setText("hello");
    }

    public void onTest3(View v) {
        ColorUtils.toRGB("#ff0000");
    }

    public void onTest4(View v) {

    }

    public void onTest5(View v) {

    }


}
