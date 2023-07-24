package com.example.test.permission;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 跳转到权限界面详情
 * Android 跳转权限设置界面的终极方案
 * https://article.itxueyuan.com/RwA9rD
 *
 * Android App跳转权限设置页面工具类
 * https://blog.csdn.net/w497139412/article/details/122559490
 *
 * 通过ADB查看当前Activity
 * https://www.cnblogs.com/tangZH/p/10139371.html
 *
 */
public class PermissionActivity extends AppCompatActivity {
    
    private TextView tvTest;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        tvTest = findViewById(R.id.tv_test);
        
    }

    public void onTest1(View v) {
        PermissionUtil.getInstance(this).GoToSetting();
    }

    public void onTest2(View v) {

    }
    
}
