package com.example.test;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

/**
 * 多线程同步
 */
public class LockActivity extends AppCompatActivity {
    
//    private int i;
//
//    private int j;
    
    private List<Integer> mList = new ArrayList<>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);
    }

    public void onTest1(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LockActivity.class) {
                    for (int i = 0; i < 100; i++) {
                        mList.add(i);
                        System.out.println("==================== thread1 i: " + i);
                        System.out.println("==================== thread1 mList size: " + mList.size());
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (LockActivity.class) {
                    for (int j = 0; j < 100; j++)
                        System.out.println("==================== thread2 j: " + j++);
                }
            }
        }).start();
    }

    public void onTest2(View v) {
//        int count = 1001;
//        int count = 1200000;
        int count = 1300000001;
        int k = 1000;
        int m = 1000 * 1000;
        int b = m * k;
        String audience_count = "0";
        if (count >= k && count < m) {
            audience_count = count / k + "." + Math.min(9, (int) Math.ceil((count % k) / 100f)) + "K";
        } else if(count >= m && count < b) {
            audience_count = count / m + "." + Math.min(9, (int) Math.ceil((count % m) / 100000f)) + "M";
        } else if(count >= b) {
            audience_count = count / b + "." + Math.min(9, (int) Math.ceil((count % b) / 100000000d)) + "B";
        }  else {
            audience_count = count + "";
        }
        System.out.println("=====================================> " + audience_count);
    }

    public void onTest3(View v) {
        mList.add(new Integer(0));
        mList.add(new Integer(2));
        for(int i = 0; i < mList.size(); i ++) {
            System.out.println("=========================> i = " + i + " : " + mList.get(i));
        }
        List<Integer> mList1 = new ArrayList<>();
        mList1.add(new Integer(3));
        mList1.add(new Integer(4));
        mList1.add(new Integer(5));
        mList.addAll(1, mList1);
        System.out.println("=================================================================> ");
        for(int i = 0; i < mList.size(); i ++) {
            System.out.println("=========================> i = " + i + " : " + mList.get(i));
        }
    }
    
    

}
