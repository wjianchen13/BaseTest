package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.html.HtmlActivity;
import com.example.test.imagespan.ImageSpanActivity;

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

    /**
     * 普通测试
     * @param v
     */
    public void onNormalTest(View v) {
        startActivity(new Intent(this, NormalTestActivity.class));
    }

    /**
     * Html.fromHtml() 测试
     * @param v
     */
    public void onHtml(View v) {
        startActivity(new Intent(this, HtmlActivity.class));
    }
    
    /**
     * ImageSpan测试
     * @param v
     */
    public void onImageSpan(View v) {
        startActivity(new Intent(this, ImageSpanActivity.class));
    }

    /**
     * 屏幕密度测试
     * @param v
     */
    public void onDensity(View v) {
        startActivity(new Intent(this, DensityActivity.class));
    }

    /**
     * RadioButton测试
     * @param v
     */
    public void onRadioButton(View v) {
        startActivity(new Intent(this, RadioButtonActivity.class));
    }
    
}