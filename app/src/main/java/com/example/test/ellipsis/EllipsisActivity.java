package com.example.test.ellipsis;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

/**
 * TextView显示省略号
 */
public class EllipsisActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ellipsis);
    }

    /**
     *
     * @param v
     */
    public void onTest1(View v) {
        String str = "lvwth --- {\"width\":23,\"height\":10}";
        int startIndex = str.indexOf("{");
        int endIndex = str.length();
        String result = str.substring(startIndex, endIndex);
        System.out.println(result);  //
    }

    /**
     *
     * @param v
     */
    public void onTest2(View v) {

    }


}
