package com.example.test.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

import java.util.ArrayList;

/**
 * 循环需求
 */
public class ParcelableOtherActivity extends AppCompatActivity {

    private ArrayList<ActionDinoBean> beans;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_parcelable_other);
            Intent it = getIntent();
            beans = it.getParcelableArrayListExtra("param");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    public void onTest1(View v) {
        for(int i = 0; i < beans.size(); i ++) {
            System.out.println("==================> bean[" + i + "]: " + beans.get(i).getId() + "   " + beans.get(i).getName() + "   " + beans.get(i).getUrl());
        }
    }
    

}
