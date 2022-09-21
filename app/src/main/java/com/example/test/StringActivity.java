package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.uitls.Utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * String测试
 */
public class StringActivity extends AppCompatActivity {

    private StringBuilder sb = new StringBuilder();
    private TextView tv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string);
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
