package com.example.test.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.loop.LoopManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 循环需求
 */
public class ParcelableActivity extends AppCompatActivity {

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);
//        tvTest = findViewById(R.id.tv_test);
    }

    public void onJump(View v) {
        Intent it = new Intent(this, ParcelableOtherActivity.class);
        it.putParcelableArrayListExtra("param", getDatas());
        startActivity(it);
    }
    
    private ArrayList<ActionDinoBean> getDatas() {
        ArrayList<ActionDinoBean> beans = new ArrayList<>();
        ActionDinoBean bean = new ActionDinoBean(1, "test1", "test1");
        beans.add(bean);
        bean = new ActionDinoBean(2, "test2", "test2");
        beans.add(bean);
        return beans;
    }
    


}
