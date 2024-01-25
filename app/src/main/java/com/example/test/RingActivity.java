package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.uitls.Utils;

/**
 * 圆环
 * 仅当 android:shape="ring" 如下时才使用以下属性：
 * android:innerRadius
 * 尺寸。环内部（中间的孔）的半径，以尺寸值或尺寸资源表示。
 * android:innerRadiusRatio
 * 浮点型。环内部的半径，以环宽度的比率表示。例如，如果android:innerRadiusRatio=“5”，则内半径等于环宽度除以 5。此值被 android:innerRadius 覆盖。默认值为 9。
 * android:thickness
 * 尺寸。环的厚度，以尺寸值或尺寸资源表示。
 * android:thicknessRatio
 * 浮点型。环的厚度，表示为环宽度的比率。例如，如果android:thicknessRatio=“2”，则厚度等于环宽度除以 2。此值被 android:innerRadius 覆盖。默认值为 3。
 * android:useLevel
 * 布尔值。如果此属性用作 LevelListDrawable，则值为“true”。此属性的值通常应为“false”，否则无法显示形状。
 * 原文链接：https://blog.csdn.net/intbird/article/details/106666374
 *
 * https://blog.csdn.net/suyimin2010/article/details/81256598
 * 这里既没有定义innerRadius , 也没有定义thickness , 也就是说，系统默认使用了innerRadiusRatio 取值3，也使用了thicknessRatio 取值 9
 */
public class RingActivity extends AppCompatActivity {

    private StringBuilder sb = new StringBuilder();
    private TextView tv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ring);
    }

    public void onTest1(View v) {
        sb.append("hello\n");
        Utils.log(sb.toString());
    }

    public void onTest2(View v) {
        sb.append("hello1\n");
        Utils.log(sb.toString());
    }

    public void onTest3(View v) {
        try {
            tv.setText("");
        } catch (Exception e) {
            String err = e.getMessage();
            Utils.log("error: " + err);
        }
    }

    public void onTest4(View v) {

    }

    public void onTest5(View v) {

    }

}
