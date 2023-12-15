package com.example.test;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.uitls.Utils;

/**
 * ViewStub判断
 */
public class ViewStubActivity extends AppCompatActivity {

    private View vsTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstub);

    }

    /**
     * 测试1
     * @param v
     */
    public void onTest1(View v) {
        vsTest = findViewById(R.id.llyt_test);
        boolean isViesStub = vsTest instanceof ViewStub;
        if(isViesStub) {
            ((ViewStub)vsTest).inflate();
        }
        Utils.log("isViesStub: " + isViesStub);
    }

    /**
     * 测试2
     * @param v
     */
    public void onTest2(View v) {
        View vs = findViewById(R.id.llyt_test);
        LinearLayout llytTest = null;
        if(vs instanceof ViewStub) {
            llytTest = (LinearLayout)((ViewStub)vs).inflate();
        } else if(vs instanceof LinearLayout) {
            llytTest = (LinearLayout) vs;
        }
        Utils.log("llytTest id: " + llytTest.getId());
    }

    /**
     * 测试3
     * @param v
     */
    public void onTest3(View v) {
        View view = findViewById(R.id.llyt_test);
        Utils.log("view id: " + (view != null ? view.getId() : 0));
    }

    /**
     * 测试4
     * @param v
     */
    public void onTest4(View v) {

    }

    /**
     * 测试5
     * @param v
     */
    public void onTest5(View v) {

    }

    /**
     * 测试6
     * @param v
     */
    public void onTest6(View v) {

    }


}
