package com.example.test;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 测试不同屏幕面对对应的资源问题
 */
public class DensityActivity extends AppCompatActivity {

    private TextView imgvTest;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_density);
        imgvTest = findViewById(R.id.imgv_test);
        density();
    }
    
    public void onTest(View v) {
        
    }
    
    private void density() {
        // 获取屏幕密度（方法1）
        int screenWidth  = getWindowManager().getDefaultDisplay().getWidth();		// 屏幕宽（像素，如：480px）
        int screenHeight = getWindowManager().getDefaultDisplay().getHeight();		// 屏幕高（像素，如：800p）

        System.out.println("========================>  getDefaultDisplay screenWidth=" + screenWidth + "; screenHeight=" + screenHeight);


        // 获取屏幕密度（方法2）
        DisplayMetrics dm = new DisplayMetrics();
        dm = getResources().getDisplayMetrics();

        float density  = dm.density;		// 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        int densityDPI = dm.densityDpi;		// 屏幕密度（每寸像素：120/160/240/320）
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;

        System.out.println("========================>  DisplayMetrics xdpi=" + xdpi + "; ydpi=" + ydpi);
        System.out.println("========================>  DisplayMetrics density=" + density + "; densityDPI=" + densityDPI);

        screenWidth  = dm.widthPixels;		// 屏幕宽（像素，如：480px）
        screenHeight = dm.heightPixels;		// 屏幕高（像素，如：800px）

        System.out.println("========================>  DisplayMetrics(111) screenWidth=" + screenWidth + "; screenHeight=" + screenHeight);



        // 获取屏幕密度（方法3）
        dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        density  = dm.density;		// 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        densityDPI = dm.densityDpi;		// 屏幕密度（每寸像素：120/160/240/320）
        xdpi = dm.xdpi;
        ydpi = dm.ydpi;

        System.out.println("========================>  DisplayMetrics xdpi=" + xdpi + "; ydpi=" + ydpi);
        System.out.println("========================>  DisplayMetrics density=" + density + "; densityDPI=" + densityDPI);

        int screenWidthDip = dm.widthPixels;		// 屏幕宽（dip，如：320dip）
        int screenHeightDip = dm.heightPixels;		// 屏幕宽（dip，如：533dip）

        System.out.println("========================>  DisplayMetrics(222) screenWidthDip=" + screenWidthDip + "; screenHeightDip=" + screenHeightDip);

        screenWidth  = (int)(dm.widthPixels * density + 0.5f);		// 屏幕宽（px，如：480px）
        screenHeight = (int)(dm.heightPixels * density + 0.5f);		// 屏幕高（px，如：800px）

        System.out.println("========================>  DisplayMetrics(222) screenWidth=" + screenWidth + "; screenHeight=" + screenHeight);
    }
}