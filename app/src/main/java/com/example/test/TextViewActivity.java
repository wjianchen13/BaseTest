package com.example.test;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.uitls.Utils;

/**
 * TextView 获取第一行显示的内容
 */
public class TextViewActivity extends AppCompatActivity {

    private LinearLayout llytFrame;
    private TextView tvTest1;
    private TextView tvTest2;
    private TextView tvTest3;
    private Button btnTest;
    private String str = "hello1hello2hello3hello4hello5hello6hello7hello8hello9hello10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        llytFrame = findViewById(R.id.llyt_frame);
        tvTest1 = findViewById(R.id.tv_test1);
        tvTest2 = findViewById(R.id.tv_test2);
        btnTest = findViewById(R.id.btn_test);
//        llytFrame.addView(addView1());
        addView1();

        tvTest1.setText(str);
//        tvTest1.setSingleLine(false);
        tvTest2.setText(str);
    }

    /**
     *
     * @param v
     */
    public void onTest(View v) {
//        Layout layout = tvTest2.getLayout();
//        if (layout != null) {
//            // 获取第一行的起始位置和结束位置
//            int firstLineStart = layout.getLineStart(0);
//            int firstLineEnd = layout.getLineEnd(0);
//
//            // 获取第一行的字符串
//            CharSequence firstLineText = tvTest2.getText().subSequence(firstLineStart, firstLineEnd);
//
//            Utils.log("第一行的字符串：" + firstLineText);
//        }

        Layout layout3 = tvTest3.getLayout();
        if (layout3 != null) {
            // 获取第一行的起始位置和结束位置
            int firstLineStart = layout3.getLineStart(0);
            int firstLineEnd = layout3.getLineEnd(0);

            // 获取第一行的字符串
            CharSequence firstLineText = tvTest2.getText().subSequence(firstLineStart, firstLineEnd);

            Utils.log("第一行的字符串3：" + firstLineText);
        }
    }

    /**
     *
     * @param v
     */
    public void onTest1(View v) {

    }

    private View addView1() {
        // TODO 动态添加布局(xml方式)
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);  //LayoutInflater inflater1=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //  LayoutInflater inflater2 = getLayoutInflater();
        LayoutInflater inflater3 = LayoutInflater.from(this);
        tvTest3 = (TextView)inflater3.inflate(R.layout.item_textview, null);
        tvTest3.setLayoutParams(lp);
        tvTest3.setSingleLine(false);
        tvTest3.setText(str);
        int w = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.AT_MOST);
        int h = View.MeasureSpec.makeMeasureSpec(0,
                View.MeasureSpec.AT_MOST);
        tvTest3.measure(w, h);
        tvTest3.layout(0, 0, tvTest3.getMeasuredWidth(), tvTest3.getMeasuredHeight());
        return tvTest3;
    }

    
}