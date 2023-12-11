package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.half.DialogActivity;
import com.example.test.uitls.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试当天是否有操作
 */
public class CurrentDayActivity extends AppCompatActivity {

    private static final String TEST_NAME = "test";
    private static final String DATA_STRING_FORMAT = "yyyyMMdd";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_day);
        
    }

    public void onTest1(View v) {
        long currentTime = System.currentTimeMillis();
        Utils.log("getCurrentStringDay: " + getCurrentStringDay());
//        SharedPreferences sp = getSharedPreferences(TEST_NAME, Context.MODE_PRIVATE);
//        SharedPreferences.Editor edit = sp.edit();
//        if(edit != null) {
//            edit.putString("test_day", val);
//            edit.apply();
//        }
    }

    /**
     * 
     * @param v
     */
    public void onTest2(View v) {

    }

    /**
     * 返回当前时间字符串形式，格式yyyy-MM-dd
     * @return
     */
    public static String getCurrentStringDay() {
        DateFormat df = new SimpleDateFormat(DATA_STRING_FORMAT);
        return getCurrentString(df);
    }

    /**
     * 获取当前时间字符串
     */
    public static String getCurrentString(final DateFormat format) {
        return format.format(new Date(System.currentTimeMillis()));
    }
    
}
