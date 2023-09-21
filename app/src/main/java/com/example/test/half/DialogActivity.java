package com.example.test.half;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

/**
 * 半屏Activity
 */
public class DialogActivity extends AppCompatActivity {

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        overridePendingTransition(R.anim.anim_slide_in_bottom, R.anim.no_anim);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.no_anim, R.anim.anim_slide_out_bottom);
    }

    public void onTest1(View v) {

    }

    /**
     * 
     * @param v
     */
    public void onTest2(View v) {

    }


    
}
