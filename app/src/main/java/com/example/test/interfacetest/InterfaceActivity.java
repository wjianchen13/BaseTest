package com.example.test.interfacetest;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

/**
 * 接口子类类型判断
 */
public class InterfaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface);

    }

    /**
     *
     */
    public void onTest1(View v) {
        Test t = new Test();
        boolean a = t instanceof ITest;
        System.out.println("=======================> a: " + a);
    }

    public void onTest2(View v) {

    }

    public void onTest3(View v) {

    }

    public void onTest4(View v) {

    }

    public void onTest5(View v) {

    }


}
