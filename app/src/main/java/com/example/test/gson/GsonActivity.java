package com.example.test.gson;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.google.gson.Gson;

/**
 * Gson测试
 */
public class GsonActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gson);
    }

    public void onTest1(View v) {
        String str = " {\"name\": \"lisi\",\"age\": \"20\",\"phone1\": \"22222\",\"email\": \"22222@22.com\"}";
        UserBean userBean = new Gson().fromJson(str, UserBean.class);
        int c = 0;
    }



}
