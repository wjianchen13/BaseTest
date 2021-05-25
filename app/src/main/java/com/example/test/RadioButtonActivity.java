package com.example.test;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * RadioButton 自定义图标，显示位置，选中字体颜色
 */
public class RadioButtonActivity extends AppCompatActivity {

    private ImageView imgvTest;

    private RadioGroup rg;
    private RadioButton rb1;
    private RadioButton rb2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        imgvTest = findViewById(R.id.imgv_test);
        rb1 = findViewById(R.id.radiobutton1);
        rb2 = findViewById(R.id.radiobutton2);
        rg = findViewById(R.id.radiogroup1);
        //定义底部标签图片大小 
        Drawable drawableWeiHui = getResources().getDrawable(R.drawable.bg_radiobutton);
        drawableWeiHui.setBounds(0, 0, 50, 50);
        rb1.setCompoundDrawables(null, null, drawableWeiHui, null);

        Drawable drawableWeiHui1 = getResources().getDrawable(R.drawable.bg_radiobutton);
        drawableWeiHui1.setBounds(0, 0, 50, 50);
        rb2.setCompoundDrawables(null, null, drawableWeiHui1, null);
        
        rg.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId == R.id.radiobutton1) {
                Toast.makeText(RadioButtonActivity.this, "radiobutton1", Toast.LENGTH_SHORT).show();
            } else if(checkedId == R.id.radiobutton2) {
                Toast.makeText(RadioButtonActivity.this, "radiobutton2", Toast.LENGTH_SHORT).show();
            }
        });
    }
    
    public void onTest(View v) {
//        byte v1 = 0;
//        byte v2 = 1;
//        byte v3 = 31;
//        int length = (v1 << 16) | (v2 << 8) | (v3 >>> 0) & 0xff;
//        Toast.makeText(RadioButtonActivity.this, "length: " + length, Toast.LENGTH_SHORT).show();

        int v1 = 0;
        int v2 = -105;
        byte v3 = 83;
        int temp1 = v1 << 16;
        int temp2 = v2 << 8;
        int temp3 = v3 >>> 0;
        int temp4 = temp1 | temp2 | temp3;
        int temp5 = temp4 & 0xff;
        int length = (v1 << 16) | (v2 << 8) | (v3 >>> 0) & 0xff;
        Toast.makeText(RadioButtonActivity.this, "length: " + length, Toast.LENGTH_SHORT).show();
        
        byte vv1 = 3;
        byte vv2 = -105;
        byte vv3 = 83;
        int t1 = (vv1 << 16) & 0xff0000;
        int t2 = (vv2 << 8) & 0xff00;
        int t3 = (vv3) & 0xff;
        int t4 = t1 | t2 | t3;
        int t5 = t4 & 0xff;
        
//        0000 0000 1001 0111 0101 0011
    }
    
    
}

























