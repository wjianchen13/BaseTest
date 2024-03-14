package com.example.test.wrap;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

/**
 * 自适应布局测试
 * LinearLayout在设置wrap_content的情况下，子控件设置match_parent也不会顶到最大
 * ConstraintLayout在设置wrap_content的情况下，子控件设置match_parent也不会顶到最大，只不过要把对应的width和height设置成0
 * RelativeLayout在设置wrap_content的情况下，子控件设置match_parent会顶到最大
 */
public class WrapActivity extends AppCompatActivity {

    private ImageView imgvTest;
    private long nowMills;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrap);
    }
    
    
    
}