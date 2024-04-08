package com.example.test.stackoverflowerror;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.uitls.Utils;

/**
 * Drawable镜像
 */
public class StackOverflowErrorActivity extends AppCompatActivity {

    private long count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stackoverflowerror);


    }

    public void onTest1(View v) {
        count = 0;
        test();
    }

    private void test() {
        try {
            Utils.log("count: " + count);
            count++;
            test();
        } catch (StackOverflowError err) {
            Toast.makeText(this, "StackOverflowError", Toast.LENGTH_SHORT).show();
        }
    }


}
