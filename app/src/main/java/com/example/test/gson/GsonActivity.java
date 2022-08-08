package com.example.test.gson;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

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

    public void onTest2(View v) {
        int d = 5; // 分钟
        int duration = 5 * 60 * 1000; // ms

        List<Long> times = new ArrayList<>();
        long current = 1659584151796l;
        long t1 = 1659583550796l;
        long t2 = 1659583850796l;
        times.add(t1);
        times.add(t2);
        for(int i = times.size() - 1; i >= 0; i --) {
            if(current - times.get(i) > duration) {
                times.remove(i);
            }
        }
        if(times.size() < 2) {
            times.add(current); // return true
        }
//        return false;


    }

    public void onTest3(View v) {

    }

}
