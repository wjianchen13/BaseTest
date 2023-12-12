package com.example.test.level;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.test.R;
import com.example.test.uitls.Utils;

/**
 * 测试 z坐标改变View的显示层级
 * https://blog.csdn.net/barryhappy/article/details/52700668
 */
public class ViewLevelActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgvTest1;
    private ImageView imgvTest2;
    private ImageView imgvTest3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        imgvTest1 = findViewById(R.id.imgv_test1);
        imgvTest2 = findViewById(R.id.imgv_test2);
        imgvTest3 = findViewById(R.id.imgv_test3);
        imgvTest1.setOnClickListener(this);
        imgvTest2.setOnClickListener(this);
        imgvTest3.setOnClickListener(this);
    }

    /**
     * bringToFront 测试
     * @param v
     */
    public void onTest1(View v) {
        imgvTest1.bringToFront();
    }

    /**
     * 打印Z坐标
     * @param v
     */
    public void onTest2(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            float z1 = imgvTest1.getZ();
            float z2 = imgvTest2.getZ();
            float z3 = imgvTest3.getZ();
            Utils.log("z1: " + z1 + "  z2: " + z2 + "  z3: " + z3); // z1: 2.75  z2: 5.5  z3: 8.25
            imgvTest1.setZ(1.0f);
        }
    }

    /**
     * 改变Z坐标
     * @param v
     */
    public void onTest3(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imgvTest2.setZ(1);
        }
    }

    /**
     * 改变Z坐标
     * @param v
     */
    public void onTest4(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            imgvTest2.setZ(3);
        }
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.imgv_test1) {
            Utils.showToast(this, "test1");
        } else if(v.getId() == R.id.imgv_test2) {
            Utils.showToast(this, "test2");
        } else if(v.getId() == R.id.imgv_test3) {
            Utils.showToast(this, "test3");
        }
    }
}
