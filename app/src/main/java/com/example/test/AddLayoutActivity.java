package com.example.test;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * RelativeLayout动态添加控件
 */
public class AddLayoutActivity extends AppCompatActivity {

    private Button btnTest;
    private RelativeLayout layout_root_relative;
    private TextView tvTest;
    private FrameLayout flytFrmae;
    private LinearLayout llytParent;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_layout);
        layout_root_relative = findViewById(R.id.rlyt_frame);
        flytFrmae = findViewById(R.id.flyt_frame);
        tvTest = findViewById(R.id.tv_test);
        tvTest.setOnClickListener(v -> {});
        llytParent = findViewById(R.id.llyt_parent);
    }
    
    public void onTest(View v) {
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

    public void onTest1(View v) {
        for(int i = 0; i < 5; i ++) {
            addView((i + 1) * 40);
        }
    }

    private void addView(int marginLeft) {
        ImageView imageView = new ImageView(this);
        FrameLayout.LayoutParams param = new FrameLayout.LayoutParams(60, 60);
        param.gravity = Gravity.CENTER_VERTICAL;
        param.leftMargin = marginLeft;
        imageView.setLayoutParams(param);
        imageView.setImageResource(R.drawable.ic_launcher_test);
        flytFrmae.addView(imageView);
    }

    /**
     * 测试动态添加布局设置最小高度
     * @param v
     */
    public void onTest2(View v) {
        View view = LayoutInflater.from(this).inflate(R.layout.layout_test_add_layout, null);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                getResources().getDimensionPixelSize(R.dimen.common_dialog_width),
                LinearLayout.LayoutParams.WRAP_CONTENT);

        llytParent.addView(view, params);
    }


}