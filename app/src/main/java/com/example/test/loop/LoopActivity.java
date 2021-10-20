package com.example.test.loop;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 循环需求
 */
public class LoopActivity extends AppCompatActivity {
    
    private List<Integer> mList = new ArrayList<>();
    
    private LoopManager mLoopManager;
    
    private TextView tvTest;
    
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            if(msg.what == 1) {
                Item item = LoopManager.getInstance().getItem();
                tvTest.setText("name: " + item.getName());
            }
        }
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loop);
        tvTest = findViewById(R.id.tv_test);
    }

    public void onTest1(View v) {
        LoopManager.getInstance().addData(getItems());
    }

    /**
     * 循环获取数据
     * @param v
     */
    public void onTest2(View v) {
        mHandler.sendEmptyMessageDelayed(1, 100);
    }
    
    private List<Item> getItems() {
        List<Item> data = new ArrayList<>();
        for(int i = 0; i < 5; i ++) {
            Item item = new Item(i + "");
            data.add(item);
        }
        return data;
    }

    /**
     * 插入数据
     * @param v
     */
    public void onTest3(View v) {
        Item item = new Item( "insert1");
        LoopManager.getInstance().insertItem(item);
    }

    /**
     * 插入数据
     * @param v
     */
    public void onTest4(View v) {
        Item item = new Item( "insert2");
        LoopManager.getInstance().insertItem(item);
    }
    
    /**
     * 插入数据
     * @param v
     */
    public void onTest5(View v) {
        Item item = new Item( "insert3");
        LoopManager.getInstance().insertItem(item);
    }

    /**
     * 插入数据
     * @param v
     */
    public void onTest6(View v) {
        Item item = new Item( "insert4");
        LoopManager.getInstance().insertItem(item);
    }

    /**
     * 插入数据
     * @param v
     */
    public void onTest7(View v) {
        Item item = new Item( "insert5");
        LoopManager.getInstance().insertItem(item);
    }

    /**
     * 插入数据
     * @param v
     */
    public void onTest8(View v) {
        Item item = new Item( "insert6");
        LoopManager.getInstance().insertItem(item);
    }

    /**
     * 插入数据
     * @param v
     */
    public void onTest9(View v) {
        Item item = new Item( "insert7");
        LoopManager.getInstance().insertItem(item);
    }

    /**
     * 插入数据
     * @param v
     */
    public void onTest10(View v) {
        Item item = new Item( "insert8");
        LoopManager.getInstance().insertItem(item);
    }

}
