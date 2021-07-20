package com.example.test;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 时间统计， selector动态生成
 */
public class AddLayoutActivity extends AppCompatActivity {

    private Button btnTest;
    private RelativeLayout layout_root_relative;
    private TextView tvTest;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_layout);
        layout_root_relative = findViewById(R.id.rlyt_frame);
        tvTest = findViewById(R.id.tv_test);
        tvTest.setOnClickListener(v -> {});
        
        
        
    }
    
    public void onTest(View v) {
//        rlytFrame
        generateSingleLayout(1, "hello");
    }

    /**
     * 新建一个列表item 
     * @param imageID 新建imageView的ID值 
     * @param str  TextView要显示的文字 
     * @return 新建的单项布局变量
     */
    private RelativeLayout generateSingleLayout(int imageID,String str) {
        ImageView imageView = new ImageView(this);
        RelativeLayout.LayoutParams RL_WW = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
//        imageView.setPadding(5, 5, 5, 5);
        RL_WW.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        imageView.setLayoutParams(RL_WW);
        imageView.setClickable(true);
        imageView.setId(imageID);
        imageView.setImageResource(R.drawable.ic_test);
        layout_root_relative.addView(imageView);

        return layout_root_relative;

    }

}