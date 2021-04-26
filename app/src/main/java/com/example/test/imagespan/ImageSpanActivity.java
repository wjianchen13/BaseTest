package com.example.test.imagespan;

import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

/**
 * ImageSpan 测试
 * 测试字符串含有系统表情时，部分能显示的手机，粉丝团徽章内容往下移动的问题
 * 只需要修正KiwiiFansBadgeImageSpan
 *         ty = (height + bounds.height()) / 2 - KiwiiScreenUtils.dip2px(3f);
 * KiwiiScreenUtils.dip2px 里面的值就可以了，原来是1.2f
 */
public class ImageSpanActivity extends AppCompatActivity {

    private EditText edtvTest;
    private TextView tvTest;
    private TextView tvTest1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        KiwiiScreenUtils.setContext(this);
        setContentView(R.layout.activity_imagespan);
        edtvTest = findViewById(R.id.edtv_test);
        tvTest = findViewById(R.id.tv_test);
        tvTest1 = findViewById(R.id.tv_test1);
    }

    /**
     * ImageSpan 测试
     * @param v
     */
    public void onTest1(View v) {
        SpannableString fansImageSpan = KiwiiScreenUtils.getFansBadgeImageSpan(this
                , "1"
                , edtvTest.getText().toString()
                , KiwiiScreenUtils.dip2px(KiwiiScreenUtils.INTER_IMG_CHAT_NORMAL_HEIGHT), KiwiiScreenUtils.KIWII_ALIGN_CENTER);
        tvTest.setText(fansImageSpan);
    }

    /**
     * ImageSpan 测试
     * @param v
     */
    public void onTest2(View v) { 
        tvTest1.setText(edtvTest.getText().toString());

    }

    
}
