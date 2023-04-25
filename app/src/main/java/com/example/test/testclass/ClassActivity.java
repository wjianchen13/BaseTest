package com.example.test.testclass;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.uitls.Utils;

/**
 * Class 测试
 */
public class ClassActivity extends AppCompatActivity {

    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);
        tvTest = findViewById(R.id.tv_test);
        tvTest.requestFocus();
    }

    @NonNull
    public static <T extends IBase> void testClass(Class<T> cls) {
        if(cls != null) {
            String className = cls.getName();
            if(IBaseTest.class.getName().equals(className)) {
                Utils.log("IBaseTest.class");
            } else if(IBaseTest1.class.getName().equals(className)) {
                Utils.log("IBaseTest1.class");
            }

        }

    }



    /**
     *
     * @param v
     */
    public void onTest1(View v) {
        testClass(IBaseTest.class);
    }

    /**
     *
     * @param v
     */
    public void onTest2(View v) {
        testClass(IBaseTest1.class);
    }

    /**
     *
     * @param v
     */
    public void onTest3(View v) {

    }



}